package br.com.usjt.ProjetoPI.service;

import br.com.usjt.ProjetoPI.model.Entrega;
import br.com.usjt.ProjetoPI.persistencia.EntregaDAO;

public class EntregaService {
	
	EntregaDAO dao = new EntregaDAO();

	public void criar(Entrega entrega) {
		dao.criar(entrega);
	}
	
}
