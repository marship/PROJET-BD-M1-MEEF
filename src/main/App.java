package main;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import dao.ClientDAO;
import dao.EmpruntDAO;
import dao.LocationDAO;
import modele.Carte;
import modele.Client;
import modele.Film;
import modele.Genre;
import modele.Personne;
import modele.RechercheFilm;
import utils.LectureClavier;
import utils.Session;

public class App {

	static Session s1;

	public static void main(String args[]) {
		try{
			
		/* Menu utilisateur */
		System.out.println("Bienvenue sur Didier Futur !");
		s1 = new Session();
		s1.open();
		menuPrincipal();
		s1.close();
		System.out.println("Merci d'avoir utilisé Didier Futur et à bientôt !");
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

	private static void menuPrincipal() throws SQLException  {
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

	private static void location() throws SQLException  {
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
		boolean boucle = true;
		switch (choix) {
			case 1:
				System.out.println("Voilà les derniers films ajoutés au système : ");
				recherche = locD.dernierFilmAjoute();
				boucle = true;
				do {
					nomFL = afficherRechercheFilm(recherche, 5);
					choix = LectureClavier.lireEntier("");
					if (choix >= 1 && (choix < 5)) {
						filmVoulu = locD.detailFilm(nomFL[choix - 1]);
						boucle = afficherDetailFilm(filmVoulu);
					} else {
						if (choix == 0) {
							boucle = false;
						} else {
							System.out.println("Entrez un numero valide");
						}
					}
				} while (boucle);
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
				boucle = true;
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
									boucle = afficherDetailFilm(filmVoulu);
								} else {
									if (choix == 0) {
										boucle = false;
									} else {
										System.out.println("Entrez un numero valide");
									}
								}
							} while (boucle);
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
						do {
							nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
							choix = LectureClavier.lireEntier("");
							if (choix >= 1 && (choix < recherche.getnbFilm())) {
								filmVoulu = locD.detailFilm(nomFL[choix - 1]);
								boucle = afficherDetailFilm(filmVoulu);
							} else {
								if (choix == 0) {
									boucle = false;
								} else {
									System.out.println("Entrez un numero valide");
								}
							}
						} while (boucle);
						break;
					case 3:
						System.out.println("Entrez la limite d'age :");
						rechI = LectureClavier.lireEntier("");
						recherche = locD.rechercheParLimiteAge(rechI);
						if (recherche.getnbFilm() == 0) {
							System.out.println("Aucun film ne correspond à votre recherche !");
						} else {
							do {
								nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
								choix = LectureClavier.lireEntier("");
								if (choix >= 1 && (choix < recherche.getnbFilm())) {
									filmVoulu = locD.detailFilm(nomFL[choix - 1]);
									boucle = afficherDetailFilm(filmVoulu);
								} else {
									if (choix == 0) {
										boucle = false;
									} else {
										System.out.println("Entrez un numero valide");
									}
								}
							} while (boucle);
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
								do {
									nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
									choix = LectureClavier.lireEntier("");
									if (choix >= 1 && (choix < recherche.getnbFilm())) {
										filmVoulu = locD.detailFilm(nomFL[choix - 1]);
										boucle = afficherDetailFilm(filmVoulu);
									} else {
										if (choix == 0) {
											boucle = false;
										} else {
											System.out.println("Entrez un numero valide");
										}
									}
								} while (boucle);
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
								do {
									nomFL = afficherRechercheFilm(recherche, recherche.getnbFilm());
									choix = LectureClavier.lireEntier("");
									if (choix >= 1 && (choix < recherche.getnbFilm())) {
										filmVoulu = locD.detailFilm(nomFL[choix - 1]);
										boucle = afficherDetailFilm(filmVoulu);
									} else {
										if (choix == 0) {
											boucle = false;
										} else {
											System.out.println("Entrez un numero valide");
										}
									}
								} while (boucle);
							}
						} else {
							System.out.println("Entrée invalide.");
						}
						break;
					case 6:
						System.out.println("Voici les 10 films les plus loués :");
						recherche = locD.topLocation();
						do {
							nomFL = afficherRechercheFilm(recherche, 10);
							choix = LectureClavier.lireEntier("");
							if (choix >= 1 && (choix < 10)) {
								filmVoulu = locD.detailFilm(nomFL[choix - 1]);
								boucle = afficherDetailFilm(filmVoulu);
							} else {
								if (choix == 0) {
									boucle = false;
								} else {
									System.out.println("Entrez un numero valide");
								}
							}
						} while (boucle);
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

	private static String[] afficherRechercheFilm(RechercheFilm recherche, int nbFilm) throws SQLException  {
		String nomF = "";
		String[] nomFL = new String[nbFilm];
		int nb = 1;
		for (Iterator<Film> it = recherche.getFilms().iterator(); it.hasNext();) {
			nomF = it.next().getnomFilm();
			System.out.println("[" + nb + "] " + nomF);
			nomFL[nb - 1] = nomF;
			nb++;
		}
		System.out.println("[0] Retour");
		return nomFL;
	}

	private static boolean afficherDetailFilm(Film f) throws SQLException  {

		boolean boucle = true;

		System.out.println(f.getnomFilm());
		System.out.println();
		System.out.print("Sorti le : " + f.getdateSortieFilm() + "/" + f.getdureeFilm() + "/");
		for (Iterator<Genre> it = f.getGenre().iterator(); it.hasNext();) {
			System.out.print(it.next().getnomGenre());
		}
		if (f.getlimiteAgeFilm() != 0) {
			System.out.println("/Interdit aux moins de " + f.getlimiteAgeFilm() + "ans");
		} else {
			System.out.println();
		}
		System.out.println("Un film de : " + f.getNomPrenomRealisateur());
		System.out.println("Avec :");
		for (Iterator<Personne> it = f.getActeur().iterator(); it.hasNext();) {
			System.out.print(it.next().getnomPersonne());
		}
		System.out.println();
		System.out.println("SYNOPSIS :");
		System.out.println(f.getresumeFilm());
		System.out.println("Film ajouté le :" + f.getdateAjoutFilm() + ", Loué " + f.getnombreTotalLocationFilm());
		System.out.println("Il reste " + f.getnombreExemplaireFilm() + "exmplaire en physique du film");
		System.out.println();
		System.out.println("Que voulez vous faire ?");
		System.out.println("[1] Le louer");
		System.out.println("[2] L'ajouter à la liste de mes films à voir");
		System.out.println("[0] Revenir en arrière");

		int choix = LectureClavier.lireEntier("");
		if (choix == 1 || choix == 2) {
			if (choix == 1) {
				boucle = choixLocation(f);
			} else {
				boucle = choixWish(f);
			}
		} else {
			boucle = true;
		}
		return boucle;
	}

	private static boolean choixLocation(Film f) throws SQLException  {
		boolean boucle = true;
		System.out.println("Vous voulez louer le film :" + f.getnomFilm());
		System.out.println("Merci de vous connecter ou de faire un compte");
		System.out.println("[1] Se connecter");
		System.out.println("[2] Faire un compte");
		System.out.println("[0] Annuler");
		int choix = LectureClavier.lireEntier("");
		switch (choix) {
			case 2:
				creationCompte();
				System.out.println("Merci de vous connectez");
			case 1:
				System.out.println("Entrez votre adresse mail :");
				String mail = LectureClavier.lireChaine();
				System.out.println("Entrez votre mot de passe :");
				String mdp = LectureClavier.lireChaine();
				ClientDAO cliD = new ClientDAO(s1.getSession());
				if (!cliD.connexion(mail, mdp)) {
					EmpruntDAO empD = new EmpruntDAO(s1.getSession());
					if (empD.nbEmprunt(mail) == 3) {
						System.out.println(
								"Trois locations au maximun en même temps !\nRendez des films et revenez nous voir !");
						System.out.println(
								"Vous pouvez l'ajouter dans votre liste de shouait en attendant.\nRépondez par o/n");
						boolean ajout = LectureClavier.lireOuiNon("");
						if (ajout) {
							cliD.ajoutWish(mail, f.getnomFilm());
						}
					} else {
						System.out.println("Quel type de support voulez vous ?");
						System.out.println("[1] QR Code");
						if (f.getnombreExemplaireFilm() > 0) {
							System.out.println("[2] Physique");
						}
						choix = LectureClavier.lireEntier("");
						String type;
						if (choix == 2 && f.getnombreExemplaireFilm() > 0) {
							type = "Physique";
						} else {
							type = "QR Code";
						}
						System.out.println("Comment voulez vous payer ?");
						System.out.println("[1] Carte bancaire");
						System.out.println("[2] Carte abonné");
						choix = LectureClavier.lireEntier("");
						String tarif;
						if (choix == 2) {
							tarif = "Adhérent"; // Faire afficher la liste des cartes du mec, lui faire choisir, vérif
												// la somme sur la carte, pouvoir en faire une nouvelle
						} else {
							tarif = "Défaut";
						}
						Date jour = new Date();
						empD.empruntFilm(f.getnomFilm(), mail, jour, type, tarif);
					}
					boucle = false;
				} else {
					System.out.println("Erreur de connexion, retour sur la page du film");
					afficherDetailFilm(f);
				}
				break;
			default:
				break;
		}
		return boucle;
	}

	private static boolean choixWish(Film f) throws SQLException  {
		boolean boucle = true;
		System.out.println("Vous voulez mettre dans votre liste le film :" + f.getnomFilm());
		System.out.println("Merci de vous connecter ou de faire un compte");
		System.out.println("[1] Se connecter");
		System.out.println("[2] Faire un compte");
		System.out.println("[0] Annuler");
		int choix = LectureClavier.lireEntier("");
		switch (choix) {
			case 2:
				creationCompte();
				System.out.println("Merci de vous connectez");
			case 1:
				System.out.println("Entrez votre adresse mail :");
				String mail = LectureClavier.lireChaine();
				System.out.println("Entrez votre mot de passe :");
				String mdp = LectureClavier.lireChaine();
				ClientDAO cliD = new ClientDAO(s1.getSession());
				if (!cliD.connexion(mail, mdp)) {
					cliD.ajoutWish(mail, f.getnomFilm());
					boucle = false;
				} else {
					System.out.println("Erreur de connexion, retour sur la page du film");
					afficherDetailFilm(f);
				}
				break;
			default:
				break;
		}
		return boucle;
	}

	private static void rendre() throws SQLException  {
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

	private static void gestion() throws SQLException  {
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

	private static void creationCompte() throws SQLException  {
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
	}

	private static void creationCarteAbonnement(String mail) throws SQLException  {
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

	private static void changementInformations() throws SQLException  {
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
				System.out.println("[9] Liste de Souhait");
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
						System.out.println("Entrez votre nouveau mot de passe");
						String mdp2 = LectureClavier.lireChaine();

						cliD.majMdp(mail, mdp2);
					case 9:
						listeSouhait(mail);
					default:
						menuPrincipal();
						break;
				}
			}
		}
		menuPrincipal();
	}

	private static void modifCarteAbo(String mail) throws SQLException  {
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

	private static void listeSouhait(String mail) throws SQLException  {
		ClientDAO cliD = new ClientDAO(s1.getSession());
		Client client = cliD.listeWish(mail);
		System.out.println(
				"Voici la liste des films que vous voulez regarder.\nMerci d'écrire le numéro du film à traiter.");
		Film f;
		Film[] nomFL = new Film[client.getnbWish()];
		int nb = 1;
		for (Iterator<Film> it = client.getWish().iterator(); it.hasNext();) {
			f = it.next();
			System.out.println("[" + nb + "] " + f.getnomFilm());
			nomFL[nb - 1] = f;
			nb++;
		}
		System.out.println("[0] Retour");
		int choix = LectureClavier.lireEntier("");
		if (nb >= 1 && nb <= client.getnbWish()) {
			f = nomFL[nb - 1];
			System.out.println("Que voulez vous faire ?");
			System.out.println("[1] Aller sur la page du film");
			System.out.println("[2] Le supprimer de ma liste de Souhait");
			System.out.println("[0] Annuler");
			choix = LectureClavier.lireEntier("");
			switch (choix) {
				case 1:
					afficherDetailFilm(f);
					break;
				case 2:
					cliD.suppWish(mail, f.getnomFilm());
				default:
					break;
			}
		} else {
			System.out.println("Le numéro du film n'est pas valide.");
		}
	}
}