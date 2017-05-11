package bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.sql.Date; 

public class DataInsert {

	
	
	public static void insert(DataFields df)
	{
		//OracleThinConnection object1 = new OracleThinConnection();
		//Statement s = null;
		Connection con = null;
		PreparedStatement ps = null;
		
		try
		{
			con = OracleThinConnection.getRequestConnection();
			
			if(con == null)
				System.out.println("Error");
			String s = "";
			for(int i = 0;i < 7;i++)
				s += "?,";
	        //String query = "insert into resume_test values(?,?,?,?,?)";
			String query = "insert into banking values("+ s + "?)";
	        //System.out.println("Query : " + query);
	        ps = con.prepareStatement(query);
	        
	        //name,address,college,state,email,phoneNo
	        
	        //Basic Information
	        //Long id = bean.IDGenerator.getID();
	        String id = bean.IDGenerator.getID();
	        System.out.println("DataInsert.jsp : ID :" + id);
	        ps.setString(1,id);
	        ps.setString(2,df.getFirstNameParam());
	        ps.setString(3,df.getLastNameParam());
	        ps.setString(4,df.getDescription());
	        ps.setString(5,df.getOpBalParam());
	        
	        String date = df.getOpDateParam();
	        //String date = "04-04-2017";
	 
	        System.out.println("DataInsert.jsp : Date :" + date);
	        
			if(date != null)
			{
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date dateUtil = sdf1.parse(date);
				java.sql.Date sqlDate = new java.sql.Date(dateUtil.getTime());
				System.out.println("DataInsert.jsp : SQLDate :" + sqlDate);
				ps.setDate(6, sqlDate);
/*		        java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		        System.out.println("ResumeDataInsert.jsp : Datesql :" + sqlDate);*/
		        ps.setDate(6,sqlDate);
			}
			else
			{
				System.out.println("DataInsert.jsp : Date ip is null. ");
				ps.setDate(6, null);
			}
	        
	        //Contact
	        ps.setLong(7,df.getMobileNoParam()); 
	        ps.setString(8, df.getPassword());
	        
	        ps.execute();
	        con.close();
		  
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
		
		System.out.println("Inserted successfully");
		
	}
	public static ResultSet retrieve(String mailID)
	{

		//OracleThinConnection object1 = new OracleThinConnection();
		Statement stm = null;
		ResultSet rs = null;
		Connection con = OracleThinConnection.getRequestConnection();
		try
		{
	      stm = con.createStatement();

	      String sql = "select * from resume where email = '" + mailID + "'";
	      rs = stm.executeQuery(sql);	      
	      //rs.close();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
