<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
    border-collapse: collapse;
    background-color: lightgrey;
}

table, th, td {
    border: 1px solid black;
}

body{
	font-family: sans-serif;
	border-left: 30%;
	background-color: lightblue;
	text-align: center;
}
table{
	 position: relative;
    left: 40%;
    
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="div">
<h1>Login</h1>
<form action="/Assignment3/Login" method="post">
<table>
<tr>
<td>Username:</td>
<td><input type="text" name="uname"><br></td>
</tr>
<tr><td>Password:</td>
<td><input type="password" name ="pword"><br></td></tr>
<tr><td><input type="submit" value="login"></td><td><input type="submit" value="sign in" formaction="signin.jsp"></td></tr>
</table>
</form>
</div>
</body>
</html>