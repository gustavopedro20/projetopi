package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Professor;
import service.AlunoService;
import service.ProfessorService;

public class Login implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login, senha, acesso;

		login = request.getParameter("email");
		senha = request.getParameter("senha");
		acesso = request.getParameter("acesso");

		if (acesso.equals("Aluno")) {
			loginAluno(request, response, login, senha);
		} else if (acesso.equals("Professor")) {
			loginProfessor(request, response, login, senha);
		} else if (acesso.equals("Administrador")) {
			loginAdm(request, response, login, senha);
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginAluno(HttpServletRequest request, HttpServletResponse response, String login, String senha)
			throws ServletException, IOException {

		Aluno aluno = new Aluno();
		aluno.setEmail(login);
		aluno.setSenha(senha);

		AlunoService as = new AlunoService();
		Aluno alunoSession = new Aluno();
		alunoSession = as.autenticarAluno(aluno);

		if (alunoSession.getEmail() != null) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("alunoLogado", alunoSession);
			
			System.out.println("ALUNO EMAIL: " + alunoSession.getEmail());
			System.out.println("ALUNO SENHA: " + alunoSession.getSenha());
			System.out.println(sessao.getAttribute("alunoLogado"));		

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);
			

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginProfessor(HttpServletRequest request, HttpServletResponse response, String login, String senha) 
			throws ServletException, IOException {

		Professor prof = new Professor();
		prof.setEmail(login);
		prof.setSenha(senha);
		
		ProfessorService ps = new ProfessorService();
		Professor profSession = new Professor();
		profSession = (Professor) ps.autenticarProfessor(prof);
		
		if (profSession.getId() != -1) {
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("profLogado", profSession);
			
			System.out.println("PROFESSOR EMAIL: " + profSession.getEmail());
			System.out.println("PROFESOR SENHA: " + profSession.getSenha());
			
			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);
			
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}
		
	}
	
	public static void loginAdm(HttpServletRequest request, HttpServletResponse response, String login, String senha) 
			throws ServletException, IOException {
		
		Professor prof = new Professor();
		prof.setEmail(login);
		prof.setSenha(senha);
		
		ProfessorService ps = new ProfessorService();
		Professor profSession = new Professor();
		profSession = (Professor) ps.autenticarAdm(prof);
		
		if (profSession.getAdm() == 1) {
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("admLogado", profSession);
			
			System.out.println("ADM EMAIL: " + profSession.getEmail());
			System.out.println("ADM SENHA: " + profSession.getSenha());
			
			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);
			
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}
	}

}
