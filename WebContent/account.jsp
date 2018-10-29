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
<title>Insert title here</title>
</head>
<body>
<h1>Account Information:</h1>
<div id="div">
<table>
<tr><td>Username:</td><td>${sessionScope.cus.getUsername()}</td></tr>
<tr><td>First Name:</td><td>${sessionScope.cus.getFirstname()}</td></tr>
<tr><td>Last Name:</td><td>${sessionScope.cus.getLastname()}</td></tr>
<tr><td>Address:</td><td>${sessionScope.cus.getAddress()}</td></tr>
<tr><td>City:</td><td>${sessionScope.cus.getCity()}</td></tr>
<tr><td>Postal Code:</td><td>${sessionScope.cus.getPostalcode()}</td></tr>
</table>
</div>
<a href="home.jsp">Back</a>
</body>
</html>