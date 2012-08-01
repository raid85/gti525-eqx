package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe pour le patron Delegate
 * Utilise le DAOlocal modele.Collection
 * @author Riad Chebli
 * @version 07/15/2012
 */

public class DelegateSpectacles {
	static modele.Collection col = new modele.Collection();
	

	public static modele.Collection getCollection() {
		return col.getCollection();
		
	}
	public static Spectacle[] getSpectacles() throws ClassNotFoundException, SQLException {
		//SpectacleDAO.test();
		SpectacleDAO.getSalle(2001);
		return col.getSpectacles() ;

	}
	
	public static Representation[] getRepresentations(int i) {
		return col.getRepresentations(i);
	
	}
	
	public static Representation[] getRepresentations() {
		return col.getRepresentations();
	
	}

		
	
}
