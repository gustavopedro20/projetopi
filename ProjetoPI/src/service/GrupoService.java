package service;


import dao.GrupoDAO;
import model.Grupo;

public class GrupoService {
	
	GrupoDAO dao;

	public GrupoService() {
		dao = new GrupoDAO();
	}

	public void incluir(Grupo grupo) {
		dao.salvar(grupo);
	}

	public void atualizar(Grupo g) {
		dao.deletar(g);
	}

	public void excluir(Grupo g) {
		dao.atualizar(g);
	}

	public Grupo carregar(int id) {
		Grupo grupo = dao.carregar(id);
		return grupo;
	}
	
	public Grupo readList(Grupo g) {
		Grupo grupo = (Grupo) dao.carregarList(g);
		return grupo;
	}
}
