package modele;

import java.util.ArrayList;
import java.util.Collection;



public class DelegateSpectacles {
	static modele.Collection col = new modele.Collection();

	public static modele.Collection getCollection() {
		return col.getCollection();
		
	}	
	public static Spectacle[] getSpectacles() {
		return col.getSpectacles() ;

	}
	
	public static Representation[] getRepresentations(int i) {
		return col.getRepresentations(i);
	
	}

		
	
}
