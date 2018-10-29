<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body{
	font-family: sans-serif;
	border-left: 30%;
	background-color: lightblue;
	text-align: center;
}
table{
	 position: relative;
    left: 40%;
        background-color: lightgrey;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter updated information:</title>
</head>
<body>
<form action="/Assignment3/Edit">
<table>
<tr><td>Username:</td><td><input type="text" name="uname"></td></tr>
<tr><td>Password:</td><td><input type="password" name="pword"></td></tr>
<tr><td>First Name:</td><td><input type="text" name="fname"></td></tr>
<tr><td>Last Name:</td><td><input type="text" name="lname"></td></tr>
<tr><td>Address:</td><td><input type="text" name="add"></td></tr>
<tr><td>City:</td><td><input type="text" name="city"></td></tr>
<tr><td>Postal Code:</td><td><input type="text" name="pcode"></td></tr>
</table>
<input type="submit">
</form>
</body>
</html>