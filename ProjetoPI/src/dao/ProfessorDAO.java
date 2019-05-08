package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Professor;
import model.Usuario;

public class ProfessorDAO {
	
	public Usuario criarUsuario (Professor professor) {
		return professor;	
	}
	
	public int criar(Professor professor) {
		String sql = "INSERT INTO professor (professor_id, matricula) VALUES (?, ?) ";
		Usuario usuario = criarUsuario(professor);
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, usuario.getId());
			ps.setString(2, professor.getMatricula());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement ps2 = conn.prepareStatement(sqlQuery);
					ResultSet rs = ps2.executeQuery();) {
				if (rs.next()) {
					professor.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professor.getId();
	}
	
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
	
	public Professor carregar(int id) {
		String sql = "SELECT u.id, u.nome, u.email, u.senha, p.administrador, p.matricula FROM usuario AS u INNER JOIN professor AS p ON u.id = p.professor_id WHERE u.id=?";
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
	
}













