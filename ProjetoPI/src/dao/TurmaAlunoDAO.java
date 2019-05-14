package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.TurmaAluno;

public class TurmaAlunoDAO {
	
	/*public void criar(Grupo grupo, Aluno aluno, Turma turma) {
		String sqlInsert = "INSERT INTO turma_aluno (aluno_id, turma_id, grupo_id) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
			ps.setInt(1, aluno.getId());
			ps.setInt(2, turma.getId());
			ps.setInt(3, grupo.getId());
			ps.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); 
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					grupo.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(TurmaAluno turmaAluno) {
		String sqlDelete = "DELETE FROM grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, turmaAluno.getId());
			stm.execute();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}*/

	public TurmaAluno carregarAlunoTurmaGrupo(int id) {
		String sql = "SELECT * FROM turma_aluno WHERE Aluno_id=?";
		TurmaAluno turmaAluno = new TurmaAluno();
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					turmaAluno.setId(rs.getInt("id"));
					turmaAluno.getAluno().setId(rs.getInt("Aluno_id"));
					turmaAluno.getGrupo().setId(rs.getInt("grupo_id"));
					turmaAluno.getTurma().setId(rs.getInt("turma_id"));
				} else {
					turmaAluno.setId(-1);
					turmaAluno.getAluno().setId(-1);
					turmaAluno.getGrupo().setId(-1);
					turmaAluno.getTurma().setId(-1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return turmaAluno;
	}
}
