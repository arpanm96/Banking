package bean;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date; 

public class Transactions {

	final long NULLVALUE = 0;
	Connection con = OracleThinConnection.getRequestConnection();
	
	public void withdrawAmount(String acNo,long amt)
	{
		//Connection con = null;
		System.out.println("Done");
		PreparedStatement ps = null;
		
		try
		{
			
			if(con == null)
				System.out.println("Error");
			
			java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			
			String query = "insert into transaction values(?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1,acNo);
			ps.setLong(2, amt);
			//ps.setNull(3, java.sql.Types.INTEGER);
			ps.setLong(3, NULLVALUE);
			ps.setDate(4, sqlDate);
			
	        
	        ps.execute();
	        ps = null;
	        query = "update banking set opbal=" + (currentBalance(acNo) - amt) + " where ac like '" + acNo +"'";
	        ps = con.prepareStatement(query);
	        ps.executeUpdate();
		  
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
		
		System.out.println("Withdrawn successfully");
		
	}
	
	
	
	public  void depositAmount(String acNo,long amt)
	{
		//Connection con = null;
		
		System.out.println("Transactions.java : Done");
		PreparedStatement ps = null;
		if(amt < 1)
			return;
		
		try
		{
			
			if(con == null)
				System.out.println("Error");
			
			java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

			
			String query = "insert into transaction values(?,?,?,?)";
			ps = con.prepareStatement(query);
			ps.setString(1,acNo);
			//ps.setNull(2, java.sql.Types.INTEGER);
			ps.setLong(2, NULLVALUE);
			ps.setLong(3, amt);
			ps.setDate(4, sqlDate);
			
	        
	        ps.execute();
	        ps = null;
	        query = "update banking set opbal=" + (currentBalance(acNo) + amt) + " where ac like '" + acNo +"'";
	        ps = con.prepareStatement(query);
	        ps.executeUpdate();
		  
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
		
		System.out.println("Deposited successfully");
		
	}
	
	
	public ResultSet retrieve(String ac_no)
	{
		System.out.println("Transactions.java : AC - " + ac_no);
		Statement stm = null;
		ResultSet rs = null;
		Connection con2 = OracleThinConnection.getRequestConnection();
		try
		{
	      stm = con2.createStatement();
	    
	      String sql = "select * from transaction where ac='" + ac_no + "'" + " and rownum <= 10 order by dt desc";
	      rs = stm.executeQuery(sql);	      
	      //rs.close();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public ResultSet retrieveMonthly(String ac_no)
	{
		System.out.println("Transactions.java : ACNO - " + ac_no);
		Statement stm = null;
		ResultSet rs = null;
		Connection con2 = OracleThinConnection.getRequestConnection();
		try
		{
	      stm = con2.createStatement();

	      String sql = "select dt,count(*) from transaction where ac = '" + ac_no + "' group by dt";
	      rs = stm.executeQuery(sql);
	      if(rs == null)
	    	  System.out.println("Dint fetch anything");
	      //rs.close();
	    }
		catch(Exception e)
		{
			System.out.println("Error "+e.getMessage());
		}
		return rs;
	}
	
	
	public  long currentBalance(String acNo)throws Exception
	{
		long cur = 0;
		ResultSet rs = DataInsert.retrieve(acNo);
		
		if(rs.next())
		{
			 cur = rs.getLong("opbal");
		}
		return cur;
	}
}
