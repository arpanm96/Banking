<%@page import="bean.*,java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<jsp:useBean id="obj" class="bean.Transactions"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home Page</title>
</head>
<body>

Welcome , 
<% 
String acNo = (String)session.getAttribute("ac_no");
out.println(ConnectionBean.getName(acNo)); 

%>
<a href="Initial.jsp">Logout</a>
<img src="" alt="Home Page" >
  
<div class="container">

  <!-- Deposit -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#deposit">Deposit</button>

	  <!-- Modal -->
	        
	  <div class="modal fade" id="deposit" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Deposit</h4>
	        </div>
			
	        <div class="modal-body">
			<form action="Deposit.jsp">
			<div class="form-group">
	          <input type="number" name="depositParam" placeholder="Enter amount" width="300px" required>
	        </div>
	          <div class="modal-footer">
	       
	          <input type="submit" class="btn btn-success" name="button1" value="Submit" data-dismiss="modal">
	        </div>
	        </form>
	      </div> 
	      </div>    
	    </div>
	  </div>



<br><br>	  
	        
<!--   
  <!-- Withdraw -->
  <form action="Withdraw.jsp" method="post">
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#withdraw">Withdraw</button>

	  <!-- Modal -->
	  <div class="modal fade" id="withdraw" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Withdraw</h4>
	        </div>
	        <div class="modal-body">
	          <input type="text" name="withdrawParam" placeholder="Enter amount" width="300px">
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" data-dismiss="modal">Done</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>     
	    </div>
	  </div>
</form>
<br><br>	  

  <!-- Balance Enquiry -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#balance">Balance Enquiry</button>

	  <!-- Modal -->
	  <div class="modal fade" id="balance" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Balance Enquiry</h4>
	        </div>
	        <div class="modal-body">
	          <p>Current balance is : <%=obj.currentBalance(acNo) %></p> 
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" data-dismiss="modal">Done</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>     
	    </div>
	  </div>
  
<br><br>

  <!-- Last 10 transactions -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#transaction">Last 10 transactions</button>

	  <!-- Modal -->
	  <div class="modal fade" id="transaction" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Last 10 transactions</h4>
	        </div>
	        <div class="modal-body">
	          <p>
					<%
					ResultSet rs = obj.retrieve(acNo);
					
					boolean flag = true;
					
					if(!rs.next()) {
					    out.println("data for this acc no not found in database! Try Again! ");
					    flag = false;
					} 
					else
					{
						do
						{
							System.out.println("Home.jsp : Retrieved successfully");					  
					%>
	          
			          <table border="1" align="center">
			            <tr>
			               <th>First Name</th>
			               <th>Withdraw amount</th>
			               <th>Deposit Amount</th>
			               <th>Date</th>
			           </tr>
						<tr>
			               <td> <%= rs.getString(1) %> </td>
			               <td> <%= rs.getString(2) %> </td>
			               <td> <%= rs.getString(3) %> </td>
			               <td> <%= rs.getString(4) %> </td>
					    </tr>
					<br>
					<% 
									
						}while(rs.next()); 
					}
					rs.close();
					%>
					</table>

			</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" data-dismiss="modal">Done</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>     
	    </div>
	  </div>
	  
<br><br>	  
	  
  <!-- Update Info -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#update">Update Info</button>

	  <!-- Modal -->
	  <div class="modal fade" id="update" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Update Info</h4>
	        </div>
	        <div class="modal-body">
	          <p>Some text in the modal.</p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" data-dismiss="modal">Done</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>     
	    </div>
	  </div>
	  
	  
<br><br>  
	  
  <!-- Monthly Statements -->
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#monthly">Monthly Statements</button>

	  <!-- Modal -->
	  <div class="modal fade" id="monthly" role="dialog">
	    <div class="modal-dialog">
	    
	      <!-- Modal content-->
	      <div class="modal-content">
	        <div class="modal-header">
	          <button type="button" class="close" data-dismiss="modal">&times;</button>
	          <h4 class="modal-title">Monthly Statements</h4>
	        </div>
	        <div class="modal-body">
	          <p>
					<%
					ResultSet rs1 =obj.retrieveMonthly(acNo);
					
					boolean flag11 = true;
					
					if(!rs1.next()) {
					    out.println("data for this acc no not found in database! Try Again! ");
					    flag = false;
					} 
					else
					{
						do
						{
							System.out.println("Home.jsp : Retrieved successfully");					  
					%>
	          
			          <table border="1" align="center">
			            <tr>
			               <th>Date</th>
			               <th>Count</th>
			           </tr>
						<tr>
			               <td> <%= rs1.getString(1) %> </td>
			               <td> <%= rs1.getString(2) %> </td>
					    </tr>
					<br>
					<% 
									
						}while(rs.next()); 
					}
					rs.close();
					%>
					</table>
	        
	        </p>
	        </div>
	        <div class="modal-footer">
	          <button type="button" class="btn btn-success" data-dismiss="modal">Done</button>
	          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        </div>
	      </div>     
	    </div>
	  </div>


<br><br>
</div> 

</body>
</html>