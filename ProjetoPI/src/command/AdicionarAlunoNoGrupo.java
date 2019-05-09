package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;

public class AdicionarAlunoNoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id_aluno");
		System.out.println("ID ALUNO: "+pId);
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(pId));
			
		ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
		listaAluno.add(aluno);
		
		HttpSession session = request.getSession();
		session.setAttribute("lista", listaAluno);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("CriarGrupo.jsp");
		view.forward(request, response);

	}

}
