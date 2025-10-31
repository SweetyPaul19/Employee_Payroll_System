<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="regform" method="post">
	first name: <input type="text" name="name1"/><br><br>
	last name:<input type="text" name="name2"/><br><br>
	password:<input type="password" name="pass1"/><br><br>
	male<input type="radio" name="gender1"/>female<input type="radio" name="gender1"/><br><br>
	
	<select name="city1">
		<option>select city</option>
		<option>Delhi</option>
		<option>Mumbai</option>
		<option>Pune</option>
		<option>Bangalore</option>
	</select><br><br>
	<input type="submit" value="register"/>		
	</form>
</body>
</html>