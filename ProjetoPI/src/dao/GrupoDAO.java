package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Grupo;
import model.Professor;

public class GrupoDAO {
	
	public int salvar(Grupo grupo) {
		String sql = "INSERT INTO grupo (numero, nome) VALUES (?, ?)";
		//String sqlInsert = "INSERT INTO grupo (orientador_id, numero, nome) VALUES ()";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getNum());
			ps.setString(2, grupo.getNome());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return grupo.getId();
	}

	public void deletar(Grupo grupo) {
		String sql = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sql);) {
			stm.setInt(1, grupo.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Grupo grupo) {
		//String sqlUpdate = "UPDATE grupo SET numero=?, nome=? WHERE id=?";
		String sql = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";

		Professor professor = new Professor();

		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, professor.getId());
			ps.setInt(1, grupo.getNum());
			ps.setString(2, grupo.getNome());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Grupo carregar(int id) {
		String sql = "SELECT numero, nome FROM grupo WHERE id =?";
		//String sqlSelect = "SELECT orientador_id, numero, nome FROM grupo WHERE id =?";
		
		Grupo grupo = new Grupo();
		grupo.setId(id);
		//Professor professor = new Professor();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					//professor.setId(rs.getInt("professor_id"));
					grupo.setNum(rs.getInt("numero"));
					grupo.setNome(rs.getString("nome"));
				} else {
					//professor.setId(-1);
					grupo.setNum(-1);
					grupo.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return grupo;
	}
	
	public List<Grupo> carregarList(Grupo grupo) {
		String sql = "SELECT * FROM grupo";
		List<Grupo> g = new ArrayList<>();

		Professor professor = new Professor();
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					professor.setId(rs.getInt("professor_id"));
					grupo.setNum(rs.getInt("numero"));
					grupo.setNome(rs.getString("nome"));
					g.add(grupo);
				} else {
					professor.setId(-1);
					grupo.setNum(-1);
					grupo.setNome(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return g;
	}
}
