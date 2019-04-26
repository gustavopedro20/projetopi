package service;


import java.util.ArrayList;

import dao.GrupoDAO;
import model.Grupo;

public class GrupoService {
	
	GrupoDAO dao;

	public GrupoService() {
		dao = new GrupoDAO();
	}

	public void criar(Grupo grupo) {
		dao.criar(grupo);
	}

	public void atualizar(Grupo g) {
		dao.atualizar(g);
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
	
	public ArrayList<Grupo> listarGrupos(String chave){
		return dao.listarGrupos(chave);
	}
	
	
}
