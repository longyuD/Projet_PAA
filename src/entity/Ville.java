package entity;

import java.util.Vector;

public class Ville {
	private String name;
	private Vector<Ville> voisins;
	private boolean hasRecharger;
	
	public Ville(String name) {
		this.name = name;
		voisins = new Vector<Ville>();
		hasRecharger = true;
	}
	
	public boolean isHasRecharger() {
		return hasRecharger;
	}

	public void setHasRecharger(boolean hasRecharger) {
		this.hasRecharger = hasRecharger;
	}
	

	public Vector<Ville> getVoisins() {
		return voisins;
	}

	
	public void addVoisin(Ville v) {
		if(!voisins.contains(v)) {
			voisins.add(v);
		}
	}
	
	public String getName() {
		return name;
	}
	
//	public boolean equals(Ville v) {
//		if(this.name)
//	}
}
