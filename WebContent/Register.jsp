<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Registration</title>
<style>
	.jumbotron{
		padding-bottom:5px;
		
	}
	body{
		background-image:url('Bank1.jpg');
	}

</style>
</head>
<body >
<div class="container">
<div class="jumbotron">
<form action="ProcessData.jsp" method="post">
<h2>BASIC INFORMATION</h2>

<div id="BasicInformation">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>First Name  	</th>
	<td><input type="text" name="firstNameParam"  value="${param.firstNameParam}" /></td>
	<th>Last Name </th>
	<td><input type="text" name="lastNameParam" value="${param.lastNameParam}" /></td>
</tr>
<tr>
	<th>Address : </th>
	<td><textarea placeholder="Enter address here..."  rows="3" cols="30" name="description" value="${param.description}" >
	</textarea></td>
</tr>
</table>
</div>
<br>
<h2>BALANCE INFORMATION</h2>
<div id="BalanceInformation">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>Opening Balance</th>
	<td><input type="text" name="openingBalanceParam"  value="${param.openingBalanceParam}" required/></td>
</tr>
<tr>
	<th>Opening Date</th>
	<td><input type="date" name="openingDateParam" value="${param.openingDateParam}" /></td>
</tr>
<tr>
	<th>Mobile Number :   </th>
	<td><input type="number" name="mobileNoParam" value="${param.mobileNoParam}" /></td>
</tr>
</table>
</div>

<br>
<h2>DETAILS</h2>
<div id="Details">
<table border="1" cellspacing="20" cellpadding="5" >
<tr>
	<th>A/C No:	</th>
	<td><input type="text" name="acParam"  value="${param.acParam}" /></td>
</tr>
<tr>
	<th>Password: </th>
	<td><input type="password" name="passParam" value="${param.passParam}" /></td>
</tr>
<tr>
	<th>Retype Password: </th>
	<td><input type="password" name="repassParam" value="${param.repassParam}" /></td>
</tr>
</table>
</div>
<div id="Buttons">
<input type="submit" value="Submit" class="btn btn-info">
<input type="reset" value="Reset" class="btn btn-warning">
</div>
</form>
</div>
</div>
</body>
</html>