package modele;

import java.util.ArrayList;

import sun.nio.ch.SocketOpts.IP;

public class Panier {
	private ArrayList<LignePanier> monPanier = new ArrayList<LignePanier>();
	private String id;
	private String userID;	
	
	public Panier(String pUserID){
		System.out.println(pUserID);
		setId(pUserID);
		setUserID(pUserID);
	}	
	
	public Panier(String pId, String pUserID){
		setId(pId);
		setUserID(pUserID);
	}	
	
	public Panier(Representation pRep, String pId, String pUserID){
		setId(pId);
		setUserID(pUserID);
		monPanier.add(new LignePanier(pRep,1));
	}
	
	public Panier(Representation pRep, int pNbBillets, String pId, String pUserID){
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
	
	public void retournerBillets(){
		for(int i = 0; i < monPanier.size(); i ++){
			monPanier.get(i).getRep().retournerBillet(monPanier.get(i).getNbBillets());
			monPanier.remove(i);
		}		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}


}
