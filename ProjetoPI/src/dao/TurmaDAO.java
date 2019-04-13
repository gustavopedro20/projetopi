package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Turma;

public class TurmaDAO {
	public void incluir(Turma t) {
		String sqlInsert = "INSERT INTO usuario (id, semestreLetivo, anoLetivo, sigla) " + "VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			ps.setInt(1, t.getId());
			ps.setInt(2, t.getSemestreLetivo());
			ps.setInt(3, t.getAnoLetivo());
			ps.setString(4, t.getSigla());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void excluir(Turma t) {
		String sqlDelete = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, t.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Turma t) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, t.getSemestreLetivo());
			stm.setInt(2, t.getAnoLetivo());
			stm.setString(3, t.getSigla());
			stm.setInt(4, t.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Turma carregar(int id, Turma t) {
		String sqlSelect = "SELECT semestreLetivo, anoLetivo, sigla FROM usuario WHERE id =?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					t.setSemestreLetivo(rs.getInt("semestreLetivo"));
					t.setAnoLetivo(rs.getInt("anoLetivo"));
					t.setSigla(rs.getString("sigla"));
				} else {
					t.setId(-1);
					t.setSemestreLetivo(-1);
					t.setAnoLetivo(-1);
					t.setSigla(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return t;
	}
}
