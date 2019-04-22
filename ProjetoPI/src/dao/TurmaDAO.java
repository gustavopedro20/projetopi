package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Turma;

public class TurmaDAO {

	public int salvar(Turma turma) {
		String sql = "INSERT INTO usuario (id, semestreLetivo, anoLetivo, sigla) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, turma.getId());
			ps.setInt(2, turma.getSemestreLetivo());
			ps.setInt(3, turma.getAnoLetivo());
			ps.setString(4, turma.getSigla());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery); ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					turma.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turma.getId();
	}

	public void excluir(Turma t) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, t.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Turma turma) {
		String sql = "UPDATE usuario SET semestreLetivo=?, anoLetivo=?, sigla=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, turma.getSemestreLetivo());
			stm.setInt(2, turma.getAnoLetivo());
			stm.setString(3, turma.getSigla());
			stm.setInt(4, turma.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Turma carregar(int id) {
		String sqlSelect = "SELECT semestreLetivo, anoLetivo, sigla FROM usuario WHERE id =?";
		Turma turma = new Turma();
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					turma.setSemestreLetivo(rs.getInt("semestreLetivo"));
					turma.setAnoLetivo(rs.getInt("anoLetivo"));
					turma.setSigla(rs.getString("sigla"));
				} else {
					turma.setId(-1);
					turma.setSemestreLetivo(-1);
					turma.setAnoLetivo(-1);
					turma.setSigla(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return turma;
	}
}
