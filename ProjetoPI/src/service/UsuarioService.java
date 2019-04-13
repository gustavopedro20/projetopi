package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO dao;

	public UsuarioService() {
		dao = new UsuarioDAO();
	}

	public void create(Usuario usuario) {
		dao.createUsuario(usuario);
	}

	public void update(Usuario usuario) {
		dao.updateUsuario(usuario);
	}

	public void delete(Usuario usuario) {
		dao.deleteUsuario(usuario);
	}

	public Usuario read(int id, Usuario usuario) {
		Usuario u = dao.readUsuario(id, usuario);
		return u;
	}

}
