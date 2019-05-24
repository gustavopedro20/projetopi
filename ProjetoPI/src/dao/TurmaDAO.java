package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Turma;

public class TurmaDAO {

	public int criar(Turma turma) {
		String sql = "INSERT INTO semestre_letivo, ano_letivo, sigla, tema_id VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {

			ps.setInt(1, turma.getSemestreLetivo());
			ps.setInt(2, turma.getAnoLetivo());
			ps.setString(3, turma.getSigla());
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

	public void deletar(int id) {
		String sql = "DELETE FROM usuario WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, id);
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
		String sqlSelect = "SELECT semestre_letivo, ano_letivo, sigla FROM turma WHERE id=?";
		Turma turma = new Turma();
		turma.setId(id);
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, turma.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					turma.setSemestreLetivo(rs.getInt("semestre_letivo"));
					turma.setAnoLetivo(rs.getInt("ano_letivo"));
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
	
	public ArrayList<Turma> listarTurmas() {
		String sql="SELECT * FROM turma";
		Turma turma;
		ArrayList<Turma> lista = new ArrayList<>();
	
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {	
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					turma = new Turma();
					turma.setId(rs.getInt("id"));
					turma.setSigla(rs.getString("sigla"));
					lista.add(turma);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
}
