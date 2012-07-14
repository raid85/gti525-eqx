package modele;

import java.util.Date;

public class LignePanier {
	private Representation rep;
	private int nbBillets;
	private Date dateReservation;
	
	public Representation getRep() {
		return rep;
	}
	public void setRep(Representation rep) {
		this.rep = rep;
	}
	public int getNbBillets() {
		return nbBillets;
	}
	public void setNbBillets(int nbBillets) {
		this.nbBillets = nbBillets;
	}
	
	public double getPrixUni(){
		return rep.getPrix();
	}
	
	public double getPrixTot(){
		return getPrixUni()*nbBillets;
	}
	
	public LignePanier(Representation pRep, int pNbBillets){
		rep = pRep;
		nbBillets = pNbBillets;
		dateReservation = new Date();
	}
	public Date getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}
	

}
