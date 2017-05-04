<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
</head>
<body>
<img src="bank.jpg" alt="BANK" height="300" width="420">
<br>
<form action="HomePage.jsp" method="post">
User ID : <input type = "text" name="userID" required><br><br>
Password : <input type = "password" name="password" required><br><br>
<input type = "submit" value="SIGN IN"><br><br>
</form>
<form action="Register.jsp" method="post">
<input type = "submit"  value="SIGN UP"></form>
</body>
</html>