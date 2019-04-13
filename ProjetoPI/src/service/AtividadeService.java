package service;

import dao.AtividadeDAO;
import model.Atividade;

public class AtividadeService {
	
	AtividadeDAO dao;

	public AtividadeService() {
		dao = new AtividadeDAO();
	}

	public void create(Atividade atividade) {
		dao.createAtividade(atividade);
	}

	public void update(Atividade atividade) {
		dao.updateAtividade(atividade);
	}

	public void delete(Atividade atividade) {
		dao.deleteAtividade(atividade);
	}

	public Atividade read(int id) {
		Atividade atividade = dao.readAtividade(id);
		return atividade;
	}

}
