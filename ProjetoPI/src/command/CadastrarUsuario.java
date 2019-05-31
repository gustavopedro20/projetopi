package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Aluno;
import model.Professor;
import model.Usuario;
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
		
		System.out.println(nome+" "+raOuMatricula+" "+tipo+" "+email+" "+senha);
		 
		UsuarioService service = new UsuarioService();
		Usuario usuario = new Usuario() {
		};
		RequestDispatcher disp;

		if (service.verificarEmail(email)) { // verificar email, ra e matricula
			request.setAttribute("erroCadastro", true);
			disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
		} else if (tipo == "Aluno") { //Criar aluno
			Aluno aluno = new Aluno();
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			aluno.setRa(raOuMatricula);
			service.criarAluno(usuario, aluno);
			request.setAttribute("criado", true);
			disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
		} else {// if (tipo == "Professor") { //Criar professor
			Professor professor = new Professor();
			usuario.setEmail(email);
			usuario.setNome(nome);
			usuario.setSenha(senha);
			professor.setMatricula(raOuMatricula);
			service.criarProfessor(usuario, professor);
			request.setAttribute("criado", true);
			disp = request.getRequestDispatcher("CadastroUsuario.jsp");
			disp.forward(request, response);
		} 
//		else {
//			request.setAttribute("erroCadastro", true);
//			disp = request.getRequestDispatcher("home.jsp");
//			disp.forward(request, response);
//		}
	}

}
