package modele;

public class Billet {

	
	
	private int ID;
	private String state;
	
	
	public Billet(){
		setID(Math.round((long)Math.random()*1000));
		
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
