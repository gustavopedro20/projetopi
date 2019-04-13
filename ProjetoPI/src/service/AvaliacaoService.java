package service;

import dao.AvaliacaoDAO;
import model.Avaliacao;

public class AvaliacaoService {

	AvaliacaoDAO dao;

	public AvaliacaoService() {
		dao = new AvaliacaoDAO();
	}

	public void create(Avaliacao avaliacao) {
		dao.createAvaliacao(avaliacao);
	}

	public void update(Avaliacao avaliacao) {
		dao.updateAvaliacao(avaliacao);
	}

	public void delete(Avaliacao avaliacao) {
		dao.deleteAvaliacao(avaliacao);
	}

	public Avaliacao read(int id) {
		Avaliacao avaliacao = dao.readAvaliacao(id);
		return avaliacao;
	}
}
