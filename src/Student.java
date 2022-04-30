
public class Student {
	private int id;
	private String fname;
	private String lname;
	private float spi;
	
	public Student(int id, String fname, String lname, float spi) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.spi = spi;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public float getSpi() {
		return spi;
	}

	public void setSpi(float spi) {
		this.spi = spi;
	}
	
	
}

