package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Usuario;

public class AlunoDAO {

	public Usuario createUsuario(Aluno aluno) {
		return aluno;
	}

	public void createAluno(Aluno aluno) {
		String sqlCreate = "INSERT INTO aluno (aluno_id, ra) VALUES (?, ?) ";

		Usuario usuario = createUsuario(aluno);

		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement ps = conn.prepareStatement(sqlCreate)) {
			ps.setInt(1, usuario.getId());
			ps.setString(2, aluno.getRa());
			ps.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getStackTrace());

		}
	}

	public void deleteAluno(Aluno aluno) {
		String sqlDelete = "DELETE FROM aluno WHERE aluno_id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, aluno.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void updateAluno(Aluno aluno) {
		String sqlUpdate = "UPDATE aluno SET nome=?, email=?, senha=? WHERE aluno_id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, aluno.getNome());
			stm.setNString(2, aluno.getEmail());
			stm.setString(3, aluno.getSenha());
			stm.setInt(4, aluno.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public Aluno readAluno(int id) {
		String sqlRead = "SELECT nome, email, senha FROM aluno WHERE aluno_id =?";
		Aluno aluno = new Aluno();
		try (Connection conn = ConnectionFactory.conectar(); PreparedStatement stm = conn.prepareStatement(sqlRead);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					aluno.setNome(rs.getString("nome"));
					aluno.setEmail(rs.getString("email"));
					aluno.setSenha(rs.getString("senha"));
				} else {
					aluno.setId(-1);
					aluno.setNome(null);
					aluno.setEmail(null);
					aluno.setSenha(null);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return aluno;
	}
}
