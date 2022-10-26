package main;

import java.sql.SQLException;
import java.util.Scanner;

import dao.GardienDAO;
import modele.Gardien;

import utils.Session;

public class App {
	public static void main(String args[]) {
		/* Menu utilisateur */
		System.out.println("Bienvenue sur Didier Futur !");
		menuPrincipal();
		System.out.println("Merci d'avoir utilisé Didier Futur et à bientôt !");
	}

	private static void menuPrincipal(){
		System.out.println("Que souhaitez-vous faire ?");
		Scanner sc = new Scanner(System.in);
		int choix;
		System.out.println("[1] Louer un film");
		System.out.println("[2] Rendre un film");
		System.out.println("[3] Gèrer mon compte");
		System.out.println("[0] Quitter l'application.");
		choix = sc.nextInt();
		System.out.flush();
		sc.close();
		switch (choix) {
			case 1:
				location();
			case 2:
				rendre();
			case 3:
				gestion();
		}
	}

	private static void location(){

	}

	private static void rendre(){
		Session s1 = new Session();
		s1.open();
		System.out.println("Donnez l'adresse mail de la personne ayant emprunter le film :");
		Scanner sc = new Scanner(System.in);
		String mail = sc.nextLine();
		EmpruntDAO empD = new EmpruntDAO(s1.getSession());
		int nbLocation = empD.nbLocation(mail);
		switch (nbLocation) {
			case 0:
				
				break;
		
			default:
				break;
		}
	}

	private static void gestion(){
		
	}

}