package service;

import dao.ProfessorBancaDAO;
import model.ProfessorBanca;

public class ProfessorBancaService {
	ProfessorBancaDAO dao;

	public ProfessorBancaService() {
		dao = new ProfessorBancaDAO();
	}

	public void incluir(ProfessorBanca p) {
		dao.incluir(p);
	}

	public void atualizar(ProfessorBanca p) {
		dao.atualizar(p);
	}

	public void excluir(ProfessorBanca p) {
		dao.excluir(p);
	}

	public ProfessorBanca carregar(int id, ProfessorBanca p) {
		ProfessorBanca use = dao.carregar(id, p);
		return use;
	}
}
