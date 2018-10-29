<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}

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

<table>
<tr><td>Orderid</td><td>Customer id</td><td>Item</td><td>Price</td><td>Quantity</td><td>Date</td></tr>
<c:forEach var="item" items="${ord}">
	<tr><td>${item.orderid}</td><td>${item.customerid}</td><td>${item.itemname}</td><td>${item.price}</td><td>${item.quantity}</td><td>${item.date}</td></tr>	
	</c:forEach>
</table>
<a href="home.jsp">Back</a>
</body>
</html>