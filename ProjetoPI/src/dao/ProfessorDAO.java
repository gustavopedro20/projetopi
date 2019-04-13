package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Professor;
import model.Usuario;

public class ProfessorDAO {
	
	public Usuario createUsuario (Professor professor) {
		return professor;	
	}
	
	public void createProfessor(Professor professor) {
		String sql = "INSERT INTO professor (professor_id, matricula) VALUES (?, ?) ";
				
		Usuario usuario = createUsuario(professor);
		
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, usuario.getId());
			ps.setString(2, professor.getMatr());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}
	
	public void deleteProfessor(Professor professor) {
		String sqlDelete = "DELETE FROM professor WHERE professor_id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlDelete);) {
			ps.setInt(1, professor.getId());
			ps.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}
	
	public void updateProfessor(Professor professor) {
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
	
	public Professor readProfessor(int id) {
		String sqlRead = "SELECT nome, email, senha FROM professor WHERE professor_id =?";
		Professor professor = new Professor();
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sqlRead);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					professor.setNome(rs.getString("nome"));
					professor.setEmail(rs.getString("email"));
					professor.setSenha(rs.getString("senha"));
				} else {
					professor.setId(-1);
					professor.setNome(null);
					professor.setEmail(null);
					professor.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return professor;
	}

}
