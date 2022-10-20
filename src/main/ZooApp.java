package main;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import dao.CageDAO;
import dao.GardienDAO;
import modele.Cage;
import modele.Gardien;

import utils.LectureClavier;
import utils.Session;

public class ZooApp {

	public static void main(String args[]) {

		try {

			/* Menu utilisateur */
			System.out.println("Bienvenue sur l'application de gestion du Zoo ! :D");
			Scanner sc = new Scanner(System.in);
			int choix;
			do {
				System.out.println("Que souhaitez-vous faire ?");
				System.out.println("[1] Changer la fonction d'une cage ?");
				System.out.println("[2] Deplacer un gardien ?");
				System.out.println("[3] Affichage Affectations ?");
				System.out.println("[0] Quitter l'application.");
				choix = sc.nextInt();
				switch (choix) {
					case 1:
						System.out.flush();
						changerFonctionCage();
					case 2:
						System.out.flush();
						deplacerGardien();
					case 3:
						System.out.flush();
						affichageAff();
				}
			} while (choix != 0);
			sc.close(); // fermeture du scanner
			System.out.println("bye.");

			// traitement d'exception
		} catch (SQLException e) {
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());
		}
	}

	/**
	 * Changer la fonction d'une cage.
	 */
	private static void changerFonctionCage() throws SQLException {

		// A completer

	}

	/**
	 * 3
	 * Deplacer un gardien
	 */
	private static void deplacerGardien() throws SQLException {

		// A completer

	}

	/**
	 * Afficher les affectations
	 */
	private static void affichageAff() throws SQLException {
		Session s1 = new Session();
		s1.open();
		GardienDAO garD = new GardienDAO(s1.getSession());
		Gardien gar = garD.read("Caffiau");
		System.out.println(gar.getAdresse());
		s1.close();
	}

}