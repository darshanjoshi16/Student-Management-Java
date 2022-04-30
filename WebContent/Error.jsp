<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error occured</title>
</head>
<body>
	<div align="center">
		<h1>Error occured:</h1> <br>
		<h2><%= exception.getMessage() %></h2>
	</div>
</body>
</html>