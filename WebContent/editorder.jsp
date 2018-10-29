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
<h3>Enter a Order ID to search and Edit:</h3>
<form action="/Assignment3/Editorder">
<input type="text" name="id">
<input type="submit" value="search">
</form>
</body>
</html>