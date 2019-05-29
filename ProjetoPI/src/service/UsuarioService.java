package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();

	public void criar(Usuario usuario) {
		dao.criar(usuario);
	}

	public void atualizar(Usuario usuario) {
		dao.atualizar(usuario);
	}

	public void atualizarSenha(String senha, String email) {
		dao.atualizarSenha(senha, email);
	}

	public void deletar(Usuario usuario) {
		dao.deletar(usuario);
	}

	public Usuario carregar(int id, Usuario usuario) {
		return dao.carregar(id, usuario);
	}

	public boolean verificarEmail(String email) {
		return dao.verificarEmail(email);
	}

}
