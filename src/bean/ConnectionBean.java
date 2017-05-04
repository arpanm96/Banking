package bean;
import java.sql.*;

public class ConnectionBean {
	String userID;
	String password;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean check()
	{
		boolean flag = false;
		//OracleThinConnection object1 = new OracleThinConnection();
		Statement stm = null;
		Connection con = OracleThinConnection.getRequestConnection();
		try
		{
	      stm = con.createStatement();

	      String sql = "SELECT * FROM LOGIN";
	      ResultSet rs = stm.executeQuery(sql);	      
	      while(rs.next())
	      {	       
	         String user = rs.getString("username");
	         String pw = rs.getString("password");

	         if(user.equals(userID) && pw.equals(password) )
	         {
	        	flag = true;
	         }     	 
	      }
	      rs.close();
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	   }
     	return flag;
	}
}
