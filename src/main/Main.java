package main;

import java.util.Scanner;

import entity.Map;

public class Main {
	public static void main(String args[]) {
		Menu m = new Menu();
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.println("graphe par defaut");
		Map map = new Map();
		
//		System.out.println("graphe à créer");
//		int nbVille;
//		do{
//			System.out.println("Entrez le nb de ville(<26)");
//			nbVille = s.nextInt();
//		}while(nbVille<=0 || nbVille>=26);
//		Map map = new Map(nbVille);
//		
//		for(int i=0; i<nbVille; i++) {
//			System.out.println("Entrez le nom de ville "+(i+1);
//			String name = s.next();
//			map.ajouterVille(name);
//		}
		
		
		while(m.getStatue() != 0) {
			m.printMenu();
			System.out.println("Choisissez une opération");
			String o = s.next();
			if(o.equals("1") ||o.equals("2") || o.equals("3"))
				m.operation(Integer.parseInt(o), map, s);
			else
				System.out.println("saisie illégale");
		}
		
		map.printSolution();
		
		s.close();
	}
}
