package service;

import java.util.ArrayList;

import dao.AtividadeDAO;
import model.Atividade;

public class AtividadeService {
	
	AtividadeDAO dao = new AtividadeDAO();;

	public void criar(Atividade atividade) {
		dao.criar(atividade);
	}

	public void atualizar(Atividade atividade) {
		dao.atualizar(atividade);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Atividade carregar(int id) {
		return dao.carregar(id);		
	}
	
	public ArrayList<Atividade> listarAtividades (){
		return dao.listarAtividades();
	}

}
