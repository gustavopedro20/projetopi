package service;

import dao.BancaDAO;
import model.Banca;

public class BancaService {
	
	BancaDAO dao;

	public BancaService() {
		dao = new BancaDAO();
	}

	public void create(Banca banca) {
		dao.createBanca(banca);
	}

	public void update(Banca banca) {
		dao.updateBanca(banca);
	}

	public void delete(Banca banca) {
		dao.deleteBanca(banca);
	}

	public Banca read(int id) {
		Banca banca = dao.readBanca(id);
		return banca;
	}

}
