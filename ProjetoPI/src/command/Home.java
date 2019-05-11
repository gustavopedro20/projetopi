package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;

public class Home implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//TELA N ESTA EM USO
//		HttpSession sessao = request.getSession();
//		Aluno aluno = (Aluno) sessao.getAttribute("userLogado");
		
		
		
		
		
		//sessao.getAttribute("alunoLogado");
		
		//ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) sessao.getAttribute("lista_alunos");
		
		
	}

}
