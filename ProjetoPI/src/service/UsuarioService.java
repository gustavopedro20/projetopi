package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO dao;

	public UsuarioService() {
		dao = new UsuarioDAO();
	}

	public void create(Usuario usuario) {
		dao.salvar(usuario);
	}

	public void update(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public void delete(Usuario usuario) {
		dao.deletar(usuario);
	}

	public Usuario read(int id, Usuario usuario) {
		Usuario u = dao.carregar(id, usuario);
		return u;
	}

}
