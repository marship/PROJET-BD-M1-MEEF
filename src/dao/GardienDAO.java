package dao;

import modele.Gardien;
import modele.Cage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GardienDAO extends DAO<Gardien> {
	public GardienDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Gardien obj) {
		return false;
	}

	@Override
	public Gardien read(Object g) {
		Gardien gardien = null;

		try (PreparedStatement lesEmployes = conn.prepareStatement("SELECT NOME, ADRESSE FROM LESEMPLOYES WHERE NOME = ?");
		     PreparedStatement lesGardiens = conn.prepareStatement("SELECT NOCAGE FROM LESGARDIENS WHERE NOME = ?");
		     PreparedStatement lesSpecialites = conn.prepareStatement("SELECT FONCTION_CAGE FROM LESSPECIALITES WHERE NOME = ?")) {
			lesEmployes.setString(1, (String)g);
			ResultSet resultSet = lesEmployes.executeQuery();

			gardien = new Gardien();
			if (resultSet.next()) {
				gardien.setNomE(resultSet.getString(1));
				gardien.setAdresse(resultSet.getString(2));
			}

			lesGardiens.setString(1, (String)g);
			resultSet = lesGardiens.executeQuery();
			while (resultSet.next()) {
				Cage c = new Cage();
				c.setNoCage(resultSet.getInt(1));
				gardien.addCage(c);
			}

			lesSpecialites.setString(1, (String)g);
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

	public boolean updateAffectation(Gardien g , Cage csource, Cage cdest) {
		try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE LESGARDIENS SET NOCAGE = ? WHERE NOCAGE = ? AND NOME = ?")) {
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
