package modele;

import java.util.ArrayList;
import java.util.Collection;



public class DelegateSpectacles {
	
	
	public static Collection getSpectacleCol() {
		
		return SpectaclesDAOlocal.getCollection();
	}
	
	public static Spectacle[] obtenirSpectacles() {
		return SpectaclesDAOlocal.getSpectacles();
	}
	
	public static Representation[] obtenirRepresentation(int i) {
		return SpectaclesDAOlocal.getRepresentations(i);
	}

	
}
