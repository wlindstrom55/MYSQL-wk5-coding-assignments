package entity;

public class Sodas {
	private int sodaId;
	private String sodaName;
	
	
public Sodas( int sodaId, String sodaName) { //constructor
	this.setSodaId(sodaId);
	this.setSodaName(sodaName);
}

			//getters and setters:
public String getSodaName() {
	return sodaName;
}


public void setSodaName(String sodaName) {
	this.sodaName = sodaName;
}


public int getSodaId() {
	return sodaId;
}


public void setSodaId(int sodaId) {
	this.sodaId = sodaId;
}
	
}
