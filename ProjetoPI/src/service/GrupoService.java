package service;


import java.util.ArrayList;

import dao.GrupoDAO;
import model.Grupo;

public class GrupoService {
	
	GrupoDAO dao = new GrupoDAO();

	/*public GrupoService() {
		dao = new GrupoDAO();
	}*/

	public int criar(Grupo grupo) {
		return dao.criar(grupo);
	}

	public void atualizar(Grupo grupo) {
		dao.atualizar(grupo);
	}

	public void deletar(int id) {
		dao.deletar(id);
	}

	public Grupo carregar(int id) {
		return dao.carregar(id);
	}
	public ArrayList<Grupo> listarGrupos(){
		return dao.listarGrupos();
	}
	
//	public ArrayList<Grupo> listarTurmas(){
//		return dao.listarTurmas();
//	}
	
	
}
