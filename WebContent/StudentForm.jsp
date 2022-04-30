<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Student Management System</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: #242B2E">
			<div>
				<a href="http://localhost:8080/StudentManagement/student-form.jsp" class="navbar-brand">Student Management System</a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/studentList.jsp"
					class="nav-link">Students</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${student != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${student == null}">
				<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${student != null}">
            			Edit Student Details
            		</c:if>
						<c:if test="${student == null}">
            			Add New Student
            		</c:if>
					</h2>
				</caption>

				<fieldset class="form-group">
					<label>Student id: </label> <input type="text"
						value="<c:out value='${student.id}' />" class="form-control"
						name="id" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>First Name: </label> <input type="text"
						value="<c:out value='${student.fname}' />" class="form-control"
						name="fname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Last Name: </label> <input type="text"
						value="<c:out value='${student.lname}' />" class="form-control"
						name="lname">
				</fieldset>

				<fieldset class="form-group">
					<label>SPI: </label> <input type="text"
						value="<c:out value='${student.spi}' />" class="form-control"
						name="spi">
				</fieldset>

				<button type="submit" class="btn btn-success">Save Changes</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>