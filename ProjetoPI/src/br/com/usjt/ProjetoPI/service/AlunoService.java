package br.com.usjt.ProjetoPI.service;

import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Aluno;
import br.com.usjt.ProjetoPI.persistencia.AlunoDAO;

public class AlunoService {

	AlunoDAO dao = new AlunoDAO();

	public Aluno carregar(int id) {
		return dao.carregar(id);	
	}
	
	public Aluno autenticarAluno(Aluno aluno) {
		return dao.autenticarAluno(aluno);	
	}
	
	public ArrayList<Aluno> listarAlunosPorTurma(int id){
		return dao.listarAlunosPorTurma(id);
	}
	
	public ArrayList<Aluno> listarAlunos(){
		return dao.listarAlunos();
	}
	
	public ArrayList<Aluno> listarAlunosPorGrupo(int id){
		return dao.listarAlunosPorGrupo(id);
	}
	
	public ArrayList<Aluno> listarAlunosPorTurmaSemGrupo(int id){
		return dao.listarAlunosPorTurmaSemGrupo(id);
	}

	public void deletarAlunoGrupo(int idGrupo, int idAluno) {
		dao.deletarAlunoGrupo(idGrupo, idAluno);
	}	
	
	public boolean verificarRa(String ra) {
		return dao.verificarRa(ra);
	}

}
