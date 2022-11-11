package main;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Scanner;

import dao.ClientDAO;
import dao.EmpruntDAO;
import dao.GardienDAO;
import dao.LocationDAO;
import modele.Carte;
import modele.Client;
import modele.Film;
import modele.Gardien;
import modele.Genre;
import modele.Personne;
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
	}

	private static void location() {
		System.out.println("Que souhaitez-vous faire ?");
		int choix;
		System.out.println("[1] Derniers films en date");
		System.out.println("[2] Recherche de film");
		System.out.println("[0] Retour");
		choix = LectureClavier.lireEntier("");
		System.out.flush();
		String nomFL[];
		LocationDAO locD = new LocationDAO(s1.getSession());
		RechercheFilm recherche;
		Film filmVoulu;
		switch (choix) {
			case 1:
				System.out.println("Voilà les derniers films ajoutés au système : ");
				recherche = locD.dernierFilmAjoute();
				nomFL = afficherRechercheFilm(recherche, 5);
				break;
			case 2:
				System.out.println("Comment voulez vous rechercher ?");
				System.out.println("[1] Par Nom");
				System.out.println("[2] Par Genre");
				System.out.println("[3] Par Limite d'âge");
				System.out.println("[4] Par Acteur");
				System.out.println("[5] Par Realisateur");
				System.out.println("[6] Par Nombre de Location");
				System.out.println("[0] Annuler");
				choix = LectureClavier.lireEntier("");
				String rechS;
				int rechI, nb;
				boolean location = false;
				switch (choix) {
					case 1:
						System.out.println("Entrez le nom du film :");
						rechS = LectureClavier.lireChaine();
						recherche = locD.rechercheParNom(rechS);
						if (recherche.getnbFilm() == 0) {
							System.out.println("Aucun film ne correspond à votre recherche !");
						} else {
							do {
								nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
								choix = LectureClavier.lireEntier("");
								if (choix >= 1 && (choix < recherche.getnbFilm())) {
									filmVoulu = locD.detailFilm(nomFL[choix - 1]);
									location = afficherDetailFilm(filmVoulu);
								} else {
									System.out.println("Entrez un numero valide");
								}
							} while (!location);
						}
						break;
					case 2:
						System.out.println("Voici tous les genres que nous avons :");
						recherche = locD.listeGenre();
						String nomG = "";
						String[] nomGL = new String[recherche.getnbGenre()];
						nb = 1;
						for (Iterator<Genre> it = recherche.getGenre().iterator(); it.hasNext();) {
							nomG = it.next().getnomGenre();
							System.out.println("[" + nb + "] " + nomG);
							nomGL[nb - 1] = nomG;
							nb++;
						}
						choix = LectureClavier.lireEntier("");
						while (choix <= 0 || choix > recherche.getnbGenre()) {
							System.out.println("Entrez un chiffre valide");
							choix = LectureClavier.lireEntier("");
						}
						recherche = locD.rechercheParGenre(nomGL[choix - 1]);
						nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
						break;
					case 3:
						System.out.println("Entrez la limite d'age :");
						rechI = LectureClavier.lireEntier("");
						recherche = locD.rechercheParLimiteAge(rechI);
						if (recherche.getnbFilm() == 0) {
							System.out.println("Aucun film ne correspond à votre recherche !");
						} else {
							nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
						}
						break;
					case 4:
						System.out.println("Comment voulez vous rechercher ?");
						System.out.println("[1] Voir la liste de tous les acteurs");
						System.out.println("[2] Taper le nom de l'acteur voulu");
						rechI = LectureClavier.lireEntier("");
						if (rechI == 1 || rechI == 2) {
							if (rechI == 1) {
								recherche = locD.listeActeur();
								String nomA = "";
								String[] nomAL = new String[recherche.getnbActeur()];
								nb = 1;
								for (Iterator<Personne> it = recherche.getActeur().iterator(); it.hasNext();) {
									nomA = it.next().getnomPersonne();
									System.out.println("[" + nb + "] " + nomA);
									nomAL[nb - 1] = nomA;
									nb++;
								}
								choix = LectureClavier.lireEntier("");
								while (choix <= 0 || choix > recherche.getnbActeur()) {
									System.out.println("Entrez un chiffre valide");
									choix = LectureClavier.lireEntier("");
								}
								recherche = locD.rechercheParActeur(nomAL[choix - 1]);
							} else {
								System.out.println("Entrez le nom de l'acteur rechercher :");
								rechS = LectureClavier.lireChaine();
								recherche = locD.rechercheParActeur(rechS);
							}
							if (recherche.getnbFilm() == 0) {
								System.out.println("Aucun film ne correspond à votre recherche !");
							} else {
								nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
							}
						} else {
							System.out.println("Entrée invalide.");
						}
						break;
					case 5:
						System.out.println("Comment voulez vous rechercher ?");
						System.out.println("[1] Voir la liste de tous les réalisateurs");
						System.out.println("[2] Taper le nom du réalisateur voulu");
						rechI = LectureClavier.lireEntier("");
						if (rechI == 1 || rechI == 2) {
							if (rechI == 1) {
								recherche = locD.listeRealisateur();
								String nomR = "";
								String[] nomRL = new String[recherche.getnbRealisateur()];
								nb = 1;
								for (Iterator<Personne> it = recherche.getRealisateur().iterator(); it.hasNext();) {
									nomR = it.next().getnomPersonne();
									System.out.println("[" + nb + "] " + nomR);
									nomRL[nb - 1] = nomR;
									nb++;
								}
								choix = LectureClavier.lireEntier("");
								while (choix <= 0 || choix > recherche.getnbRealisateur()) {
									System.out.println("Entrez un chiffre valide");
									choix = LectureClavier.lireEntier("");
								}
								recherche = locD.rechercheParRealisateur(nomRL[choix - 1]);
							} else {
								System.out.println("Entrez le nom de l'acteur rechercher :");
								rechS = LectureClavier.lireChaine();
								recherche = locD.rechercheParRealisateur(rechS);
							}
							if (recherche.getnbFilm() == 0) {
								System.out.println("Aucun film ne correspond à votre recherche !");
							} else {
								nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
							}
						} else {
							System.out.println("Entrée invalide.");
						}
						break;
					case 6:
						System.out.println("Voici les 10 films les plus loués :");
						recherche = locD.topLocation();
						nomFL = afficherRechercheFilm(recherche, 10);
						break;
					default:
						break;
				}
				break;
			case 0:
				break;
			default:
				break;
		}
		menuPrincipal();
	}

	private static String[] afficherRechercheFilm(RechercheFilm recherche, int nbFilm) {
		String nomF = "";
		String[] nomFL = new String[nbFilm];
		int nb = 1;
		for (Iterator<Film> it = recherche.getFilms().iterator(); it.hasNext();) {
			nomF = it.next().getnomFilm();
			System.out.println("[" + nb + "] " + nomF);
			nomFL[nb - 1] = nomF;
			nb++;
		}
		return nomFL;
	}

	private static boolean afficherDetailFilm(Film f){
		boolean sortie = false;
		System.out.println(f.getnomFilm());
		System.out.println();
		return sortie;
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

				if (nb >= 1 && nb <= nbEmprunt) {
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
		} else {
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
		System.out.println("Que voulez vous faire ?");
		System.out.println("[1] Faire une nouvelle carte");
		System.out.println("[2] Modifier mes cartes");
		System.out.println("[0] Annuler");
		int choix = LectureClavier.lireEntier("");
		switch (choix) {
			case 1:
				creationCarteAbonnement(mail);
				break;
			case 2:
				ClientDAO cliD = new ClientDAO(s1.getSession());
				Client client = cliD.listeCarte(mail);
				System.out.println(
						"Voici la liste des cartes que vous avez possédez.\nMerci d'écrire le numéro de la carte que vous voulez modifer.");
				int nb = 1;
				String[] nomCL = new String[client.getnbCarte()];
				String nomC;
				for (Iterator<Carte> it = client.getCarteAbo().iterator(); it.hasNext();) {
					nomC = it.next().getnomCarteAbonnement();
					System.out.println("[" + nb + "] " + nomC);
					nomCL[nb - 1] = nomC;
					nb++;
				}
				nb = LectureClavier.lireEntier("");

				if (nb >= 1 && nb <= client.getnbCarte()) {
					Carte carte = cliD.avoirLaCarte(mail, nomCL[nb - 1]);
					System.out.println("Carte de : " + carte.getnomCarteAbonnement());
					System.out.println("Solde sur la carte : " + carte.getsoldeCarteAbonnement());
					System.out.println("Age du propriétaire : " + carte.getagePropietaireCarteAbonnement());
					System.out.println("\nQue voulez vous faire ?");
					System.out.println("[1] Modifier le nom sur la carte");
					System.out.println("[2] Créditer la carte");
					System.out.println("[3] Modifier l\'age du propriétaire de la carte");
					System.out.println("[4] Supprimer la carte");
					System.out.println("[0] Annuler");
					choix = LectureClavier.lireEntier("");
					switch (choix) {
						case 1:
							System.out.println("Entrez le nouveau nom sur la carte :");
							String nom = LectureClavier.lireChaine();

							if (!cliD.nomCartePrit(mail, carte.getnomCarteAbonnement())) {
								cliD.majNomCarte(mail, carte.getnomCarteAbonnement(), nom);
							} else {
								System.out.println("Vous avez déjà une carte avec ce nom !");
							}
							break;

						case 2:
							System.out.println("Entrez le montant à créditer :");
							int somme = LectureClavier.lireEntier("");
							cliD.majSoldeCarte(mail, carte.getnomCarteAbonnement(), somme);
							break;

						case 3:
							System.out.println("Entrez le nouvel age du propriétaire :");
							int age = LectureClavier.lireEntier("");
							cliD.majAgeCarte(mail, carte.getnomCarteAbonnement(), age);
							break;

						case 4:
							System.out.println("Entrez votre mot de passe par sécurité");
							String mdp = LectureClavier.lireChaine();
							if (cliD.suppCarte(mail, carte.getnomCarteAbonnement(), mdp)) {
								System.out.println("La carte à été supprimée");
							} else {
								System.out.println("Mauvais mot de passe, impossible de supprimer la carte");
							}

						default:
							break;
					}
				} else {
					System.out.println("Le numéro de la carte n'est pas valide.\nRetour à la page d'accueil.");
				}
				break;
			default:
				break;
		}
	}
}