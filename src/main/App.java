package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import dao.EmpruntDAO;
import dao.GardienDAO;
import modele.Client;
import modele.Film;
import modele.Gardien;
import utils.LectureClavier;
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
		int choix;
		System.out.println("[1] Louer un film");
		System.out.println("[2] Rendre un film");
		System.out.println("[3] Gèrer mon compte");
		System.out.println("[0] Quitter l'application.");
		choix = LectureClavier.lireEntier("");
		System.out.flush();
		switch (choix) {
			case 1:
				location();
				break;
			case 2:
				rendre();
				break;
			case 3:
				//gestion();
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
		String mail = LectureClavier.lireChaine();
		System.out.println(mail);
		System.out.flush();
		EmpruntDAO empD = new EmpruntDAO(s1.getSession());
		int nbEmprunt = empD.nbEmprunt(mail);
		System.out.println(nbEmprunt);
		Client filmEmprunt = empD.listeEmprunt(mail);
		String nomF = "";
		switch (nbEmprunt) {
			case 0:
				System.out.println("Aucun film trouvé pour cette adresse mail.\nRetour à la page d'accueil.");
				break;
			case 1:
				System.out.print("Merci de rendre le film :");
				for (Iterator<Film> it = filmEmprunt.getFilmsLoues().iterator(); it.hasNext();) {
					nomF = it.next().getnomFilm();
					System.out.println(nomF);
				}
				empD.rendreFilm(mail, nomF);
				System.out.println("Merci d'avoir rendu " + nomF + ", passez une bonne journée.\nRetour à la page d'accueil.");
				break;
			default:
				System.out.println("Voici la liste des films que vous avez empruntés.\nMerci d'écrire le numéro du film que vous rendez.");
				int nb = 1;
				String[] nomFL = new String[nbEmprunt];
				for (Iterator<Film> it = filmEmprunt.getFilmsLoues().iterator(); it.hasNext();) {
					nomF = it.next().getnomFilm();
					System.out.println("[" + nb + "] "+ nomF);
					nomFL[nb-1] = nomF;
					nb++;
				}
				nb = LectureClavier.lireEntier("");
				System.out.flush();
				filmEmprunt = empD.listeEmprunt(mail);
				if(nb >= 0 && nb <= nbEmprunt){
					System.out.println("Vous rendez : " + nomFL[nb-1]);
					empD.rendreFilm(mail, nomFL[nb-1]);
					System.out.println("Merci d'avoir rendu " + nomFL[nb-1] + ", passez une bonne journée.\nRetour à la page d'accueil.");
				}
				else{
					System.out.println("Le numéro du film n'est pas valide.\nRetour à la page d'accueil.");
				}
				break;
		}
		s1.close();
		menuPrincipal();
	}

	/* 
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
				cliD.nouvelleCarteBanque(mail, num, date, picto);
				s1.close();
				System.out.println("Et voilà, vous êtes membre !");
				System.out.println("Voulez vous une carte d'abonnement ?\nC'est gratuit et vous payerez moins cher !\nRepondez par o/n");
				String choix = sc.nextLine();
				if(choix.equals("o") || choix.equals("O")){
					creationCarteAbonnement(mail);
				}
			}
			else{
				System.out.println("Cette adresse mail est déjà prise !");
				creationCompte();
			}
		}
	}

	private static void creationCarteAbonnement(String mail){
		System.out.println("Merci de bien vouloir faire uen carte abonnée !");
		Session s1 = new Session();
		s1.open();
		ClientDAO cliD = new ClientDAO(s1.getSession());
		Scanner sc = new Scanner(System.in);
		System.out.println("Comment voulez vous nommer cette carte ?");
		String nomCarte = sc.nextLine();
		System.out.flush();
		while(cliD.nomCartePrit(nomCarte, mail)){
			System.out.println("Vous avez déjà une carte avec ce nom !\nVeuillez en choisir un autre !");
			nomCarte = sc.nextLine();
			System.out.flush();
		}
		System.out.println("Le montant minimun pour la creation d'une carte est de 10€, combien voulez vous mettre en plus ?");
		int montant = sc.nextInt();
		System.out.flush();
		while(montant < 0){
			System.out.println("Veuillez mettre un montant nul ou positif !");
			montant = sc.nextInt();
			System.out.flush();
		}
		cliD.nouvelleCarteAbo(mail, nomCarte, montant);
		System.out.println("Et voilà ! Merci beaucoup de nous faire confiance ;)\nTout est 100000% sécurisé n\'ayez pas peur ^^ !");
		s1.close();
	}

	private static void changementInformations(){
		System.out.println("Donnez votre adresse mail, ou tappez n pour annuler et revenir au menu principal:");
		Scanner sc = new Scanner(System.in);
		String mail = sc.nextLine();
		System.out.flush();
		if(!mail.equals("n")){
			System.out.println("Entrez votre mot de passe");
			String mdp = sc.nextLine();
			System.out.flush();
			Session s1 = new Session();
			ClientDAO cliD = new ClientDAO(s1.getSession());
			if(cliD.connexion(mail, mdp)){
				System.out.println("Informations non valides !");
				changementInformations();
			}
			else{
				System.out.println("Que voulez vous modifier ?");
				System.out.println("[1] Nom");
				System.out.println("[2] Prenom");
				System.out.println("[3] Mail");
				System.out.println("[4] Adresse");
				System.out.println("[5] Telephone");
				System.out.println("[6] Carte Bancaire");
				System.out.println("[7] Carte Abonnés");
				System.out.println("[0] Annuler et revenir au menu principal");
				int choix = sc.nextInt();
				System.out.flush();
				switch (choix) {
					case 1:
						System.out.println("Entrez votre nouveau nom");
						String nom = sc.nextLine();
						System.out.flush();
						cliD.majNom(mail, nom);
						break;
					case 2:
						System.out.println("Entrez votre nouveau prenom");
						String prenom = sc.nextLine();
						System.out.flush();
						cliD.majPrenom(mail, prenom);
						break;
					case 3:
						System.out.println("Entrez votre nouveau mail");
						String mail2 = sc.nextLine();
						System.out.flush();
						if(cliD.mailValide(mail2)){
							cliD.majMail(mail2, prenom);
						}
						else{
							System.out.println("Ce mail est déjà utilisé par une autre personne !");
						}
						break;
					case 4:
						System.out.println("Entrez votre nouvelle adresse");
						String adresse = sc.nextLine();
						System.out.flush();
						cliD.majAdresse(mail, adresse);
						break;
					case 5:
						System.out.println("Entrez votre nouveau numéro de telephone");
						String tel = sc.nextLine();
						System.out.flush();
						cliD.majTel(mail, tel);
						break;
					case 6:
						System.out.println("Entrez votre nouvelle carte bancaire ;)\nNous vous rappelons que tout est sécurisé !");
						System.out.println("Numéro de Carte Bancaire :");
						String num = sc.nextLine();
						System.out.flush();
						System.out.println("Date d'expiration de la carte Bancaire :");
						String date = sc.nextLine();
						System.out.flush();
						System.out.println("Pictogramme de la carte bancaire :");
						String picto = sc.nextLine();
						System.out.flush();
						cliD.suppresionCarte(mail);
						cliD.nouvelleCarteBanque(mail, num, date, picto);
						break;
					case 7:
						modifCarteAbo(mail);
						break;
					default:
						menuPrincipal();
						break;
				}
			}
		}
		else{
			menuPrincipal();
		}
	}

	private static void modifCarteAbo(String mail) {
	}


	*/

}
