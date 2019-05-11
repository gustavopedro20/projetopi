package service;

import java.util.ArrayList;

import dao.AlunoDAO;
import model.Aluno;

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
	
	public void deletarAlunoGrupo(int idGrupo, int idAluno) {
		dao.deletarAlunoGrupo(idGrupo, idAluno);
	}	

}
