package entity;

import java.util.Vector;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ville v1 = new Ville("a");
		Ville v2 = new Ville("b");
		Ville v3 = new Ville("c");
		
		Route r1 = new Route(v1, v2);
		Route r2 = new Route(v2, v1);
		Route r3 = new Route(v1, v3);
		
		Vector<Route> routes = new Vector<Route>();
		routes.add(r1);
		
		boolean flag1 = false;
		boolean flag2 = false;
		for(Route r : routes) {
			if(r.equals(r2))
				flag1 = true;
			if(r.equals(r3))
				flag2 = true;
		}
		System.out.println(flag1 +"  "+ flag2);
	}

}
