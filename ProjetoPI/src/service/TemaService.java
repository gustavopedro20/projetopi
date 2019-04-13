package service;

import dao.TemaDAO;
import model.Tema;

public class TemaService {
	TemaDAO dao;
	
	public TemaService() {
		dao = new TemaDAO();
	}
	
	public void incluir (Tema t) {
		dao.incluir(t);
	}
	
	public void atualizar (Tema t) {
		dao.atualizar(t);
	}
	
	public void excluir (Tema t) {
		dao.excluir(t);
	}
	
	public Tema carregar (int id, Tema t) {
		Tema use = dao.carregar(id, t);
		return use;
	}
}