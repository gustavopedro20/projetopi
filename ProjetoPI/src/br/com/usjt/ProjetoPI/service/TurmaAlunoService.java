package br.com.usjt.ProjetoPI.service;

import br.com.usjt.ProjetoPI.model.TurmaAluno;
import br.com.usjt.ProjetoPI.persistencia.TurmaAlunoDAO;

public class TurmaAlunoService {
	
	TurmaAlunoDAO dao = new TurmaAlunoDAO();
	
	public TurmaAluno carregarAlunoTurmaGrupo(int id) {
		return dao.carregarAlunoTurmaGrupo(id);	
	}
	
	public void atualizarTurmaAluno(int idGrupo, int idAluno) {
		dao.atualizarTurmaAluno(idGrupo, idAluno);
	}

}
