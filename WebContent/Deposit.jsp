<%@ page language="java" import="bean.*" %>
<jsp:useBean id="obj" class="bean.Transactions"></jsp:useBean>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deposit</title>
</head>
<body>
<%
	System.out.println("Doneee");
	long amt = Long.parseLong( request.getParameter("depositParam"));
	if(amt > 0)
	{
		String acNo = (String)session.getAttribute("ac_no");
		obj.depositAmount(acNo,amt);
	}
%>
<jsp:forward page="Home.jsp"/>
</body>
</html>