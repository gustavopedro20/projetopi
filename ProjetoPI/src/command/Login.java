package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Professor;
import model.TurmaAluno;
import service.AlunoService;
import service.ProfessorService;
import service.TurmaAlunoService;

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
			disp.include(request, response);
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
		
		TurmaAlunoService tas = new TurmaAlunoService();
		TurmaAluno turmaAluno = new TurmaAluno();
		turmaAluno = tas.carregarAlunoTurmaGrupo(alunoSession.getId());

		if (alunoSession.getEmail() != null && turmaAluno.getId() != -1) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("alunoLogado", true);
			sessao.setAttribute("turmaAluno", turmaAluno);
			sessao.setAttribute("userLogado", alunoSession);

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginProfessor(HttpServletRequest request, HttpServletResponse response, String login,
			String senha) throws ServletException, IOException {

		Professor prof = new Professor();
		prof.setEmail(login);
		prof.setSenha(senha);

		ProfessorService ps = new ProfessorService();
		Professor profSession = new Professor();
		profSession = (Professor) ps.autenticarProfessor(prof);

		if (profSession.getId() != -1) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("profLogado", true);
			sessao.setAttribute("userLogado", profSession);

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
		Professor admSession = new Professor();
		admSession = (Professor) ps.autenticarAdm(prof);

		if (admSession.getAdm() == 1) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("admLogado", true);
			sessao.setAttribute("userLogado", admSession);

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}
	}

}
