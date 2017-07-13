package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDGenerator {

	public static String getID(String firstName,String lastName)
	{
		char a = firstName.charAt(0);
		char b = lastName.charAt(0);

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
		    
		      if(rs == null)
		      {
		    	  id += "0001";
		    	  System.out.println("IDGenerator.java : ID - " + id);
		    	  return id;
		      }
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
		      String p = String.format("%4s", ""+(Integer.parseInt(acNo) + 1)).replace(' ', '0');
		      id += p ;
			System.out.println("IDGenerator.java : ID - " + id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return id;
	}
}
