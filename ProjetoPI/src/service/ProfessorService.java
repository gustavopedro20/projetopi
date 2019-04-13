package service;

import dao.ProfessorDAO;
import model.Professor;
import model.Usuario;

public class ProfessorService {

	ProfessorDAO dao;

	public ProfessorService() {
		dao = new ProfessorDAO();
	}

	public void create(Professor professor) {
		dao.createProfessor(professor);
	}

	public void update(Professor professor) {
		dao.updateProfessor(professor);
	}

	public void delete(Professor professor) {
		dao.deleteProfessor(professor);
	}

	public Usuario read(int id) {
		Professor professor = dao.readProfessor(id);
		return professor;
	}
}
