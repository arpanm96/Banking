package bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;  
import java.sql.Date; 

public class DataInsert {

	
	
	public static String insert(DataFields df)
	{
		Connection con = null;
		PreparedStatement ps = null;
		String id = "";
		
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
	        Long val = df.getOpeningBalanceParam();
	        id = bean.IDGenerator.getID(df.getFirstNameParam(),df.getLastNameParam());
	        System.out.println("DataInsert.jsp : ID :" + id);
	        System.out.println("DataInsert.jsp : OpeningBalance :" + val);
	        
	        ps.setString(1,id);
	        ps.setString(2,df.getFirstNameParam());
	        ps.setString(3,df.getLastNameParam());
	        ps.setString(4,df.getDescription());
	        ps.setLong(5,val);
	        
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
		       // ps.setDate(6,sqlDate);
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
	        // 2000 is the initial min. deposit
	        System.out.println("DataInsert.jsp : Executed. ");
        	//Transactions t = new Transactions();
        	//depositAmount(id, (val + 2000) );
	        
		  
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
		
		System.out.println("Inserted successfully");
		return id;
		
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
