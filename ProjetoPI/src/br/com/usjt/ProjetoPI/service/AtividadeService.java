package br.com.usjt.ProjetoPI.service;

import java.util.ArrayList;

import br.com.usjt.ProjetoPI.model.Atividade;
import br.com.usjt.ProjetoPI.persistencia.AtividadeDAO;

public class AtividadeService {
	
	AtividadeDAO dao = new AtividadeDAO();;

	public void criar(Atividade atividade) {
		dao.criar(atividade);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Atividade carregar(int id) {
		return dao.carregar(id);		
	}
	
	public ArrayList<Atividade> listarAtividadesPorAluno(int id){
		return dao.listarAtividadesPorAluno(id);
	}

	public ArrayList<Atividade> listarAtividades(){
		return dao.listarAtividades();
	}
	
}
