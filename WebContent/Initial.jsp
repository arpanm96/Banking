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
<title>Homepage</title>
</head>

<body background="nice-background-pattern-200.gif" >

<%
String ac=(String)session.getAttribute("ac_no");
        
        //redirect user to home page if already logged in
        if(ac != null)
        {
            response.sendRedirect("Home.jsp");
        }
%>        
<div class="container">
  <h2>Login form</h2>
  <form class="form-horizontal" action="LoginCheck.jsp" method="post">
    <div class="form-group">
      <label class="control-label col-sm-2" for="ac">Account No.:</label>
      <div class="col-sm-3">
        <input type="text" class="form-control" id="ac" placeholder="Enter account no." name="ac" required>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-3">          
        <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <div class="checkbox">
          <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
      </div>
    </div>
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Log In</button>
      </div>
    </div>
  </form>
  <form action="Register.jsp" method="post">
    <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="submit" class="btn btn-default">Sign Up</button>
      </div>
    </div>
  </form>
</div>

</body>

</html>