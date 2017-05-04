<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<form action="ProcessData.jsp" method="post">
<h2>BASIC INFORMATION</h2>

<div id="BasicInformation">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>First Name  	</th>
	<td><input type="text" name="firstNameParam"  value="${param.firstNameParam}" required/></td>
	<th>Last Name </th>
	<td><input type="text" name="lastNameParam" value="${param.lastNameParam}" required/></td>
</tr>
<tr>
	<th>Address : </th>
	<td><textarea placeholder="Enter address here..."  rows="3" cols="30" name="description" value="${param.description}" >
	</textarea></td>
</tr>
</table>
</div>
<br>
<div id="BalanceInformation">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>Opening Balance</th>
	<td><input type="text" name="openingBalanceParam"  value="${param.openingBalanceParam}" required/></td>
</tr>
<tr>
	<th>Opening Date</th>
	<td><input type="text" name="openingDateParam" value="${param.openingDateParam}" required/></td>
</tr>
<tr>
	<th>Mobile Number :   </th>
	<td><input type="number" name="mobileNoParam" value="${param.mobileNoParam}" /></td>
</tr>
</table>
</div>

<br>
<div id="BalanceInformation">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>A/C No:	</th>
	<td><input type="text" name="acParam"  value="${param.acParam}" required/></td>
</tr>
<tr>
	<th>Password: </th>
	<td><input type="password" name="passParam" value="${param.passParam}" required/></td>
</tr>
<tr>
	<th>Retype Password: </th>
	<td><input type="password" name="repassParam" value="${param.repassParam}" required/></td>
</tr>
</table>
</div>
<div id="Buttons">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</div>
</form>
</body>
</html>