package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import model.Professor;
import model.Usuario;
import service.AlunoService;
import service.ProfessorService;
import service.UsuarioService;

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
		
		// VER SE EMAIL, RA E MATRICULA JÁ EXISTEM
		if (tipo.equals("Aluno")) {
			if (usuarioService.verificarEmail(email) || alunoService.verificarRa(raOuMatricula)) {
				request.setAttribute("erroCadastro", true);
				RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
				disp.forward(request, response);
			}
		} else if (tipo.equals("Professor")) {
			if (usuarioService.verificarEmail(email) || profService.verificarMatricula(raOuMatricula)) {
				request.setAttribute("erroCadastro", true);
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
			request.setAttribute("criado", true);
			RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
			
		} else { // SE NÃO FOR NEM ALUNO SEM PROFESSOR N FAZ NADA
			request.setAttribute("erroCadastro", true);
			RequestDispatcher disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
		}
	}

}
