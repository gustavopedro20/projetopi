package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Grupo;
import model.Professor;

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
		
		String sql_entrega_grupo = "DELETE FROM entrega WHERE grupo_id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql_entrega_grupo);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		String sql_banca_grupo = "UPDATE turma_aluno SET grupo_id = null WHERE grupo_id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql_banca_grupo);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		String sql_delete_grupo = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql_delete_grupo);) {
			ps.setInt(1, id);
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		
		
//		String sql = "DELETE FROM grupo WHERE id = ?";
//		try (Connection conn = ConnectionFactory.conectar();
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setInt(1, id);
//			ps.execute();
//		} catch (Exception e) {
//			System.out.println(e.getStackTrace());
//		}
	}

	public void atualizar(Grupo grupo) {
		String sql = "UPDATE grupo SET orientador_id=?, numero=?, nome=? WHERE id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getProf().getId());
			ps.setInt(1, grupo.getNum());
			ps.setString(2, grupo.getNome());
			ps.setInt(4, grupo.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Grupo carregar(int id) {
		String sql = "SELECT u.id, u.nome, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id INNER JOIN grupo AS g ON p.professor_id = g.orientador_id WHERE g.id=?";
	
		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		grupo.setId(id);		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, grupo.getId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setProf(prof);
					grupo.setNome(rs.getString("g.nome"));
					grupo.setNum(rs.getInt("g.numero"));
				} else {
					grupo.setProf(null);
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
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();

		/*String sql = "SELECT "
				+ "g.id, "
				+ "u.nome, "
				+ "g.nome, "
				+ "g.numero "
				+ "FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id";*/
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id INNER JOIN grupo AS g ON p.professor_id = g.orientador_id";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
			try (ResultSet rs = ps.executeQuery();) {
				
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setId(rs.getInt("g.id"));
					grupo.setProf(prof);					
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
		Professor prof;
		ArrayList<Grupo> lista = new ArrayList<>();
		//String sqlSelect = "SELECT id, nome, numero FROM grupo where upper(nome) like ?";
		/*String sql = "SELECT "
				+ "g.id, "
				+ "u.nome, "
				+ "g.nome, "
				+ "g.numero "
				+ "FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "INNER JOIN grupo AS g ON p.professor_id = g.orientador_id "
				+ "WHERE UPPER (g.nome) like";*/
		String sql = "SELECT u.id, u.nome, g.id, g.nome, g.numero FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id INNER JOIN grupo AS g ON p.professor_id = g.orientador_id WHERE UPPER (g.nome) LIKE";

		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = ps.executeQuery();) {
				while (rs.next()) {
					grupo = new Grupo();
					prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					grupo.setProf(prof);
					grupo.setId(rs.getInt("g.id"));
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
