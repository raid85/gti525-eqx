package modele;
import java.util.Date;


public class Representation {
	private int id;
	private Salle salle;
	private Date date;
	private int billetsDispo;
	private double prix;
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
		this.billetsDispo = billetsDispo;
	}
	public void achatBillets(int nbBillets){
		if (nbBillets < billetsDispo)
			billetsDispo = billetsDispo - nbBillets;
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

}
