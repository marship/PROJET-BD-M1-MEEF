package dao;

import modele.Genre;
import modele.Personne;
import modele.Carte;
import modele.Client;
import modele.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends DAO<Client> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	// True si mail absent
	public boolean mailValide(Object g) {
		boolean sortie = false;

		try (PreparedStatement lesClients = conn
				.prepareStatement("SELECT COUNT (*) FROM CLIENT WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, (String) g);
			ResultSet resultSet = lesClients.executeQuery();

			int nbClient = 0;
			if (resultSet.next()) {
				nbClient = resultSet.getInt(1);
			}

			if (nbClient == 0) {
				sortie = true;
			} else {
				sortie = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sortie;
	}

	// True si il n'y a pas une carte avec ce nom et cette adresse mail
	public boolean nomCartePrit(String nomCarte, String mail) {
		boolean sortie = false;

		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"SELECT COUNT (*) FROM CARTE_ABONNEMENT WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesClients.setString(1, nomCarte);
			lesClients.setString(2, mail);
			ResultSet resultSet = lesClients.executeQuery();

			int nbClient = 0;
			if (resultSet.next()) {
				nbClient = resultSet.getInt(1);
			}

			if (nbClient == 0) {
				sortie = true;
			} else {
				sortie = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sortie;
	}

	// True si la connexion est valide
	public boolean connexion(String mail, String mdp) {
		boolean sortie = false;

		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"SELECT COUNT (*) FROM CLIENT WHERE AdresseMailClient = ? AND MotDePasseClient = ?");) {

			lesClients.setString(1, mail);
			lesClients.setString(2, mdp);
			ResultSet resultSet = lesClients.executeQuery();

			int nbClient = 0;
			if (resultSet.next()) {
				nbClient = resultSet.getInt(1);
			}

			if (nbClient == 0) {
				sortie = false;
			} else {
				sortie = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return sortie;
	}

	public void majNomCarte(String mail, String nomA, String nomN) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CARTE_ABONNEMENT SET NomCarteAbonnement = ? WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesClients.setString(1, nomN);
			lesClients.setString(2, mail);
			lesClients.setString(3, nomA);

			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majSoldeCarte(String mail, String nomC, int somme) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CARTE_ABONNEMENT SET SoldeCarteAbonnement = SoldeCarteAbonnement + ? WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesClients.setInt(1, somme);
			lesClients.setString(2, mail);
			lesClients.setString(3, nomC);

			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majAgeCarte(String mail, String nomC, int age) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CARTE_ABONNEMENT SET AgePropietaireCarteAbonnement = ? WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesClients.setInt(1, age);
			lesClients.setString(2, mail);
			lesClients.setString(3, nomC);

			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean suppCarte(String mail, String nomC, String mdp) {
		boolean sortie = false;
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"DELETE FROM CARTE_ABONNEMENT WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesClients.setString(1, mail);
			lesClients.setString(2, nomC);

			if (connexion(mail, mdp)) {
				lesClients.executeQuery();
				sortie = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sortie;
	}

	public void majNom(String mail, String nom) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CLIENT SET NomClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, nom);
			lesClients.setString(2, mail);

			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majPrenom(String mail, String prenom) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CLIENT SET PrenomClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, prenom);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majMail(String mail, String mail2) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CLIENT SET AdresseMailClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, mail2);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majAdresse(String mail, String adresse) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CLIENT SET AdressePostalClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, adresse);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majTel(String mail, String tel) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CLIENT SET NumeroTelephoneClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, tel);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majCarte(String mail, String num, String date, String picto) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CARTE_BANCAIRE SET NumeroTelephoneClient = ?, ExpirationCarteBancaire = ?, PictogrammeCarteBancaire = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, num);
			lesClients.setString(2, date);
			lesClients.setString(3, picto);
			lesClients.setString(4, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void majMdp(String mail, String mdp) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"UPDATE CARTE_BANCAIRE SET MotDePasseClient = ? WHERE AdresseMailClient = ?");) {

			lesClients.setString(1, mdp);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nouveauMembre(String mail, String nom, String prenom, String adresse, String naiss, String telephone,
			String mdp) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"INSERT INTO CLIENT (AdresseMailClient, NomClient, PrenomClient, AdressePostalClient, DateNaissanceClient, NumeroTelephoneClient, MotDePasseClient) VALUES (?, ?, ?, ?, ?, ?, ?)");) {

			lesClients.setString(1, mail);
			lesClients.setString(2, nom);
			lesClients.setString(3, prenom);
			lesClients.setString(4, adresse);
			lesClients.setString(5, naiss);
			lesClients.setString(6, telephone);
			lesClients.setString(7, mdp);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nouvelleCarteBanque(String mail, String num, String date, String picto) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"INSERT INTO CARTE_BANCAIRE (AdresseMailClient, NumeroCarteBancaire, ExpirationCarteBancaire, PictogrammeCarteBancaire) VALUES (?, ?, ?, ?)");) {

			lesClients.setString(1, mail);
			lesClients.setString(2, num);
			lesClients.setString(3, date);
			lesClients.setString(4, picto);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void nouvelleCarteAbo(String mail, String nomCarte, int montant, int age) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"INSERT INTO CARTE_ABONNEMENT (AdresseMailClient, NomCarteAbonnement, SoldeCarteAbonnement, AgePropietaireCarteAbonnement) VALUES (?, ?, ?, ?)");) {

			lesClients.setString(1, mail);
			lesClients.setString(2, nomCarte);
			lesClients.setInt(3, montant);
			lesClients.setInt(4, age);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajoutWish(String mail, String nomF) {
		try (PreparedStatement lesClients = conn
				.prepareStatement(
						"INSERT INTO SOUHAIT (NomFilm, AdresseMailClient) VALUES (?, ?)");) {

			lesClients.setString(1, nomF);
			lesClients.setString(2, mail);
			lesClients.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void suppWish(String mail, String nomF) {
		try (PreparedStatement suppFilm = conn
				.prepareStatement("DELETE FROM SOUHAIT WHERE AdresseMailClient = ? AND NomFilm = ?");) {

			suppFilm.setString(1, (String) mail);
			suppFilm.setString(2, (String) nomF);
			suppFilm.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int nbEmprunt(Object g) {
		int nbEmprunt = 0;

		try (PreparedStatement lesFilms = conn
				.prepareStatement("SELECT COUNT (*) FROM EMPRUNT WHERE AdresseMailClient = ?");) {

			lesFilms.setString(1, (String) g);
			ResultSet resultSet = lesFilms.executeQuery();

			if (resultSet.next()) {
				nbEmprunt = resultSet.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nbEmprunt;
	}

	public Client listeEmprunt(Object g) {
		Client client = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement("SELECT NomFilm FROM EMPRUNT WHERE AdresseMailClient = ?");) {

			lesFilms.setString(1, (String) g);
			ResultSet resultSet = lesFilms.executeQuery();

			client = new Client();
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				client.addFilm(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	public Client listeWish(String mail) {
		Client client = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement("SELECT NomFilm FROM SOUHAIT WHERE AdresseMailClient = ?");) {

			lesFilms.setString(1, mail);
			ResultSet resultSet = lesFilms.executeQuery();

			client = new Client();
			int nbWish = 0;
			while (resultSet.next()) {
				Film f = detailFilm(resultSet.getString(1));
				client.addWish(f);
				nbWish++;
			}
			client.setnbWish(nbWish);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	public Film detailFilm(String nomF) {
		Film film = null;

		try (PreparedStatement lesFilms = conn.prepareStatement("SELECT * FROM FILM WHERE NomFilm = ?");
				PreparedStatement lesActeurs = conn.prepareStatement("SELECT * FROM JOUER WHERE NomFilm = ?");
				PreparedStatement lesGenre = conn.prepareStatement("SELECT * FROM CATEGORIE WHERE NomFilm = ?")) {

			lesFilms.setString(1, nomF);
			ResultSet resultSet = lesFilms.executeQuery();

			film = new Film();
			while (resultSet.next()) {
				film.setnomFilm(nomF);
				film.setresumeFilm(resultSet.getString(2));
				film.setresumeFilm(resultSet.getString(2));
				film.setdateSortieFilm(resultSet.getDate(3));
				film.setdureeFilm(resultSet.getDate(4));
				film.setnombreExemplaireFilm(resultSet.getInt(5));
				film.setlimiteAgeFilm(resultSet.getInt(6));
				film.setdateAjoutFilm(resultSet.getDate(7));
				film.setnombreTotalLocationFilm(resultSet.getInt(8));
				film.setNomPrenomRealisateur(resultSet.getString(9));
			}

			lesActeurs.setString(1, nomF);
			resultSet = lesFilms.executeQuery();

			while (resultSet.next()) {
				Personne p = new Personne();
				p.setnomPersonne(resultSet.getString(1));
				film.addActeur(p);
			}

			lesGenre.setString(1, nomF);
			resultSet = lesFilms.executeQuery();

			while (resultSet.next()) {
				Genre g = new Genre();
				g.setnomGenre(resultSet.getString(1));
				film.addGenre(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
	}

	public Client listeCarte(Object g) {
		Client client = null;

		try (PreparedStatement lesCartes = conn
				.prepareStatement(
						"SELECT NomCarteAbonnement, SoldeCarteAbonnement, AgePropietaireCarteAbonnement FROM CARTE_ABONNEMENT WHERE AdresseMailClient = ?");) {

			lesCartes.setString(1, (String) g);
			ResultSet resultSet = lesCartes.executeQuery();

			client = new Client();
			int nbCarte = 0;
			while (resultSet.next()) {
				Carte c = new Carte();
				c.setnomCarteAbonnement(resultSet.getString(1));
				c.setadresseMailClient((String) g);
				c.setsoldeCarteAbonnement(resultSet.getInt(2));
				c.setagePropietaireCarteAbonnement(resultSet.getInt(3));
				client.addCarte(c);
				nbCarte++;
			}
			client.setnbCarte(nbCarte);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return client;
	}

	public Carte avoirLaCarte(String mail, String nomC) {
		Carte carte = null;

		try (PreparedStatement lesCartes = conn
				.prepareStatement(
						"SELECT SoldeCarteAbonnement, AgePropietaireCarteAbonnement FROM CARTE_ABONNEMENT WHERE AdresseMailClient = ? AND NomCarteAbonnement = ?");) {

			lesCartes.setString(1, mail);
			lesCartes.setString(2, nomC);
			ResultSet resultSet = lesCartes.executeQuery();

			carte = new Carte();
			if (resultSet.next()) {
				carte.setnomCarteAbonnement(nomC);
				carte.setadresseMailClient(mail);
				carte.setsoldeCarteAbonnement(resultSet.getInt(1));
				carte.setagePropietaireCarteAbonnement(resultSet.getInt(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return carte;
	}

	public void rendreFilm(String mail, String nomF) {
		try (PreparedStatement suppFilm = conn
				.prepareStatement("DELETE FROM EMPRUNT WHERE AdresseMailClient = ? AND NomFilm = ?");) {

			suppFilm.setString(1, (String) mail);
			suppFilm.setString(2, (String) nomF);
			suppFilm.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Client read(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Client obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
