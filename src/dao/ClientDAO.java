package dao;

import modele.Gardien;
import modele.Cage;
import modele.Client;
import modele.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDAO extends DAO<Gardien> {
	public ClientDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Gardien obj) {
		return false;
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
			lesClients.setString(1, mail);
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
	public Gardien read(Object g) {
		Gardien gardien = null;

		try (PreparedStatement lesEmployes = conn
				.prepareStatement("SELECT NOME, ADRESSE FROM LESEMPLOYES WHERE NOME = ?");
				PreparedStatement lesGardiens = conn.prepareStatement("SELECT NOCAGE FROM LESGARDIENS WHERE NOME = ?");
				PreparedStatement lesSpecialites = conn
						.prepareStatement("SELECT FONCTION_CAGE FROM LESSPECIALITES WHERE NOME = ?")) {
			lesEmployes.setString(1, (String) g);
			ResultSet resultSet = lesEmployes.executeQuery();

			gardien = new Gardien();
			if (resultSet.next()) {
				gardien.setNomE(resultSet.getString(1));
				gardien.setAdresse(resultSet.getString(2));
			}

			lesGardiens.setString(1, (String) g);
			resultSet = lesGardiens.executeQuery();
			while (resultSet.next()) {
				Cage c = new Cage();
				c.setNoCage(resultSet.getInt(1));
				gardien.addCage(c);
			}

			lesSpecialites.setString(1, (String) g);
			resultSet = lesSpecialites.executeQuery();
			while (resultSet.next()) {
				gardien.addSpecialites(resultSet.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return gardien;
	}

	@Override
	public boolean update(Gardien obj) {
		return false;
	}

	@Override
	public boolean delete(Gardien obj) {
		return false;
	}

	public boolean updateAffectation(Gardien g, Cage csource, Cage cdest) {
		try (PreparedStatement preparedStatement = conn
				.prepareStatement("UPDATE LESGARDIENS SET NOCAGE = ? WHERE NOCAGE = ? AND NOME = ?")) {
			preparedStatement.setInt(1, cdest.getNoCage());
			preparedStatement.setInt(2, csource.getNoCage());
			preparedStatement.setString(3, g.getNomE());

			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return false;
	}
}
