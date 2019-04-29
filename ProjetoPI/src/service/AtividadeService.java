package service;

import dao.AtividadeDAO;
import model.Atividade;

public class AtividadeService {
	
	AtividadeDAO dao;

	public AtividadeService() {
		dao = new AtividadeDAO();
	}

	public void criar(Atividade atividade) {
		dao.criar(atividade);
	}

	public void atualizar(Atividade atividade) {
		dao.atualizar(atividade);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Atividade carregar(int id) {
		Atividade atividade = dao.carregar(id);
		return atividade;
	}

}
