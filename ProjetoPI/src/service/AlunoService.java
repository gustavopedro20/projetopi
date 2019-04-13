package service;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoService {

	AlunoDAO dao;

	public AlunoService() {
		dao = new AlunoDAO();
	}

	public void create(Aluno aluno) {
		dao.createUsuario(aluno);
	}

	public void update(Aluno aluno) {
		dao.updateAluno(aluno);
	}

	public void delete(Aluno aluno) {
		dao.deleteAluno(aluno);
	}

	public Aluno read(int id) {
		Aluno aluno = dao.readAluno(id);
		return aluno;
	}
}
