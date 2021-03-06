package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDGenerator {

	public static String getID(String firstName,String lastName)
	{
		char a = Character.toUpperCase(firstName.charAt(0));
		char b = Character.toUpperCase(lastName.charAt(0));

		String id = a + "" + b,acNo = "";
		
		Statement stm = null;
		ResultSet rs = null;
		Connection con = OracleThinConnection.getRequestConnection();
		try
		{
		      stm = con.createStatement();
	
		      //String sql = "select count(ac) as account_no from banking where ac like '" + id + "%'";
		      String sql = "select ac as account_no from banking where ac like '" + id + "%'";
		      rs = stm.executeQuery(sql);	      
		    
/*		      if(rs == null)
		      {
		    	  System.out.print("IDGenerator.java : Didn't match any result of previous names : ");
		    	  id += "0001";
		    	  System.out.println("IDGenerator.java : ID - " + id);
		    	  return id;
		      }*/
		      while(rs.next())
		      {
			      //int count= rs.getInt("account_no");
/*			      String padding = "";
			      if(count < 10)
			    	  padding = "000";
			      else 
			    	  padding = "00";*/
			      acNo = rs.getString("account_no").substring(2);
			  
			      
		      }
		      if(acNo.equals(""))			// for 1st time entries
		      {
		    	  System.out.println("IDGenerator.java : Didn't match any result of previous names : ");
		    	  id += "0001";		    	
		      }
		      else
		      {
		    	  String p = String.format("%4s", ""+(Integer.parseInt(acNo) + 1)).replace(' ', '0');
		    	  	id += p ;
		      }
			System.out.println("IDGenerator.java : ID - " + id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
}
