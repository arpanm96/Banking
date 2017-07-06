<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="obj" class="bean.ConnectionBean" scope="session"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<%
String user = request.getParameter("ac");
String password = request.getParameter("pwd");
obj.setUserID(user);
obj.setPassword(password);
if(obj.check())
{
	
	System.out.println(user);
	session.setAttribute("ac_no", user);
%>
<jsp:forward page="Home.jsp"/>
<%
}
else
{
	out.println("Incorrect match! Retry!");
		
}
%>
<form action="Initial.jsp">
<button>Go back</button>
</form>
</body>
</html>