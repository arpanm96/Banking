<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="bean.*,java.sql.ResultSet"%>
    <jsp:useBean id="obj" class="bean.Transactions" scope="session"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
System.out.println("Withdraw.jsp : Doneee");
long amt = Long.parseLong( request.getParameter("withdrawParam"));
if(amt > 0)
{
	String acNo = (String)session.getAttribute("ac_no");
	long cur = obj.currentBalance(acNo);
		if((cur - amt) > 2000)
			obj.withdrawAmount(acNo,amt);
		else
			System.out.println("Insufficient funds!");
	
}
%>
<jsp:forward page="Home.jsp"/>
</body>
</html>