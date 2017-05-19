package bean;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IDGenerator {

	public static String getID(String firstName,String lastName)
	{
		char a = firstName.charAt(0);
		char b = lastName.charAt(0);

		String id = a + "" + b;
		
		Statement stm = null;
		ResultSet rs = null;
		Connection con = OracleThinConnection.getRequestConnection();
		try
		{
		      stm = con.createStatement();
	
		      String sql = "select count(ac) as account_no from banking where ac like '" + id + "%'";
		      rs = stm.executeQuery(sql);	      
		    
		      
		      if(rs.next())
		      {
			      int count= rs.getInt("account_no");
/*			      String padding = "";
			      if(count < 10)
			    	  padding = "000";
			      else 
			    	  padding = "00";*/
			      
			      String p = String.format("%4s", ""+(count + 1)).replace(' ', '0');
			      
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
