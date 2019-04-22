package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Tema;

public class TemaDAO {

	public int salvar(Tema tema) {
		String sql = "INSERT INTO tema (dtCadastro, titulo, introducao, requisitos) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, tema.getId());
			ps.setDate(2, (java.sql.Date) tema.getDtCadastro());
			ps.setString(3, tema.getTitulo());
			ps.setString(4, tema.getIntoducao());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery); ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					tema.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tema.getId();
	}

	public void excluir(Tema tema) {
		String sql = "DELETE FROM tema WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, tema.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Tema tema) {
		String sql = "UPDATE tema SET dtCadastro=?, titulo=?, introducao=?, requisitos=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setDate(1, (java.sql.Date) tema.getDtCadastro());
			ps.setString(2, tema.getTitulo());
			ps.setString(3, tema.getIntoducao());
			ps.setString(4, tema.getRequisitos());
			ps.setInt(5, tema.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Tema carregar(int id) {
		String sql = "SELECT dtCadastro, titulo, introducao, requisitos FROM tema WHERE id =?";
		Tema tema = new Tema();
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					tema.setDtCadastro(rs.getDate("dtCadastro"));
					tema.setTitulo(rs.getString("tirulo"));
					tema.setIntoducao(rs.getString("intoducao"));
					tema.setRequisitos(rs.getString("requisitos"));
				} else {
					tema.setId(-1);
					tema.setDtCadastro(null);
					tema.setTitulo(null);
					tema.setIntoducao(null);
					tema.setRequisitos(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return tema;
	}
}
