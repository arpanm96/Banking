package bean;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RegisterUser {

	
	public static void insertUser(String user,String pass)
	{
		//OracleThinConnection object1 = new OracleThinConnection();
		//Statement s = null;
		Connection con = null;
		PreparedStatement ps = null;
		System.out.println(user + " , " + pass);
		try
		{
			con = OracleThinConnection.getRequestConnection();
			
			if(con == null)
				System.out.println("Error");
			String s = "";
	        //String query = "insert into resume_test values(?,?,?,?,?)";
			String query = "insert into login values(?,?)";
	        System.out.println("Query : " + query);
	        ps = con.prepareStatement(query);
	        
	        //name,address,college,state,email,phoneNo
	        
	        //Basic Information
	        ps.setString(1,user);
	        ps.setString(2,pass);
	       
	        ps.execute();
	        con.close();	        
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
