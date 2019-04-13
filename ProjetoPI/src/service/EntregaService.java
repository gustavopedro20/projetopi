package service;

import dao.EntregaDAO;
import model.Entrega;

public class EntregaService {
	
	EntregaDAO dao;

	public EntregaService() {
		dao = new EntregaDAO();
	}

	public void create(Entrega entrega) {
		dao.createEntrega(entrega);
	}

	public void update(Entrega entrega) {
		dao.updateEntrega(entrega);
	}

	public void delete(Entrega entrega) {
		dao.deleteEntrega(entrega);
	}

	public Entrega read(int id) {
		Entrega entrega = dao.readEntrega(id);
		return entrega;
	}
}
