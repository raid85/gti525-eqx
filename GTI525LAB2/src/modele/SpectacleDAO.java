package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.org.apache.regexp.internal.recompile;

public class SpectacleDAO {
	private static String driver = "org.sqlite.JDBC";
	private static String url = "jdbc:sqlite:C:/Users/bruce/workspace/GTI525LAB2/Data/GTI525";
	private static ResultSet rs;
	
	private static ResultSet executeQuerry(String requete) throws ClassNotFoundException, SQLException{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url);
		Statement stmt = conn.createStatement();
		stmt.close();
		return stmt.executeQuery(requete);	
	}
		
	public static Spectacle[] getSpectacles() throws ClassNotFoundException, SQLException{
		rs = executeQuerry("SELECT COUNT(*) FROM Spectacle");
		rs.next();
		int rowCount = (Integer) rs.getObject(1);
		rs = executeQuerry("SELECT Spectacle.ID_Spectacle, Spectacle.Nom, Spectacle.Description, Spectacle.Image FROM Spectacle");
		Spectacle[] tableauSpectacles = new Spectacle[rowCount];
		int i = 0;
		while ( rs.next() ) {
			Spectacle spectacle = new Spectacle();
            spectacle.setId((Integer) rs.getObject(1));
            spectacle.setNom((String) rs.getObject(2));
            spectacle.setDescription((String) rs.getObject(3));
            spectacle.setImage((String) rs.getObject(4));
            tableauSpectacles[i] = spectacle;
            i++;
		}
		return tableauSpectacles;
	}
	
	public static TORepresentations getRepresentations(int idSpectacle) throws ClassNotFoundException, SQLException, ClassCastException{
		TORepresentations monTO= new TORepresentations();
		rs = executeQuerry("SELECT Spectacle.Nom, Spectacle.Description, Spectacle.Image FROM Spectacle WHERE Spectacle.ID_Spectacle = " + idSpectacle);
		Spectacle monSpectacle = new Spectacle();
		monSpectacle.setNom((String) rs.getObject(1));
		monSpectacle.setDescription((String) rs.getObject(2));
		monSpectacle.setImage((String) rs.getObject(3));
		
		monTO.setSpectacle(monSpectacle);
		rs = executeQuerry("SELECT COUNT(*) FROM Representation JOIN Salle USING (ID_Salle) WHERE Representation.ID_Spectacle = " + idSpectacle);
		rs.next();
		int rowCount = (Integer) rs.getObject(1);
		rs = executeQuerry("SELECT Representation.ID_Rep, Representation.BilletDispo, Representation.Date, Representation.Prix, " +
				"Salle.Nom FROM Representation JOIN Salle USING (ID_Salle) WHERE Representation.ID_Spectacle = " + idSpectacle);
		Representation[] tableauRepresentations = new Representation[rowCount];
		
		int i = 0;
		while ( rs.next() ) {
			Representation representation = new Representation();
			representation.setId((Integer) rs.getObject(1));
			representation.setBilletsDispo((Integer) rs.getObject(2));
			representation.setDate(new Date(Long.parseLong( (String) rs.getObject(3))));
			representation.setPrix((Integer) rs.getObject(4));
			representation.setSalle(new Salle((String)rs.getObject(5)));
			tableauRepresentations[i] = representation;
            i++;
		}
		monTO.setRepresentations(tableauRepresentations);
		return monTO;
	}
	
	public static int getNbBilletsDispo(int idRepresentation) throws ClassNotFoundException, SQLException{
		rs = executeQuerry("SELECT BilletDispo FROM Representation WHERE ID_Rep = " + idRepresentation);
		rs.next();
		return (Integer) rs.getObject(1);
		
	}
	
	public static Representation getRep(int idRepresentation) throws ClassNotFoundException, SQLException{
		rs = executeQuerry("SELECT * FROM Representation WHERE ID_Rep = " + idRepresentation);
		rs.next();
		Representation maRep = new Representation();
		maRep.setBilletsDispo((Integer) rs.getObject(3));
		maRep.setDate(new Date(Long.parseLong( (String) rs.getObject(4))));
		maRep.setId(idRepresentation);
		maRep.setPrix((Integer) rs.getObject(5));
		return maRep;
		
	}
	
		
}
	
