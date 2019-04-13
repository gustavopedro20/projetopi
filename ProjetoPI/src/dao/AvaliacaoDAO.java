package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Avaliacao;
import model.Entrega;

public class AvaliacaoDAO {

	public void createAvaliacao(Avaliacao avaliacao) {
		String sqlCreate = "INSERT INTO avaliacao (entrega_id, aluno_id, nota, dt_avaliacao, comentarios) "
				+ "VALUES (?, ?, ?, ?, ?) ";

		Aluno aluno = new Aluno();
		Entrega entrega = new Entrega();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, entrega.getId());
			ps.setInt(2, aluno.getId());
			ps.setDouble(3, avaliacao.getNota());
			ps.setDate(4, (Date) avaliacao.getDtAvaliacao());
			ps.setString(5, avaliacao.getComentarios());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void deleteAvaliacao(Avaliacao avaliacao) {
		String sqlDelete = "DELETE FROM avaliacao WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, avaliacao.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void updateAvaliacao(Avaliacao avaliacao) {
		String sqlUpdate = "UPDATE avaliacao SET entrega_id=?, aluno_id=?, nota=?, dt_avaliacao=?, comentarios=? WHERE id=?";

		Aluno aluno = new Aluno();
		Entrega entrega = new Entrega();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setInt(1, entrega.getId());
			ps.setInt(2, aluno.getId());
			ps.setDouble(3, avaliacao.getNota());
			ps.setDate(4, (Date) avaliacao.getDtAvaliacao());
			ps.setString(5, avaliacao.getComentarios());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Avaliacao readAvaliacao(int id) {
		String sqlRead = "SELECT entrega_id, aluno_id, nota, dt_avaliacao, comentarios FROM avaliacao WHERE id =?";

		Avaliacao avaliacao = new Avaliacao();
		Aluno aluno = new Aluno();
		Entrega entrega = new Entrega();

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					entrega.setId(rs.getInt("entrega_id"));
					aluno.setId(rs.getInt("aluno_id"));
					avaliacao.setNota(rs.getDouble("nota"));
					avaliacao.setDtAvaliacao(rs.getDate("dt_avaliacao"));
					avaliacao.setComentarios(rs.getString("comentarios"));

				} else {
					entrega.setId(-1);
					aluno.setId(-1);
					avaliacao.setNota(0);
					avaliacao.setDtAvaliacao(null);
					avaliacao.setComentarios(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return avaliacao;
	}
}
