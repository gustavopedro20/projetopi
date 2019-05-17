package service;

import java.util.ArrayList;

import dao.AtividadeDAO;
import model.Atividade;

public class AtividadeService {
	
	AtividadeDAO dao = new AtividadeDAO();;

	public void criar(Atividade atividade) {
		dao.criar(atividade);
	}

//	public void atualizarFormatoEntrega(String formato, int id) {
//		dao.atualizarFormatoEntrega(formato, id);
//	}

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
