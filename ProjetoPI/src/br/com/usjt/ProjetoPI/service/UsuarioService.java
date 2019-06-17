package br.com.usjt.ProjetoPI.service;

import br.com.usjt.ProjetoPI.model.Aluno;
import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.model.Usuario;
import br.com.usjt.ProjetoPI.persistencia.UsuarioDAO;

public class UsuarioService {

	UsuarioDAO dao = new UsuarioDAO();

	public void criarProfessor(Usuario usuario, Professor professor) {
		dao.criarProfessor(usuario, professor);
	}
	
	public void criarAluno(Usuario usuario, Aluno aluno) {
		dao.criarAluno(usuario, aluno);
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
