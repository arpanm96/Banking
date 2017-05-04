package bean;

import java.sql.*;
public class OracleThinConnection {

		public static Connection getRequestConnection()
		{
	        String driver = "oracle.jdbc.driver.OracleDriver";
	        String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Connection con = null;
			try
			{
				Class.forName(driver);
				con = DriverManager.getConnection(url,"arpan","arpan");
				if(con != null)
					System.out.println("Connected successfully to oracle");
				else
					System.out.println("Connection failure");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return con;
	}
	

}
