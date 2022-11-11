package dao;

import modele.Gardien;
import modele.Genre;
import modele.Personne;
import modele.RechercheFilm;
import modele.Cage;
import modele.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO extends DAO<Gardien> {
	public LocationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Gardien obj) {
		return false;
	}

	public RechercheFilm dernierFilmAjoute() {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM (SELECT * FROM FILM ORDER BY DateAjoutFilm DESC) WHERE rownum <= 5")) {

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm topLocation() {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM (SELECT * FROM FILM ORDER BY NombreTotalLocationFilm DESC) WHERE rownum <= 5")) {

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm rechercheParNom(String nom) {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM FILM WHERE NomFilm LIKE ?")) {

			nom = "%" + nom + "%";
			lesFilms.setString(1, nom);

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			int nbFilm = 0;
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
				nbFilm++;
			}
			recherche.setNbFilm(nbFilm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm rechercheParGenre(String nom) {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM CATEGORIE WHERE NomGenre = ?")) {

			lesFilms.setString(1, nom);

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			int nbFilm = 0;
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
				nbFilm++;
			}
			recherche.setNbFilm(nbFilm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm rechercheParLimiteAge(int lim) {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM FILM WHERE LimiteAgeFilm >= ?")) {

			lesFilms.setInt(1, lim);

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			int nbFilm = 0;
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
				nbFilm++;
			}
			recherche.setNbFilm(nbFilm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm rechercheParActeur(String nom) {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM JOUER WHERE NomPrenomActeur LIKE ?")) {

			nom = "%" + nom + "%";
			lesFilms.setString(1, nom);

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			int nbFilm = 0;
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
				nbFilm++;
			}
			recherche.setNbFilm(nbFilm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm rechercheParRealisateur(String nom) {
		RechercheFilm recherche = null;

		try (PreparedStatement lesFilms = conn
				.prepareStatement(
						"SELECT NomFilm FROM FILM WHERE NomPrenomRealisateur LIKE ?")) {

			nom = "%" + nom + "%";
			lesFilms.setString(1, nom);

			ResultSet resultSet = lesFilms.executeQuery();

			recherche = new RechercheFilm();
			int nbFilm = 0;
			while (resultSet.next()) {
				Film f = new Film();
				f.setnomFilm(resultSet.getString(1));
				recherche.addFilm(f);
				nbFilm++;
			}
			recherche.setNbFilm(nbFilm);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm listeGenre() {
		RechercheFilm recherche = null;

		try (PreparedStatement lesGenres = conn
				.prepareStatement(
						"SELECT NomGenre FROM GENRE")) {

			ResultSet resultSet = lesGenres.executeQuery();

			recherche = new RechercheFilm();
			int nbGenre = 0;
			while (resultSet.next()) {
				Genre g = new Genre();
				g.setnomGenre(resultSet.getString(1));
				recherche.addGenre(g);
				nbGenre++;
			}
			recherche.setnbGenre(nbGenre);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm listeActeur() {
		RechercheFilm recherche = null;

		try (PreparedStatement lesActeurs = conn
				.prepareStatement(
						"SELECT NomPrenomActeur FROM ACTEUR")) {

			ResultSet resultSet = lesActeurs.executeQuery();

			recherche = new RechercheFilm();
			int nbActeurs = 0;
			while (resultSet.next()) {
				Personne a = new Personne();
				a.setnomPersonne(resultSet.getString(1));
				recherche.addActeur(a);
				nbActeurs++;
			}
			recherche.setnbActeur(nbActeurs);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
	}

	public RechercheFilm listeRealisateur() {
		RechercheFilm recherche = null;

		try (PreparedStatement lesRealisateurs = conn
				.prepareStatement(
						"SELECT NomPrenomRealisateur FROM REALISATEUR")) {

			ResultSet resultSet = lesRealisateurs.executeQuery();

			recherche = new RechercheFilm();
			int nbRealisateur = 0;
			while (resultSet.next()) {
				Personne r = new Personne();
				r.setnomPersonne(resultSet.getString(1));
				recherche.addRealisateur(r);
				nbRealisateur++;
			}
			recherche.setnbActeur(nbRealisateur);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return recherche;
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
