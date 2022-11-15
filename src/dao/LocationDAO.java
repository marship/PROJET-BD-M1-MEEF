package dao;

import modele.Genre;
import modele.Personne;
import modele.RechercheFilm;
import modele.Client;
import modele.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LocationDAO extends DAO<Client> {
	public LocationDAO(Connection conn) {
		super(conn);
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
						"SELECT NomFilm FROM FILM WHERE LimiteAgeFilm <= ?")) {

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
			recherche.setnbRealisateur(nbRealisateur);

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
				film.setdateSortieFilm(resultSet.getString(3));
				film.setdureeFilm(resultSet.getString(4));
				film.setnombreExemplaireFilm(resultSet.getInt(5));
				film.setlimiteAgeFilm(resultSet.getInt(6));
				film.setdateAjoutFilm(resultSet.getString(7));
				film.setnombreTotalLocationFilm(resultSet.getInt(8));
				film.setNomPrenomRealisateur(resultSet.getString(9));
			}

			lesActeurs.setString(1, nomF);
			resultSet = lesActeurs.executeQuery();

			while (resultSet.next()) {
				Personne p = new Personne();
				p.setnomPersonne(resultSet.getString(2));
				film.addActeur(p);
			}

			lesGenre.setString(1, nomF);
			resultSet = lesGenre.executeQuery();

			while (resultSet.next()) {
				Genre g = new Genre();
				g.setnomGenre(resultSet.getString(2));
				film.addGenre(g);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return film;
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
