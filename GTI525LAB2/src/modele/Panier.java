package modele;

import java.util.ArrayList;

import sun.nio.ch.SocketOpts.IP;

public class Panier {
	private ArrayList<LignePanier> monPanier = new ArrayList<LignePanier>();
	private int id;
	private int userID;
	
	public Panier(int pId, int pUserID){
		setId(pId);
		setUserID(pUserID);
	}
	
	public Panier(Representation pRep, int pId, int pUserID){
		setId(pId);
		setUserID(pUserID);
		monPanier.add(new LignePanier(pRep,1));
	}
	
	public Panier(Representation pRep, int pNbBillets, int pId, int pUserID){
		setId(pId);
		setUserID(pUserID);
		monPanier.add(new LignePanier(pRep,pNbBillets));
	}
	
	public void ajouterLigne(Representation pRep, int pNbBillets){
		monPanier.add(new LignePanier(pRep, pNbBillets));
	}
	
	public LignePanier[] getPanier(){
		LignePanier[] panier = new LignePanier[monPanier.size()];
        for (int i=0;i<monPanier.size();i++){
        	panier[i] = ((LignePanier)monPanier.get(i));
        }
        return panier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}


}
