package entity;

import java.util.Objects;

public class Route {
	private Ville v1;
	private Ville v2;
	
	public Route(Ville v1, Ville v2) {
		this.v1 = v1;
		this.v2 = v2;
		v1.addVoisin(v2);
		v2.addVoisin(v1);
	}
	
	public boolean equals(Route r) {
		if(this.v1 == r.v1 && this.v2 ==r.v2 || this.v1 == r.v2 && this.v2 == r.v1) {
			return true;
		}else
			return false;
	}
	
	public int hashCode() {
		return Objects.hash(v1, v2);
	}
}
