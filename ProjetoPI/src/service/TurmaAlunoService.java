package service;

import dao.TurmaAlunoDAO;
import model.TurmaAluno;

public class TurmaAlunoService {
	
	TurmaAlunoDAO dao = new TurmaAlunoDAO();
	
	public TurmaAluno carregarAlunoTurmaGrupo(int id) {
		return dao.carregarAlunoTurmaGrupo(id);	
	}

}
