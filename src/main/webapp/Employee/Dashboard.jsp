<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<h2>Login Successful </h2>
<h2>Welcome! ${emp.name}</h2>

<form action="Update" method="post">
	
	<label name ="name">Name</label>
	<input name = "name" type="text" required value="${emp.name}">
	<br>
	<br>
	<label name ="age">Age</label>
	<input name = "age" type="number" value="${emp.age}">
	<br>
	<br>
	<label name ="email">Email</label>
	<input name = "email" type="text" required value="${emp.email}">
	<br>	
	<br>	
	<label name ="pwd">Password</label>
	<input name ="pwd" type="password" required value="${emp.pwd}">
	<br>	
	<br>	
	<label name ="sal">Salary</label>
	<input name ="sal" type="number" value="${emp.sal}">
	<br>	
	<br>	
	<label name ="designation">Designation</label>
	<input name ="designation" type="text" value="${emp.designation}">
	<br>	
	<br>	
	<label name ="doj">Date Of Joining</label>
	<input name ="doj" type="date" value="${emp.doj}">
	<br>	
	<br>	
	<input type="hidden" name ="id" type="number" value="${emp.id}">
	<br>	
	<br>	
	
	<button type="submit">Update</button>
	
	</form>
</body>
</html>