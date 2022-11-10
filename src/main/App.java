package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import dao.ClientDAO;
import dao.EmpruntDAO;
import dao.GardienDAO;
import dao.LocationDAO;
import modele.Client;
import modele.Film;
import modele.Gardien;
import modele.RechercheFilm;
import utils.LectureClavier;
import utils.Session;

public class App {

	static Session s1;
	public static void main(String args[]) {
		/* Menu utilisateur */
		System.out.println("Bienvenue sur Didier Futur !");
		s1 = new Session();
		s1.open();
		menuPrincipal();
		s1.close();
		System.out.println("Merci d'avoir utilisé Didier Futur et à bientôt !");
	}

	private static void menuPrincipal() {
		System.out.println("Que souhaitez-vous faire ?");
		int choix;
		System.out.println("[1] Louer un film");
		System.out.println("[2] Rendre un film");
		System.out.println("[3] Gèrer mon compte");
		System.out.println("[0] Quitter l'application.");
		choix = LectureClavier.lireEntier("");

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
        System.out.println("Que souhaitez-vous faire ?");
        int choix;
        System.out.println("[1] Derniers films en date");
        System.out.println("[2] Recherche de film");
        System.out.println("[0] Retour");
        choix = LectureClavier.lireEntier("");
        System.out.flush();
        switch (choix){
            case 1:
                System.out.println("Voilà les derniers films ajoutés au système : ");
                LocationDAO locD = new LocationDAO(s1.getSession());
                RechercheFilm recherche = locD.dernierFilmAjoute();
                String nomF = "";
                String[] nomFL = new String[5];
                int nb = 1;
                for (Iterator<Film> it = recherche.getFilms().iterator(); it.hasNext();) {
                    nomF = it.next().getnomFilm();
                    System.out.println("[" + nb + "] "+ nomF);
                    nomFL[nb-1] = nomF;
                    nb++;
                }
                break;
            case 2:
                break;
            case 0:
                break;
            default:
                break;
        }
        menuPrincipal();
    }

	private static void rendre() {
		System.out.println("Donnez l'adresse mail de la personne ayant emprunter le film :");
		String mail = LectureClavier.lireChaine();
		System.out.println(mail);

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
				System.out.println(
						"Merci d'avoir rendu " + nomF + ", passez une bonne journée.\nRetour à la page d'accueil.");
				break;
			default:
				System.out.println(
						"Voici la liste des films que vous avez empruntés.\nMerci d'écrire le numéro du film que vous rendez.");
				int nb = 1;
				String[] nomFL = new String[nbEmprunt];
				for (Iterator<Film> it = filmEmprunt.getFilmsLoues().iterator(); it.hasNext();) {
					nomF = it.next().getnomFilm();
					System.out.println("[" + nb + "] " + nomF);
					nomFL[nb - 1] = nomF;
					nb++;
				}
				nb = LectureClavier.lireEntier("");

				filmEmprunt = empD.listeEmprunt(mail);
				if (nb >= 0 && nb <= nbEmprunt) {
					System.out.println("Vous rendez : " + nomFL[nb - 1]);
					empD.rendreFilm(mail, nomFL[nb - 1]);
					System.out.println("Merci d'avoir rendu " + nomFL[nb - 1]
							+ ", passez une bonne journée.\nRetour à la page d'accueil.");
				} else {
					System.out.println("Le numéro du film n'est pas valide.\nRetour à la page d'accueil.");
				}
				break;
		}
		menuPrincipal();
	}

	private static void gestion() {
		System.out.println("Que voulez vous faire ?");
		System.out.println("[1] Gerer les informations de mon compte");
		System.out.println("[2] Creer un compte");
		System.out.println("[3] Revenir au menu principal");
		int choix = LectureClavier.lireEntier("");
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
		String mail = LectureClavier.lireChaine();
		if (!mail.equals("n")) {
			ClientDAO cliD = new ClientDAO(s1.getSession());
			if (cliD.mailValide(mail)) {
				System.out.println("Merci de donnez vos inforations.\nElles pourrons être modiffiées ultérieurement.");
				System.out.println("Nom de Famille : ");
				String nom = LectureClavier.lireChaine();

				System.out.println("Prénom :");
				String prenom = LectureClavier.lireChaine();

				System.out.println("Adresse :");
				String adresse = LectureClavier.lireChaine();

				System.out.println("Date de Naissance :");
				String naiss = LectureClavier.lireChaine();

				System.out.println("Telephone :");
				String telephone = LectureClavier.lireChaine();

				System.out.println("Mot de Passe :");
				String mdp = LectureClavier.lireChaine();

				System.out.println("Ne vous inquiètez pas pour votre carte, tout est 100% sécurisé ;)");
				System.out.println("Numéro de Carte Bancaire :");
				String num = LectureClavier.lireChaine();

				System.out.println("Date d'expiration de la carte Bancaire :");
				String date = LectureClavier.lireChaine();

				System.out.println("Pictogramme de la carte bancaire :");
				String picto = LectureClavier.lireChaine();

				cliD.nouveauMembre(mail, nom, prenom, adresse, naiss, telephone, mdp);
				cliD.nouvelleCarteBanque(mail, num, date, picto);
				
				System.out.println("Et voilà, vous êtes membre !");
				System.out.println(
						"Voulez vous une carte d'abonnement ?\nC'est gratuit et vous payerez moins cher !\nRepondez par o/n");
				Boolean choix = LectureClavier.lireOuiNon("");
				if (choix) {
					creationCarteAbonnement(mail);
				}
			} else {
				System.out.println("Cette adresse mail est déjà prise !");
				creationCompte();
			}
		}
		else{
			menuPrincipal();
		}
	}

	private static void creationCarteAbonnement(String mail) {
		System.out.println("Merci de bien vouloir faire une carte abonnée !");
		ClientDAO cliD = new ClientDAO(s1.getSession());
		System.out.println("Comment voulez vous nommer cette carte ?");
		String nomCarte = LectureClavier.lireChaine();

		while (!cliD.nomCartePrit(nomCarte, mail)) {
			System.out.println("Vous avez déjà une carte avec ce nom !\nVeuillez en choisir un autre !");
			nomCarte = LectureClavier.lireChaine();
		}

		System.out.println(
				"Le montant minimun pour la creation d'une carte est de 10€, combien voulez vous mettre en plus ?");
		int montant = LectureClavier.lireEntier("");

		while (montant <= 0) {
			System.out.println("Veuillez mettre un montant nul ou positif !");
			montant = LectureClavier.lireEntier("");
		}

		montant = montant + 10;

		System.out.println(
			"Veuillez entrer l'age du possesseur de la carte : ");
		int age = LectureClavier.lireEntier("");

		cliD.nouvelleCarteAbo(mail, nomCarte, montant, age);
		System.out.println(
				"Et voilà ! Merci beaucoup de nous faire confiance ;)\nTout est 100000% sécurisé n\'ayez pas peur ^^ !");
	}

	private static void changementInformations() {
		System.out.println("Donnez votre adresse mail, ou tappez n pour annuler et revenir au menu principal:");
		String mail = LectureClavier.lireChaine();

		if (!mail.equals("n")) {
			System.out.println("Entrez votre mot de passe");
			String mdp = LectureClavier.lireChaine();

			ClientDAO cliD = new ClientDAO(s1.getSession());
			if (!cliD.connexion(mail, mdp)) {
				System.out.println("Informations non valides !");
				changementInformations();
			} else {
				System.out.println("Que voulez vous modifier ?");
				System.out.println("[1] Nom");
				System.out.println("[2] Prenom");
				System.out.println("[3] Mail");
				System.out.println("[4] Adresse");
				System.out.println("[5] Telephone");
				System.out.println("[6] Carte Bancaire");
				System.out.println("[7] Carte Abonnés");
				System.out.println("[8] Mot de passe");
				System.out.println("[0] Annuler et revenir au menu principal");
				int choix = LectureClavier.lireEntier("");

				switch (choix) {
					case 1:
						System.out.println("Entrez votre nouveau nom");
						String nom = LectureClavier.lireChaine();

						cliD.majNom(mail, nom);
						break;
					case 2:
						System.out.println("Entrez votre nouveau prenom");
						String prenom = LectureClavier.lireChaine();

						cliD.majPrenom(mail, prenom);
						break;
					case 3:
						System.out.println("Entrez votre nouveau mail");
						String mail2 = LectureClavier.lireChaine();

						if (cliD.mailValide(mail2)) {
							cliD.majMail(mail, mail2);
						} else {
							System.out.println("Ce mail est déjà utilisé par une autre personne !");
						}
						break;
					case 4:
						System.out.println("Entrez votre nouvelle adresse");
						String adresse = LectureClavier.lireChaine();

						cliD.majAdresse(mail, adresse);
						break;
					case 5:
						System.out.println("Entrez votre nouveau numéro de telephone");
						String tel = LectureClavier.lireChaine();

						cliD.majTel(mail, tel);
						break;
					case 6:
						System.out.println(
								"Entrez votre nouvelle carte bancaire ;)\nNous vous rappelons que tout est sécurisé !");
						System.out.println("Numéro de Carte Bancaire :");
						String num = LectureClavier.lireChaine();

						System.out.println("Date d'expiration de la carte Bancaire :");
						String date = LectureClavier.lireChaine();

						System.out.println("Pictogramme de la carte bancaire :");
						String picto = LectureClavier.lireChaine();

						cliD.majCarte(mail, num, date, picto);
						break;
					case 7:
						modifCarteAbo(mail);
						break;
					case 8:
						System.out.println("Entrez votre nouveau numéro de telephone");
						String mdp2 = LectureClavier.lireChaine();

						cliD.majMdp(mail, mdp2);
					default:
						menuPrincipal();
						break;
				}
			}
		}
		menuPrincipal();
	}

	private static void modifCarteAbo(String mail) {
	}

}
