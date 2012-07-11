package modele;

public class User {
		private String id;
		private String nom;
		private String prenom;
		private String adresse;
		private Panier activePanier;
	
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public Panier getActivePanier() {
			return activePanier;
		}
		public void setActivePanier(Panier activePanier) {
			this.activePanier = activePanier;
		}
		public User(String pId){
			id = pId;			
		}
		public User(String pId, String pNom, String pPrenom, String pAdresse, Panier pPanier){
			id = pId;
			nom = pNom;
			prenom = pPrenom;
			adresse = pAdresse;
			activePanier = pPanier;
		}
		
		

}
