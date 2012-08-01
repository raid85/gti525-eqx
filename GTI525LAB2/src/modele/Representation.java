package modele;
import java.util.ArrayList;
import java.util.Date;


public class Representation {
	private int id;
	private Salle salle;
	private Date date;
	private int billetsDispo;
	private double prix;
	private int spectacle;
	private ArrayList<Billet> listeBilletDispo;
	private String spectacleNom;
	
	public Representation(){
		listeBilletDispo = new ArrayList<Billet>();
	}
	public Salle getSalle() {
		return salle;
	}
	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getBilletsDispo() {
		return billetsDispo;
	}
	public void setBilletsDispo(int billetsDispo) {
		for(int i=0; i<billetsDispo;i++){
			listeBilletDispo.add(new Billet());
		}
		this.billetsDispo = billetsDispo;
	}
	public void reserverBillets(int nbBillets){
		for(int i = 0 ; i < listeBilletDispo.size()-nbBillets;i++){
			if (listeBilletDispo.get(i).getState()	!= "Reserve" || listeBilletDispo.get(i).getState()	!= "Vendu" ){			
				for(int j = 0; j<nbBillets;j++){
					if (listeBilletDispo.get(i+j).getState()	!= "Reserve" || listeBilletDispo.get(i+j).getState()	!= "Vendu" ){
						listeBilletDispo.get(i+j).setState("Reserve");
						
					}
				}
			}
		}
		billetsDispo = billetsDispo - nbBillets;
	}
	public void retournerBillet(int nombre){
		if(nombre > 0){	
			for(int i = 0 ; i < listeBilletDispo.size()-nombre;i++){
				if (listeBilletDispo.get(i).getState()	== "Reserve" && listeBilletDispo.get(i).getState()	!= "Vendu" ){			
					for(int j = 0; j<nombre;j++){
						if (listeBilletDispo.get(i+j).getState()	== "Reserve" && listeBilletDispo.get(i+j).getState()	!= "Vendu" ){
							listeBilletDispo.get(i+j).setState("Libre");
							
						}
					}
				}
			}
			billetsDispo = billetsDispo + nombre;
		}
	}
	public void vendreBillet(int nbBillets){
		for(int i = 0 ; i < listeBilletDispo.size()-nbBillets;i++){
			if (listeBilletDispo.get(i).getState()	== "Reserve" && listeBilletDispo.get(i).getState()	!= "Vendu" ){			
				for(int j = 0; j<nbBillets;j++){
					if (listeBilletDispo.get(i+j).getState()	== "Reserve" && listeBilletDispo.get(i+j).getState()	!= "Vendu" ){
						listeBilletDispo.get(i+j).setState("Vendu");						
					}
				}
			}
		}
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getSpectacle() {
		return spectacle;
	}
	public void setSpectacle(int spectacle) {
		this.spectacle = spectacle;
	}
	public String getSpectacleNom() {
		return spectacleNom;
	}
	public void setSpectacleNom(String spectacleNom) {
		this.spectacleNom = spectacleNom;
	}

}
