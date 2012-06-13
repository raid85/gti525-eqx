import java.util.ArrayList;


public class Spectacle {
	private String nom;
	private String image;
	private int duree;
	private String description;
	private Artiste artiste;
	private ArrayList representations = new ArrayList();
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Artiste getArtiste() {
		return artiste;
	}
	public void setArtiste(Artiste artiste) {
		this.artiste = artiste;
	}
	
	public void ajouterRepresentation(Representation pRepresentation){
		representations.add(pRepresentation);
	}
	
	public Representation getrRepresentation(int id){
		return (Representation)representations.get(id);
	}
	

}
