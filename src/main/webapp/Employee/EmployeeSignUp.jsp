<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="background-color: black; color: white;">
<form action="SignUp" method="post">
	
	<label name ="name">Name</label>
	<input name = "name" type="text" required>
	<br>
	<br>
	<label name ="age">Age</label>
	<input name = "age" type="number">
	<br>
	<br>
	<label name ="email">Email</label>
	<input name = "email" type="text" required>
	<br>	
	<br>	
	<label name ="pwd">Password</label>
	<input name ="pwd" type="password" required>
	<br>	
	<br>	
	<label name ="sal">Salary</label>
	<input name ="sal" type="number">
	<br>	
	<br>	
	<label name ="designation">Designation</label>
	<input name ="designation" type="text">
	<br>	
	<br>	
	<label name ="doj">Date Of Joining</label>
	<input name ="doj" type="date">
	<br>	
	<br>	
	
	<button type="submit">SignUp</button>
	
	</form>
</body>
</html>