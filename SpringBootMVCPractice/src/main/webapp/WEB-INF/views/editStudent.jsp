<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="/student/updateStudent" method="post">
   		   Student id : <input type="text" name="sid" id="sid" value="${s.sid}" readonly><br>
       Student name : <input type="text" name="sname" id="sname" value="${s.sname}"><br>
       Email: <input type="text" name="email" id="email" value="${s.email}"><br>

         <button type="submit" name="btn" id="btn">Update Student</button>
   
   
    
   </form>
</body>
</html>