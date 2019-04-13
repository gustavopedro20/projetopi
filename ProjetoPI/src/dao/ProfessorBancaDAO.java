package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banca;
import model.Professor;
import model.ProfessorBanca;

public class ProfessorBancaDAO {

	public void incluir(ProfessorBanca p) {
		String sqlInsert = "INSERT INTO usuario (id, avaliacao, banca_id, professor_id) " + "VALUES (?, ?, ?, ?)";
		
		Professor professor = new Professor();
		Banca banca = new Banca();
		
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			ps.setInt(1, p.getId());
			ps.setDouble(2, p.getAvaliacao());
			ps.setInt(3, banca.getId());
			ps.setInt(4, professor.getId());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void excluir(ProfessorBanca p) {
		String sqlDelete = "DELETE FROM professorBanca WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, p.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(ProfessorBanca p) {
		String sqlUpdate = "UPDATE pais SET nome=?, avaliacao=?, professor_id=?, banca_id WHERE id=?";
		
		Professor professor = new Professor();
		Banca banca = new Banca();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDouble(1, p.getAvaliacao());
			stm.setInt(2, banca.getId());
			stm.setInt(3, professor.getId());
			stm.setInt(4, p.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public ProfessorBanca carregar(int id, ProfessorBanca p) {
		String sqlSelect = "SELECT professorbanca_id, avaliacao, banca_id, professor_id FROM usuario WHERE id =?";
		
		Professor professor = new Professor();
		Banca banca = new Banca();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					p.setId(rs.getInt("professorbanca_id"));
					banca.setId(rs.getInt("banca_id"));
					professor.setId(rs.getInt("professor_id"));
				} else {
					p.setId(-1);
					p.setAvaliacao(-1);
					banca.setId(-1);
					professor.setId(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return p;
	}
}
