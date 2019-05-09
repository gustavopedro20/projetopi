package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Grupo;
import service.AlunoService;

public class Login implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login, senha, acesso;
		
		login = request.getParameter("email");
		senha = request.getParameter("senha");
		acesso = request.getParameter("acesso");
		
//		if(acesso.equals("Aluno")) {
//			 return loginAluno(request, login, senha);
//		} else {
//			return loginAdministrador(request, login, senha);
//		}
		
	}
	
	public static String loginAluno(HttpServletRequest request, String email, String senha) {
		
		Aluno aluno = new Aluno();
		aluno.setEmail(email);
		aluno.setSenha(senha);
		
		AlunoService as = new AlunoService();
		Aluno alunoSession = new Aluno();
		alunoSession = as.autenticarAluno(aluno);
		
		if (alunoSession.getId() != 0) {
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("alunoLogado", alunoSession);
			
			ArrayList<Grupo> grupos = new ArrayList<>();
			//grupos = as.;
			
			return "";
		} else {
			return "";
		}
		
	}
	
	public static String loginAdministrador(HttpServletRequest request, String email, String senha) {
		
		return null;
	}

}
//try (PrintWriter out = response.getWriter()) {
//String email = request.getParameter("email");
//String senha = request.getParameter("senha");
//if (email != null && senha != null) {
//	if (email.equals("gustavo@email.com") && senha.equals("1234")) {
//		response.sendRedirect("home.jsp");
//	} else {
//		out.println("Email ou/e Senha inválidos");
//		System.out.println(email+" "+senha);
//	}
//
//} else {
//	out.println("Email ou/e Senha estão vazios!");
//	System.out.println(email+" "+senha);
//}
//
//}