package service;

import java.util.ArrayList;

import dao.ProfessorDAO;
import model.Professor;
import model.Usuario;

public class ProfessorService {

	ProfessorDAO dao;

	public ProfessorService() {
		dao = new ProfessorDAO();
	}

//	public void criar(Professor professor, Usuario usuario) {
//		dao.criar(professor, usuario);
//	}

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
	
	
}
