<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Report</title>
</head>
<body>
<center><h1><b>Customer Details</b></h1></center>
<div align="center">

	<table border="2">
		<thead>
			<tr>
				<th>Customer No</th>
				<th>Base Pack</th>
				<th>Optional Pack</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach var="c" items="${clist}">
			<tbody>
			<tr>
				<td><a href="getDataById/${c.custid}">${c.custid}</a></td>
				<td>${c.basepack}</td>
				<td>${c.optionpack}</td>
				<td><a href="delete/${c.custid}">Delete</a> | <a href="edit/${c.custid}">Edit</a></td>
			</tr>
			</tbody>
		</c:forEach>
	</table>
	<a href="addNewCable">Add New Cable</a>
</div>
</body>
</html>