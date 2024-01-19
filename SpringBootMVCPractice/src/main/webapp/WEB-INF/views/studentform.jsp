<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	  <form action="insertStudent" method="post">
       Student id : <input type="text" name="sid" id="sid"><br>
       Student name : <input type="text" name="sname" id="sname"><br>
       Email: <input type="text" name="email" id="email"><br>

         <button type="submit" name="btn" id="btn">Add new Student</button>
   </form>
</body>
</html>