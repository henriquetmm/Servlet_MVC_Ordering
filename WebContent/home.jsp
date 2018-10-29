<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.bar {
    background-color: #333;
    overflow: hidden;
}


.bar a {
    float: left;
    color: #f2f2f2;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none; 
    font-size: 17px;
}


.bar a:hover {
    background-color: #ddd;
    color: black;
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
<div class="bar" id="mybar">
  <a href="/Assignment3/account.jsp">Account</a>
  <a href="/Assignment3/editaccount.jsp">Edit Account</a>
  <a href="/Assignment3/createorder.jsp">Order</a>
  <a href="/Assignment3/viewoeders.jsp">View Orders</a>
  <a href="/Assignment3/editorder.jsp">Search and Edit Orders</a>
  <a href="/Assignment3/error.jsp">Logout</a>
</div>
<h2>Wellcome, ${sessionScope.cus.getUsername()}</h2>

</body>
</html>