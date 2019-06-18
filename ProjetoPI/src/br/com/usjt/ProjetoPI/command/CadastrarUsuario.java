package br.com.usjt.ProjetoPI.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Aluno;
import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.model.Usuario;
import br.com.usjt.ProjetoPI.service.AlunoService;
import br.com.usjt.ProjetoPI.service.ProfessorService;
import br.com.usjt.ProjetoPI.service.UsuarioService;

public class CadastrarUsuario implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String raOuMatricula = request.getParameter("raOuMatricula");
		String tipo = request.getParameter("tipo");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		UsuarioService usuarioService = new UsuarioService();
		ProfessorService profService = new ProfessorService();
		AlunoService alunoService = new AlunoService();

		Usuario usuario = new Usuario() {
		};
		
		HttpSession sessao = request.getSession();
		
		// VER SE EMAIL, RA E MATRICULA J� EXISTEM
		if (tipo.equals("Aluno")) {
			if (usuarioService.verificarEmail(email) || alunoService.verificarRa(raOuMatricula)) {
				request.setAttribute("erro", true);
				RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
				disp.forward(request, response);
			}
		} else if (tipo.equals("Professor")) {
			if (usuarioService.verificarEmail(email) || profService.verificarMatricula(raOuMatricula)) {
				request.setAttribute("erro", true);
				RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
				disp.forward(request, response);
			}
		}

		if (tipo.equals("Aluno")) { // CRIAR ALUNO
			Aluno aluno = new Aluno();
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			aluno.setRa(raOuMatricula);
			usuarioService.criarAluno(usuario, aluno);
			request.setAttribute("criado", true);
			RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);

		} else if (tipo.equals("Professor")) { // CRIAR PROFESSOR
			Professor professor = new Professor();
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			professor.setMatricula(raOuMatricula);
			usuarioService.criarProfessor(usuario, professor);
			/// SETAR NA SESSAO UMA NOVA LISTA COM O PROFESSOR NOVO
			ProfessorService professorService = new ProfessorService();
			ArrayList<Professor> comboProfessor = null;
			comboProfessor = professorService.listarProfessores();
			sessao.setAttribute("comboProfessor", comboProfessor);
			//**//
			request.setAttribute("criado", true);
			RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
			
		} else { // SE N�O FOR NEM ALUNO NEM PROFESSOR N FAZ NADA
			request.setAttribute("erro", true);
			RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
		}
	}

}
