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
			String query = "insert into banking values("+ s + "?)";

	        ps = con.prepareStatement(query);
	        
	        String id = bean.IDGenerator.getID(df.getFirstNameParam(),df.getLastNameParam());
	        System.out.println("DataInsert.jsp : ID :" + id);
	        ps.setString(1,id);
	        ps.setString(2,df.getFirstNameParam());
	        ps.setString(3,df.getLastNameParam());
	        ps.setString(4,df.getDescription());
	        ps.setLong(5,df.getOpeningBalanceParam());
	        
	        String date = df.getOpeningDateParam();
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
	        ps.setLong(7,df.getMobileNoParam()); 
	        ps.setString(8, df.getPassParam());
	        
	        ps.execute();
	        con.close();
		  
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
		
		System.out.println("Inserted successfully");
		
	}
	public static ResultSet retrieve(String ac_no)
	{

		Statement stm = null;
		ResultSet rs = null;
		Connection con = OracleThinConnection.getRequestConnection();
		try
		{
	      stm = con.createStatement();

	      String sql = "select * from banking where ac = '" + ac_no + "'";
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
