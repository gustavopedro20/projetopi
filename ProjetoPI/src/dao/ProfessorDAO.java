package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;

public class ProfessorDAO {
	
//	public Usuario criarUsuario (Professor professor) {
//		return professor;	
//	}
//	
	public Professor carregar(int id) {
		String sql = "SELECT u.id, u.nome, u.email, u.senha, p.administrador, p.matricula FROM usuario AS u "
				+ "INNER JOIN professor AS p ON u.id = p.professor_id WHERE u.id=?";
		Professor prof = new Professor();
		prof.setId(id);
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, prof.getId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					prof.setEmail(rs.getString("u.email"));
					prof.setSenha(rs.getString("u.senha"));
					prof.setAdm(rs.getInt("p.administrador"));
					prof.setMatricula(rs.getString("p.matricula"));
				} else {
					prof.setId(-1);
					prof.setNome(null);
					prof.setEmail(null);
					prof.setSenha(null);
					prof.setAdm(-1);
					prof.setMatricula(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return prof;
	}
//	public int criar(Professor professor, Usuario usuario) {
//		String sql = "INSERT INTO professor (professor_id, matricula) VALUES (?, ?) ";
//		UsuarioDAO dao = new UsuarioDAO(usuario);
//		
//		try (Connection conn = ConnectionFactory.conectar();
//				PreparedStatement ps = conn.prepareStatement(sql);) {
//			ps.setString(1, professor.getMatricula());
//			ps.execute();
//			String sqlQuery = "SELECT LAST_INSERT_ID()";
//			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery);
//					ResultSet rs = ps2.executeQuery();) {
//				if (rs.next()) {
//					professor.setId(rs.getInt(1));
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return usuario.getId();
//	}
	
	public void deletar(Professor professor) {
		String sqlDelete = "DELETE FROM professor WHERE professor_id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, professor.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void atualizar(Professor professor) {
		String sqlUpdate = "UPDATE professor SET nome=?, email=?, senha=? WHERE professor_id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlUpdate);) {
			ps.setString(1, professor.getNome());
			ps.setNString(2, professor.getEmail());
			ps.setString(3, professor.getSenha());
			ps.setInt(4, professor.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public Professor autenticarProfessor(Professor prof) {
		String sql = "SELECT u.id, u.nome, u.email, u.senha, p.administrador, p.matricula FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "WHERE u.email=? AND u.senha=? AND p.administrador=0";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, prof.getEmail());
			ps.setString(2, prof.getSenha());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					prof.setEmail(rs.getString("u.email"));
					prof.setSenha(rs.getString("u.senha"));
					prof.setAdm(rs.getInt("p.administrador"));
					prof.setMatricula(rs.getString("p.matricula"));
				} else {
					prof.setId(-1);
					prof.setNome(null);
					prof.setEmail(null);
					prof.setSenha(null);
					prof.setAdm(-1);
					prof.setMatricula(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return prof;
	}
	
	public Professor autenticarAdm(Professor prof) {
		String sql = "SELECT u.id, u.nome, u.email, u.senha, p.administrador, p.matricula FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id "
				+ "WHERE u.email=? AND u.senha=? AND p.administrador=1";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, prof.getEmail());
			ps.setString(2, prof.getSenha());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					prof.setEmail(rs.getString("u.email"));
					prof.setSenha(rs.getString("u.senha"));
					prof.setAdm(rs.getInt("p.administrador"));
					prof.setMatricula(rs.getString("p.matricula"));
				} else {
					prof.setId(-1);
					prof.setNome(null);
					prof.setEmail(null);
					prof.setSenha(null);
					prof.setAdm(-1);
					prof.setMatricula(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return prof;
	}
	public ArrayList<Professor> listarProfessores() {
	
		ArrayList<Professor> lista = new ArrayList<>();

		String sql = "SELECT u.id, u.nome FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id";
		
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			
			try (ResultSet rs = ps.executeQuery();) {
				
				while (rs.next()) {	
					Professor prof = new Professor();
					prof.setId(rs.getInt("u.id"));
					prof.setNome(rs.getString("u.nome"));
					lista.add(prof);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		
		return lista;
	}
	
	public boolean verificarMatricula(String matricula) {
		String sql = "SELECT * FROM professor WHERE matricula=?";
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setString(1, matricula);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.getMessage();
			}
		} catch (SQLException e1) {
			e1.getMessage();
		}
		return false;
	}
	
}













