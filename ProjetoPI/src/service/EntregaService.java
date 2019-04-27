package service;

import dao.EntregaDAO;
import model.Entrega;

public class EntregaService {
	
	EntregaDAO dao;

	public EntregaService() {
		dao = new EntregaDAO();
	}

	public void criar(Entrega entrega) {
		dao.criar(entrega);
	}

	public void atualizar(Entrega entrega) {
		dao.atualizar(entrega);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Entrega carregar(int id) {
		Entrega entrega = dao.carregar(id);
		return entrega;
	}
}
