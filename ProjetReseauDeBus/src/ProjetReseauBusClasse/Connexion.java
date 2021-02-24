package ProjetReseauBusClasse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connexion {

public static Connection conn = null;
private static String user = "root";
private static String password = "";
private static String url ="jdbc:mysql://localhost:3306/projetreseaubus"; 
private static Properties props;
public Connexion() {
	
}


public static Connection getConnection()
{
	if(conn == null)
	{
		props = new Properties(); 
		props.setProperty("user",user); 
		props.setProperty("password",password); 
		props.setProperty("ssl","true");
		
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (Exception ex) {
			System.out.println("Erreur du pilot !!!");	
			}


		try {
		    conn = DriverManager.getConnection(url, props);
		   

			} catch (SQLException ex) {
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
	
	
	
	return conn;
}
	
}
