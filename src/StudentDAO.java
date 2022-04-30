
import java.sql.*;
import java.util.*;

public class StudentDAO {
	
	protected Connection getConnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/practical11", "root", "");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertStudent(Student student) throws SQLException {
		try {
			Connection con = getConnection();
			String insertQuery = "insert into studentData values (?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, student.getId());
			ps.setString(2, student.getFname());
			ps.setString(3, student.getLname());
			ps.setFloat(4, student.getSpi());
			ps.executeUpdate();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean updateStudent(Student student) throws SQLException {
		
		int rowsUpdated = 0;
		try {
			Connection con = getConnection();
			String updateQuery = "update studentData set fname = ?, lname = ?, spi = ? where id = ?;";
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setString(1, student.getFname());
			ps.setString(2, student.getLname());
			ps.setFloat(3, student.getSpi());
			ps.setInt(4, student.getId());
			rowsUpdated = ps.executeUpdate();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowsUpdated > 0;
	}
	
	public Student selectStudent(int id) throws SQLException {
		Student student = null;
		try {
			Connection con = getConnection();
			String selectQuery = "select * from studentData where id = ?;";
			PreparedStatement ps = con.prepareStatement(selectQuery);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				float spi = rs.getFloat("spi");
				student = new Student(id, fname, lname, spi);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}
	
	public List<Student> selectAllStudents() throws SQLException {
		List<Student> students = new ArrayList<>();
		try {
			Connection con = getConnection();
			String selectAllQuery = "select * from studentData;";
			PreparedStatement ps = con.prepareStatement(selectAllQuery);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String fname = rs.getString("fname");
				String lname = rs.getString("lname");
				float spi = rs.getFloat("spi");
				students.add(new Student(id, fname, lname,spi));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return students;
	}
	
	public boolean deleteStudent(int id) throws SQLException {
		int rowsDeleted = 0;
		try {
			Connection con = getConnection();
			String deleteQuery = "delete from studentData where id = ?;";
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1, id);
			rowsDeleted = ps.executeUpdate();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		return rowsDeleted > 0;
	}
}