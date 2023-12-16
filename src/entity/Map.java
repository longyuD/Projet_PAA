package entity;

import java.util.Vector;

public class Map {
	private int nbVille;
	private Vector<Ville> villes;
	private Vector<Route> routes;
	
	public Map() {
		nbVille = 11;
		villes = new Vector<Ville>();
		villes.add(new Ville("A"));
		villes.add(new Ville("B"));
		villes.add(new Ville("C"));
		villes.add(new Ville("D"));
		villes.add(new Ville("E"));
		villes.add(new Ville("F"));
		villes.add(new Ville("G"));
		villes.add(new Ville("H"));
		villes.add(new Ville("I"));
		villes.add(new Ville("J"));
		villes.add(new Ville("K"));
		
		routes = new Vector<Route>();
		routes.add(new Route(villes.get(0), villes.get(1)));
		routes.add(new Route(villes.get(0), villes.get(3)));
		routes.add(new Route(villes.get(1), villes.get(2)));
		routes.add(new Route(villes.get(1), villes.get(7)));
		routes.add(new Route(villes.get(2), villes.get(3)));
		routes.add(new Route(villes.get(2), villes.get(8)));
		routes.add(new Route(villes.get(3), villes.get(4)));
		routes.add(new Route(villes.get(4), villes.get(5)));
		routes.add(new Route(villes.get(4), villes.get(6)));
		routes.add(new Route(villes.get(7), villes.get(8)));
		routes.add(new Route(villes.get(7), villes.get(9)));
		routes.add(new Route(villes.get(7), villes.get(10)));
	}
	
	public Map(int nbVille) {
		this.nbVille = nbVille;
		villes = new Vector<Ville>();
		routes = new Vector<Route>();
	}
	
	public void ajouterVille(String name) {
		villes.add(new Ville(name));
	}
	
	public void ajouterRoute(Ville v1, Ville v2) {
		Route route = new Route(v1, v2);
		boolean flag = false;
		for(Route r : routes) {
			if(r.equals(route))
				flag = true;
		}
		//if(!routes.contains(route)
		if(!flag) {
			routes.add(route);
		}else {
			System.out.println("route existante");
		}
	}
	
	public void ajouterZoneRecharge(Ville v) {
		if(v.isHasRecharger()) {
			System.out.println("Zone de Recharge existant");
		}
		else {
			v.setHasRecharger(true);
			printSolution();
		}
	}
	
	public void retirerZoneRecharge(Ville v) {
		if(!v.isHasRecharger()) {
			System.out.println("Zone de Recharge non existant");
			return;
		}
		int nbVoisinHasCharger = 0;
		for(Ville voisin : v.getVoisins()) {
			if(!voisin.isHasRecharger()) {
				for (Ville voisin2 : voisin.getVoisins()) {
					if(voisin2.isHasRecharger() && !voisin2.equals(v)) {
						nbVoisinHasCharger ++;
						System.out.println(nbVoisinHasCharger);
						break;
					}
						
				}
			}else
				nbVoisinHasCharger ++;
		}
		if(nbVoisinHasCharger == v.getVoisins().size()) {
			v.setHasRecharger(false);
			printSolution();
		}
		else
			System.out.println("impossible de retirer, solution non accessible");
	}
	
	public void printSolution() {
		StringBuffer sb = new StringBuffer("la solution actuelle :");
		for(Ville v : villes) {
			if(v.isHasRecharger()) {
				sb.append(" ");
				sb.append(v.getName());
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public Ville getVille(String name) {
		for(Ville v : villes) {
			if(v.getName().equals(name))
				return v;
		}
		return null;
	}
}
