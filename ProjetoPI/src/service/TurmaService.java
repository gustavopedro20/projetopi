package service;

import dao.TurmaDAO;
import model.Turma;


public class TurmaService {
	TurmaDAO dao;

	public TurmaService() {
		dao = new TurmaDAO();
	}

	public void incluir(Turma t) {
		dao.salvar(t);
	}

	public void atualizar(Turma t) {
		dao.atualizar(t);
	}

	public void excluir(Turma t) {
		dao.excluir(t);
	}

	public Turma carregar(int id, Turma t) {
		Turma turma = dao.carregar(id);
		return turma;
	}
}
