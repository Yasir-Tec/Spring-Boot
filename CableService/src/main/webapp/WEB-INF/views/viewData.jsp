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
<center><h1><b>Customer Data</b></h1></center>
<div align="center">

	<table border="2">
		<thead>
			<tr>
				<th>Customer No</th>
				<th>Base Pack</th>
				<th>Optional Pack</th>
				
			</tr>
		</thead>
	
			<tbody>
			<tr>
				<td>${c.custid}</td>
				<td>${c.basepack}</td>
				<td>${c.optionpack}</td>
				
			</tr>
			</tbody>
	
	</table>
	
</div>
</body>
</html>