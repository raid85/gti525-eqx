package modele;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

//import sun.nio.ch.SocketOpts.IP;

public class Panier {
	private ArrayList<LignePanier> monPanier = new ArrayList<LignePanier>();
	private String id;
	private String userID;	
	private int sessionTimeoutM=-1;
	
	private Date d = new Date();
	private int sessionTimeoutH=d.getHours();
	private static int TEMPS_MAX_SESSION = 20;
	private int totalBillets =0;
	
	
	public Panier(String pUserID){
		setId(pUserID);
		setUserID(pUserID);
	}	
	
	public Panier(String pId, String pUserID){
		setId(pId);
		setUserID(pUserID);
	}	
	
//	public Panier(Representation pRep, String pId, String pUserID){
//		setId(pId);
//		setUserID(pUserID);
//		monPanier.add(new LignePanier(pRep,1));
//	}
	
	public Panier(Representation pRep, int pNbBillets, String pId, String pUserID){
		setId(pId);
		setUserID(pUserID);
		monPanier.add(new LignePanier(pRep,pNbBillets));
	}
	
	public void ajouterLigne(Representation pRep, int pNbBillets){
		if(totalBillets <= 0 ){
			d = new Date();
			//			System.out.println("Panier pas vide");
			//			System.out.println(d.getMinutes());
			sessionTimeoutH = d.getHours();

			sessionTimeoutM = d.getMinutes();
			if(sessionTimeoutM > 60 - TEMPS_MAX_SESSION){
				sessionTimeoutM = sessionTimeoutM - TEMPS_MAX_SESSION;
				sessionTimeoutH = d.getHours() + 1;
			}else{sessionTimeoutM = sessionTimeoutM + TEMPS_MAX_SESSION;}
			//			System.out.println("Initialisation :" + sessionTimeoutM);
		}
		if(checkTimeOut()){
			monPanier.add(new LignePanier(pRep, pNbBillets));
			pRep.reserverBillets(pNbBillets);
			totalBillets += pNbBillets;
		}
		else{ajouterLigne(pRep, pNbBillets);}
	}
	
	public LignePanier[] getPanier(){
		LignePanier[] panier = new LignePanier[monPanier.size()];
		for (int i=0;i<monPanier.size();i++){
			if (monPanier.get(i).getNbBillets() > 0)
				panier[i] = ((LignePanier)monPanier.get(i));
			else
			{
				monPanier.remove(i);
				i--;
			}
        }
        return panier;
	}
	
	public void viderPanier(){
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
	
	public double getTotal(){
		double cash=0;
		for (int i=0;i<monPanier.size();i++){
			cash += monPanier.get(i).getPrixTot();
		}
		return cash;
	}

	public boolean checkTimeOut(){
		Date dTimeout = new Date();
		int timeoutM = dTimeout.getMinutes();
		int timeoutH = dTimeout.getHours();
//		System.out.println("on valide");
//		System.out.println("La session se termine à: " + sessionTimeoutH + ":" + sessionTimeoutM + ". Il es présentement : " + timeoutH + ":" + timeoutM);
//		
//		System.out.println(timeoutM);
			if(sessionTimeoutM!=-1 && timeoutM>=sessionTimeoutM && timeoutH == sessionTimeoutH){
//				System.out.println("Timeout : " + sessionTimeoutM + " / Temps actuel:"+ timeoutM);
				viderPanier();
				//sessionTimeoutM=-1;
			return false;
			}		
		
		return true;
	}

	
	public void finaliserVente(){
		for(int i = 0; i<monPanier.size();i ++){
			monPanier.get(i).getRep().vendreBillet(monPanier.get(i).getNbBillets());
		}
		
	}
	public LignePanier getLignePanier(int idRep){
		int i = 0;
		while (i<monPanier.size()){
			if (monPanier.get(i).getRep().getId() == idRep)
				return monPanier.get(i);
			i++;
			
		}
		return null;
	}

	public int getTotalBillets() {
		return totalBillets;
	}

	public void setTotalBillets(int totalBillet) {
		this.totalBillets = totalBillet;
	}



}
