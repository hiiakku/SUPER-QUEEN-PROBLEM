import java.sql.Connection;
import java.sql.DriverManager;


public class DB 
{
	public static Connection cn;
	public static Connection mycon()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql:" +
					"//localhost:3306/my1","root","akki");		
		}
		catch(
Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cn;
		
		
	}

}
