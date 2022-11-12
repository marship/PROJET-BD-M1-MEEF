package dao;

import modele.Client;
import modele.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmpruntDAO extends DAO<Film> {
	public EmpruntDAO(Connection conn) {
		super(conn);
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

	public void empruntFilm(String mail, String nomF, Date date, String type, String tarif) {
		try (PreparedStatement addFilm = conn
				.prepareStatement("INSERT INTO EMPRUNT (DateDebutEmprunt, NomFilm, AdresseMailClient, TypeSupport, NomTarif) VALUES (?, ?, ?, ?, ?)");) {

			addFilm.setDate(1, (java.sql.Date) date);
			addFilm.setString(2, nomF);
			addFilm.setString(3, mail);
			addFilm.setString(4, type);
			addFilm.setString(5, tarif);
			addFilm.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public boolean create(Film obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Film read(Object obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean update(Film obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Film obj) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
