package main;

import java.util.Scanner;

import entity.Map;
import entity.Ville;

public class Menu {
	private String menu1 = 
			"1) ajouter une route; \n2) fin.";
	private String menu2 =
			"1) ajouter une zone de recharge;\r\n2) retirer une zone de recharge;\r\n3) fin.";


	private int statue; //0 exit 1 menu1 2 menu2

	public Menu() {
		statue = 1;
	}
	
	public int getStatue() {
		return statue;
	}


	public void setStatue(int statue) {
		this.statue = statue;
	}
	
	public void printMenu() {
		if(statue == 1)
			System.out.println(menu1);
		else if(statue == 2)
			System.out.println(menu2);
	}
	
	public void operation(int o, Map m, Scanner s) {
		if(statue == 1) {
			if(o == 1) {
				System.out.println("nom de ville 1?");
				Ville v1 = m.getVille(s.next());
				System.out.println("nom de ville 2?");
				Ville v2 = m.getVille(s.next());
				if(v1 != null && v2 != null)
					m.ajouterRoute(v1, v2);
				else
					System.out.println("ville(s) non trouvée");
			}else if(o == 2)
				statue = 2;
			else
				System.out.println("Opération illégale");
				
		}else if(statue == 2) {
			if(o == 1) {
				System.out.println("nom de ville où vous voulez ajouter le zone de recharge?");
				Ville v = m.getVille(s.next());
				if(v != null)
					m.ajouterZoneRecharge(v);
				else
					System.out.println("ville(s) non trouvée");
			}else if(o == 2) {
				System.out.println("nom de ville où vous voulez retirer le zone de recharge?");
				Ville v = m.getVille(s.next());
				if(v != null)
					m.retirerZoneRecharge(v);
				else
					System.out.println("ville(s) non trouvée");
			}else if(o == 3)
				statue = 0;
				
			else
				System.out.println("Opération illégale");
		}
	}
}
