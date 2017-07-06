package bean;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeTransaction
 */
@WebServlet("/HomeTransaction")

public class HomeTransaction extends HttpServlet {

@Override

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	System.out.println("Doneee");
 Transactions obj = new Transactions();
 //String acNo = (String)session.getAttribute("ac_no");

if (request.getParameter("button1") != null) {

	long amt = Long.parseLong( request.getParameter("depositParam"));
 obj.depositAmount("AM007",amt);

 }  else {

	 System.out.println("Servlet button error!");
 // some code

 }request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);

 }}