package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import dao.GardienDAO;
import modele.Film;
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
				break;
			case 2:
				rendre();
				break;
			case 3:
				gestion();
				break;
			default:
				break;
		}
		System.out.println("Merci et à bientôt !");
	}

	private static void location(){

	}

	private static void rendre(){
		Session s1 = new Session();
		s1.open();
		System.out.println("Donnez l'adresse mail de la personne ayant emprunter le film :");
		Scanner sc = new Scanner(System.in);
		String mail = sc.nextLine();
		System.out.flush();
		EmpruntDAO empD = new EmpruntDAO(s1.getSession());
		int nbEmprunt = empD.nbEmprunt(mail);
		Film filmEmprunt = empD.listeEmprunt(mail);
		String nomF;
		switch (nbEmprunt) {
			case 0:
				System.out.println("Aucun film trouvé pour cette adresse mail.\nRetour à la page d'accueil.");
				break;
			case 1:
				System.out.print("Merci de rendre le film :");
				for (Iterator<Film> it = filmEmprunt.getFilms(); it.hasNext();) {
					nomF = it.next().getnomFilm();
					System.out.println(nomF);
				}
				empD.rendreFilm(mail, nomF);
				System.out.println("Merci d'avoir rendu " + nomF + ", passez une bonne journée.\nRetour à la page d'accueil.");
				break;
			default:
				System.out.print("Voici la liste des films que vous avez empruntés.\nMerci d'écrire le numéro du film que vous rendez.");
				int nb = 1;
				for (Iterator<Film> it = filmEmprunt.getFilms(); it.hasNext();) {
					nomF = it.next().getnomFilm();
					System.out.println("[" + nb + "] "+ nomF);
					nb++;
				}
				nb = sc.nextInt();
				System.out.flush();
				if(nb >= 1 && nb <= nbEmprunt){
					int num = 1;
					for (Iterator<Film> it = filmEmprunt.getFilms(); it.hasNext();) {
						if(num == nb){
							nomF = it.next().getnomFilm();
						}
						num++;
					}
					System.out.println("Vous rendez : " + nomF);
					empD.rendreFilm(mail, nomF);
					System.out.println("Merci d'avoir rendu " + nomF + ", passez une bonne journée.\nRetour à la page d'accueil.");
				}
				else{
					System.out.println("Le numéro du film n'est pas valide.\nRetour à la page d'accueil.");
				}
				break;
		}
		s1.close();
		menuPrincipal();
	}

	private static void gestion(){
		System.out.println("Que voulez vous faire ?");
		System.out.println("[1] Gerer les informations de mon compte");
		System.out.println("[2] Creer un compte");
		System.out.println("[3] Revenir au menu principal");
		Scanner sc = new Scanner(System.in);
		int choix = sc.nextInt();
		System.out.flush();
		sc.close();
		switch (choix) {
			case 1:
				changementInformations();
				break;
			case 2:
				creationCompte();
				break;
			case 3:
				menuPrincipal();
				break;
			default:
				System.out.println("Veuillez donnez un chiffre valide.");
				gestion();
				break;
		}
	}

	private static void creationCompte() {
		System.out.println("Donnez votre adresse mail, ou tappez n pour annuler :");
		Scanner sc = new Scanner(System.in);
		String mail = sc.nextLine();
		System.out.flush();
		if(!mail.equals("n")){
			Session s1 = new Session();
			s1.open();
			ClientDAO cliD = new ClientDAO(s1.getSession());
			if(cliD.mailValide(mail)){
				System.out.println("Merci de donnez vos inforations.\nElles pourrons être modiffiées ultérieurement.");
				System.out.println("Nom de Famille : ");
				String nom = sc.nextLine();
				System.out.flush();
				System.out.println("Prénom :");
				String prenom = sc.nextLine();
				System.out.flush();
				System.out.println("Adresse :");
				String adresse = sc.nextLine();
				System.out.flush();
				System.out.println("Date de Naissance :");
				String naiss = sc.nextLine();
				System.out.flush();
				System.out.println("Telephone :");
				String telephone = sc.nextLine();
				System.out.flush();
				System.out.println("Mot de Passe :");
				String mdp = sc.nextLine();
				System.out.flush();
				System.out.println("Ne vous inquiètez pas pour votre carte, tout est 100% sécurisé ;)");
				System.out.println("Numéro de Carte Bancaire :");
				String num = sc.nextLine();
				System.out.flush();
				System.out.println("Date d'expiration de la carte Bancaire :");
				String date = sc.nextLine();
				System.out.flush();
				System.out.println("Pictogramme de la carte bancaire :");
				String picto = sc.nextLine();
				System.out.flush();
				cliD.nouveauMembre(mail, nom, prenom, adresse, naiss, telephone, mdp);
				cliD.nouvelleCarte(mail, num, date, picto);
				System.out.println("Et voilà, vous êtes membre !");
				System.out.println("Voulez vous une carte d'abonnement ?\nC'est gratuit et vous payerez moins cher !\nRepondez par o/n");
				String choix = sc.nextLine();
				if(choix.equals("o") || choix.equals("O")){
					carteAbonnement();
				}
			}
			else{
				System.out.println("Cette adresse mail est déjà prise !");
				creationCompte();
			}
		}
	}

	private static void changementInformations() {
	}

}