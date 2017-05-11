<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page import="bean.CheckFields" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Process Data</title>
</head>
<body>
<%


Boolean flag = true;

CheckFields obj = new CheckFields();
String firstName = "";

if(request.getParameter("firstNameParam") != null)
{
  
	firstName = request.getParameter("firstNameParam");
  
}
//Basic Information
String lastName = request.getParameter("lastNameParam");
String address = request.getParameter("description");
String opBalance = request.getParameter("openingBalanceParam");
String opDate = request.getParameter("openingDateParam");
String PhoneNo = request.getParameter("mobileNoParam");
String account = request.getParameter("acParam");
String password = request.getParameter("passParam");
String repassword = request.getParameter("repassParam");

//Basic Information
if(firstName != "" && !obj.checkString(firstName))
{
	System.out.println("First Name wrong i/p");
	flag = false;
	firstName = "";
}
if(!obj.checkString(lastName))
{
	System.out.println("Last Name wrong i/p");
	flag = false;
	lastName = "";
}

if( PhoneNo != "" &&  PhoneNo.length() != 10)
{
	System.out.println("PhoneNo wrong i/p.");
	flag = false;
	PhoneNo = "";
}

if( !password.equals(repassword))
{
	System.out.println("Confirmation Password wrong i/p.");
	flag = false;
	password = repassword = "";
}

String fileToBeForwarded="";
if(!flag)
{
	 System.out.println("ProcessData.jsp : Error in ip. Redirecting to FormFile.jsp");
	 fileToBeForwarded="Register.jsp";
}
else
{
	 //fileToBeForwarded="DisplayFile.jsp";
	 System.out.println("ProcessData.jsp : Data ip(OK)");
	 fileToBeForwarded="SubmitData.jsp";
}

%>

<jsp:forward page="<%=fileToBeForwarded %>">

<jsp:param  name="firstNameParam" value="<%=firstName %>"/>
<jsp:param  name="lastNameParam" value="<%=lastName %>"/>
<jsp:param  name="mobileNoParam" value="<%=PhoneNo %>"/>

<jsp:param  name="openingBalanceParam" value="<%=opBalance %>"/>
<jsp:param  name="openingDateParam" value="<%=opDate %>"/>
<jsp:param  name="acParam" value="<%=account %>"/>
<jsp:param  name="passParam" value="<%=password %>"/>
<jsp:param  name="repassParam" value="<%=repassword %>"/>

</jsp:forward>

</body>
</html>