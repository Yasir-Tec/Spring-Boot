<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="newCable" method="post">
		Enter Sid:<input type="text" name="custid" placeholder="Enter Id" required><br><br>
		Select Base Pack:
		 <select name="basepack" required>
			    <option value="disco hindi">Disco Hindi</option>
			    <option value="Classical Magic">Classical Magic</option>
			    <option value="Western Goodies">Western Goodies</option>
 		 </select>
 		 
 		 Select Optional Pack:
		 <select name="optionpack">
			    <option value="Comedy">Comedy</option>
			    <option value="Sports">Sports</option>
 		 </select>
		
		<input type="submit" name="eid" value="submit"><br><br>	
	</form>
</div>
</body>
</html>