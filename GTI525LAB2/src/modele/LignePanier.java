package modele;

public class LignePanier {
	private Representation rep;
	private int nbBillets;
	
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
	}

}
