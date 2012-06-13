import java.util.Date;


public class Representation {
	private Salle salle;
	private Date date;
	private int billetsDispo;
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

}
