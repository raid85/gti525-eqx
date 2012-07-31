package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpectacleDAO {
	String driver = "driverICI";
	String url = "URLICI";
	String user = "USERICI";
	String pass = "passICI";
	
	private int update(String requete) throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stmt = conn.createStatement();
		stmt.close();
		return stmt.executeUpdate(requete);
	}
	
	private ResultSet executeQuerry(String requete) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pass);
		Statement stmt = conn.createStatement();
		stmt.close();
		return stmt.executeQuery(requete);
		
	}
	

}
