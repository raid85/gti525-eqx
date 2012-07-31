package modele;

import java.util.Random;

public class Billet {

	
	
	private int ID;
	private String state;
	private Random randomGenerator = new Random();
	
	
	public Billet(){
		setID(randomGenerator.nextInt(100000));
		setState("Libre");
	}
	public int getID() {
		return ID;
	}
	private void setID(int iD) {
		ID = iD;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
