<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Student</title>
</head>
<body>
<h1>Product Details</h1>
<table border="2">
  <tr >
     <th>Student pid</th>
     <th>Student pname</th>
     <th>Student email</th>
     <th>action</th>
  </tr>
  <c:forEach var="s" items="${sslist}">
     <tr>
       <td>${s.sid}</td>
       <td>${s.sname}</td>
       <td>${s.email}</td>
       <td><a href="delete/${s.sid}">delete</a>
       /
       <a href="edit/${s.sid}">edit</a></td>
     </tr>
  </c:forEach>
</table>
<a href="addStudent">Add new Product</a>
</body>
</html>