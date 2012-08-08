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
	public static Spectacle[] getSpectacles() throws ClassNotFoundException, SQLException {
		return SpectacleDAO.getSpectacles();
	}
	
	public static TORepresentations getRepresentations(int idSpectacle) throws ClassNotFoundException, SQLException, ClassCastException {
		return SpectacleDAO.getRepresentations(idSpectacle);
	}
	
	public static boolean reserverBillets(int idRep, int nbBillets, Panier monPanier) throws ClassNotFoundException, SQLException, ClassCastException {
		if (SpectacleDAO.getNbBilletsDispo(idRep) >= nbBillets){
			monPanier.ajouterLigne(SpectacleDAO.getRep(idRep), nbBillets);
			
		}
		return SpectacleDAO.getNbBilletsDispo(idRep) >= nbBillets;
	}

		
	
}
