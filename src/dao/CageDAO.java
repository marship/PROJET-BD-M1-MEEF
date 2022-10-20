package dao;

import modele.Cage;
import modele.Gardien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CageDAO extends DAO<Cage> {
	public CageDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean create(Cage obj) {
		return false;
	}

	@Override
	public Cage read(Object id) {
		Cage cage = null;

		try (PreparedStatement lesCages = conn.prepareStatement("SELECT NOCAGE, FONCTION, NOALLEE FROM LESCAGES WHERE NOCAGE = ?");
		     PreparedStatement lesGardiens = conn.prepareStatement("SELECT NOME FROM LESGARDIENS WHERE NOCAGE = ?")) {
			lesCages.setInt(1, (Integer)id);
			ResultSet resultSet = lesCages.executeQuery();

			cage = new Cage();
			if (resultSet.next()) {
				cage.setNoCage(resultSet.getInt(1));
				cage.setFonction(resultSet.getString(2));
				cage.setNoAlle(resultSet.getLong(3));
			}

			lesGardiens.setInt(1, (Integer)id);
			resultSet = lesGardiens.executeQuery();
			while (resultSet.next()) {
				Gardien g=new Gardien();
				g.setNomE(resultSet.getString(1));
				cage.addGardien(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cage;
	}

	@Override
	public boolean update(Cage obj) {
		try (PreparedStatement preparedStatement = conn.prepareStatement("UPDATE LESCAGES SET FONCTION = ?, NOALLEE = ? WHERE NOCAGE = ?")) {
			preparedStatement.setString(1, obj.getFonction());
			preparedStatement.setLong(2, obj.getNoAlle());
			preparedStatement.setInt(3, obj.getNoCage());

			return preparedStatement.executeUpdate() > 0;
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean delete(Cage obj) {
		return false;
	}

	public Set<Cage> readAvailableCagesForGardien(Gardien g) {
		Set<Cage> noCages = new HashSet<>();

		try (PreparedStatement preparedStatement = conn.prepareStatement("SELECT NOCAGE " +
				"FROM LESCAGES " +
				"WHERE FONCTION IN " +
				"(SELECT FONCTION_CAGE FROM LESSPECIALITES WHERE NOME = ?)")) {
			preparedStatement.setString(1, g.getNomE());
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Cage c = new Cage();
				c.setNoCage(resultSet.getInt(1));
				noCages.add(c);
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		}

		return noCages;
	}
}
