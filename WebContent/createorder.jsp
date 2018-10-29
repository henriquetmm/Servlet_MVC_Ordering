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
<body><h1>Enter information</h1>
<form action="/Assignment3/Createorder">
<table>
<tr><td>Item Name:</td><td><input type="text" name="iname"></td></tr>
<tr><td>Price: </td><td><input type="text" name="price"></td></tr>
<tr><td>Quantity:</td><td><input type="text" name="quantity"></td></tr>
</table>
<input type="submit" value="Place Order">
</form>

</body>
</html>