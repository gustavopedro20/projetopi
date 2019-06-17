package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Grupo;
import model.Turma;
import model.TurmaAluno;

public class TurmaAlunoDAO {
	
	public void atualizarTurmaAluno(int idGrupo, int idAluno) {
		String sql = "UPDATE turma_aluno SET grupo_id=? WHERE Aluno_id=?";
		try (Connection conn = ConnectionFactory.conectar();
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, idGrupo);
			ps.setInt(2, idAluno);
			ps.execute();
		} catch (Exception e) {
			System.out.println("Erro em atualizarTurmaAluno: "+e.getMessage());
		}
	}

	public TurmaAluno carregarAlunoTurmaGrupo(int id) {
		String sql = "SELECT * FROM turma_aluno WHERE Aluno_id=?";
		TurmaAluno turmaAluno = new TurmaAluno();
		Turma turma = new Turma();
		Grupo grupo = new Grupo();
		Aluno aluno = new Aluno();
		aluno.setId(id);
		try (Connection conn = ConnectionFactory.conectar(); 
				PreparedStatement ps = conn.prepareStatement(sql);) {
			ps.setInt(1, aluno.getId());
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					turma.setId(rs.getInt("turma_id"));
					aluno.setId(rs.getInt("Aluno_id"));
					grupo.setId(rs.getInt("grupo_id"));
					turmaAluno.setId(rs.getInt("id"));
					turmaAluno.setTurma(turma);
					turmaAluno.setAluno(aluno);
					turmaAluno.setGrupo(grupo);
				} else {
					turmaAluno.setId(-1);
					turmaAluno.setAluno(null);
					turmaAluno.setGrupo(null);
					turmaAluno.setGrupo(null);
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
