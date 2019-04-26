package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Grupo;

public class GrupoDAO {
	
    Connection conn;

    public GrupoDAO(Connection conn) {
        this.conn = conn;
    }
    public GrupoDAO() {
    	
    }
	
	public int criar(Grupo grupo) {
		String sql = "INSERT INTO grupo (orientador_id, numero, nome) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getProf().getId());
			ps.setInt(2, grupo.getNum());
			ps.setString(3, grupo.getNome());
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

	public void deletar(int id) {
		String sql = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void atualizar(Grupo grupo) {
		String sql = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getProf().getId());
			ps.setInt(1, grupo.getNum());
			ps.setString(2, grupo.getNome());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Grupo carregar(int id) {
		String sql = "SELECT orientador_id, numero, nome FROM grupo WHERE id =?";	
		Grupo grupo = new Grupo();
		grupo.setId(id);		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					grupo.getProf().setId(rs.getInt("professor_id"));
					grupo.setNum(rs.getInt("numero"));
					grupo.setNome(rs.getString("nome"));
				} else {
					grupo.getProf().setId(-1);
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
	
	public ArrayList<Grupo> listarGrupos() {
		
		Grupo grupo;
		ArrayList<Grupo> lista = new ArrayList<>();

		String sql = "SELECT "
				+ "g.id, "
				+ "u.id, "
				+ "g.nome, "
				+ "g.numero "
				+ "FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
			try (ResultSet rs = ps.executeQuery();) {
				
				while (rs.next()) {
					grupo = new Grupo();
					grupo.setId(rs.getInt("g.id"));
					grupo.getProf().setId(rs.getInt("u.id"));
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
					lista.add(grupo);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return lista;
	}
	
	public ArrayList<Grupo> listarGrupos(String chave) {
		Grupo grupo;
		ArrayList<Grupo> lista = new ArrayList<>();
		//String sqlSelect = "SELECT id, nome, numero FROM grupo where upper(nome) like ?";
		String sql = "SELECT "
				+ "g.id, "
				+ "u.id, "
				+ "g.nome, "
				+ "g.numero "
				+ "FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id "
				+ "WHERE UPPER (g.nome) like";

		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					grupo.setId(rs.getInt("id"));
					grupo.getProf().setId(rs.getInt("u.id"));
					grupo.setNome(rs.getString("nome"));
					grupo.setNum(rs.getInt("numero"));
					lista.add(grupo);
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
