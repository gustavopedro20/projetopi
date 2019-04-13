package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Tema;

public class TemaDAO {
	public void incluir(Tema t) {
		String sqlInsert = "INSERT INTO usuario (id, dtCadastro, titulo, introducao, requisitos) " + "VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			ps.setInt(1, t.getId());
			ps.setDate(2, (java.sql.Date) t.getDtCadastro());
			ps.setString(3, t.getTitulo());
			ps.setString(4, t.getIntoducao());
			ps.execute();
		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void excluir(Tema t) {
		String sqlDelete = "DELETE FROM professorBanca WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, t.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Tema t) {
		String sqlUpdate = "UPDATE pais SET nome=?, populacao=?, area=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDate(1, (java.sql.Date) t.getDtCadastro());
			stm.setString(2, t.getTitulo());
			stm.setString(3, t.getIntoducao());
			stm.setString(4, t.getRequisitos());
			stm.setInt(5, t.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Tema carregar(int id, Tema t) {
		String sqlSelect = "SELECT nome, email, senha FROM usuario WHERE id =?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					t.setDtCadastro(rs.getDate("dtCadastro"));
					t.setTitulo(rs.getString("tirulo"));
					t.setIntoducao(rs.getString("intoducao"));
					t.setRequisitos(rs.getString("requisitos"));
				} else {
					t.setId(-1);
					t.setDtCadastro(null);
					t.setTitulo(null);
					t.setIntoducao(null);
					t.setRequisitos(null);
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
