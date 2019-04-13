package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banca;
import model.Grupo;

public class BancaDAO {

	public void createBanca(Banca banca) {
		String sqlCreate = "INSERT INTO banca (grupo_id, data, sala) VALUES (?, ?, ?) ";

		Grupo grupo = new Grupo();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, grupo.getId());
			ps.setDate(2, (Date) banca.getData());
			ps.setString(3, banca.getSala());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void deleteBanca(Banca banca) {
		String sqlDelete = "DELETE FROM banca WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, banca.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void updateBanca(Banca banca) {
		String sqlUpdate = "UPDATE banca SET grupo_id=?, data=?, sala=? WHERE id=?";

		Grupo grupo = new Grupo();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setInt(1, grupo.getId());
			ps.setDate(2, (Date) banca.getData());
			ps.setString(3, banca.getSala());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Banca readBanca(int id) {
		String sqlRead = "SELECT grupo_id, data, sala FROM banca WHERE id =?";

		Banca banca = new Banca();
		Grupo grupo = new Grupo();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt("grupo_id"));
					banca.setData(rs.getDate("data"));
					banca.setSala(rs.getString("sala"));
				} else {
					banca.setId(-1);
					grupo.setId(-1);
					banca.setData(null);
					banca.setSala(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return banca;
	}

}
