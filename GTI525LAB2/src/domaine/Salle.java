package domaine;

public class Salle {
	private String nom;
	private String adresse;
	private int NbPlaceMax;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNbPlaceMax() {
		return NbPlaceMax;
	}
	public void setNbPlaceMax(int nbPlaceMax) {
		NbPlaceMax = nbPlaceMax;
	}

}
