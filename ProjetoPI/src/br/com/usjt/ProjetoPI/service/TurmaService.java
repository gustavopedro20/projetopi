package br.com.usjt.ProjetoPI.service;

import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Turma;
import br.com.usjt.ProjetoPI.persistencia.TurmaDAO;

public class TurmaService {
	
	TurmaDAO dao = new TurmaDAO();

	public void criar(Turma t) {
		dao.criar(t);
	}

	public void atualizar(Turma turma) {
		dao.atualizar(turma);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Turma carregar(int id) {
		return dao.carregar(id);
	}
	
	public ArrayList<Turma> listarTurmas(){
		return dao.listarTurmas();
	}
	
}
