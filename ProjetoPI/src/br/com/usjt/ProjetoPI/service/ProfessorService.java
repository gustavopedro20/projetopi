package br.com.usjt.ProjetoPI.service;

import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.model.Usuario;
import br.com.usjt.ProjetoPI.persistencia.ProfessorDAO;

public class ProfessorService {

	ProfessorDAO dao = new ProfessorDAO();

	public void atualizar(Professor professor) {
		dao.atualizar(professor);
	}

	public void deletar(Professor professor) {
		dao.deletar(professor);
	}
	
	public Usuario carregar(int id) {
		return dao.carregar(id);
	}
	
	public Usuario autenticarProfessor(Professor prof) {
		return dao.autenticarProfessor(prof);
	}
	
	public Usuario autenticarAdm(Professor prof) {
		return dao.autenticarAdm(prof);
	}
	
	public ArrayList<Professor> listarProfessores(){
		return dao.listarProfessores();
	}
	
	public boolean verificarMatricula(String matricula) {
		return dao.verificarMatricula(matricula);
	}
	
}
