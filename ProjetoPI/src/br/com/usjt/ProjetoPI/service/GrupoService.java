package service;


import java.util.ArrayList;

import dao.GrupoDAO;
import model.Grupo;
import model.Turma;

public class GrupoService {
	
	GrupoDAO dao = new GrupoDAO();
	
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
	
	public ArrayList<Grupo> listarGrupos(String chave){
		return dao.listarGrupos(chave);
	}
	
	public ArrayList<Grupo> listarGrupos(int turma){
		return dao.listarGrupos(turma);
	}
	
	public ArrayList<Grupo> listarGruposPorTurma(Turma turma){
		return dao.listarGruposPorTurma(turma);
	}
	
}
