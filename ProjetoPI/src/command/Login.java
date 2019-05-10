package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import service.AlunoService;

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
			loginProfessor(request, login, senha);
		} else if (acesso.equals("Administrador")) {
			// loginADM
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginAluno(HttpServletRequest request, HttpServletResponse response, String email, String senha)
			throws ServletException, IOException {

		Aluno aluno = new Aluno();
		aluno.setEmail(email);
		aluno.setSenha(senha);

		AlunoService as = new AlunoService();
		Aluno alunoSession = new Aluno();
		alunoSession = as.autenticarAluno(aluno);

		if (alunoSession.getEmail() != null) {

			HttpSession sessao = request.getSession();
			sessao.setAttribute("alunoLogado", alunoSession);
			request.authenticate(response);
			
			System.out.println("ALUNO EMAIL: " + alunoSession.getEmail());
			System.out.println("ALUNO SENHA: " + alunoSession.getSenha());
//			System.out.println("SESSAO: "+sessao.equals("alunoLogado"));

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);
			

		} else {
//			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
//			disp.forward(request, response);
		}

	}

	public static String loginProfessor(HttpServletRequest request, String email, String senha) {

		return null;
	}

}
