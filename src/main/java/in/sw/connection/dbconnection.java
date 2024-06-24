package in.sw.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbconnection 
{
  public static Connection getconnection()
  {
	  Connection con=null;
	  try
	  {
		  Class.forName("oracle.jdbc.driver.OracleDriver");
		  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Swadhin9090.");
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  return con;
  }
}
