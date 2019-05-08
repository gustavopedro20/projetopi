package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Grupo;
import model.Professor;
import service.AlunoService;

public class ExcluirAlunoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pIdAluno = request.getParameter("id_aluno");
		String pIdGrupo = request.getParameter("id_grupo");
		String pProfessor = request.getParameter("professor");
		String pNumero = request.getParameter("numero");
		String pNome = request.getParameter("nome");
	
		
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(pIdAluno));

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		AlunoService as = new AlunoService();
		as.deletarAlunoGrupo(Integer.parseInt(pIdGrupo), Integer.parseInt(pIdAluno));
		
		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		prof.setNome(pProfessor);
		grupo.setProf(prof);
		grupo.setNome(pNome);
		grupo.setNum(Integer.parseInt(pNumero));
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> lista = (ArrayList<Aluno>) session.getAttribute("lista");
		lista.remove(busca(aluno, lista));
		session.setAttribute("lista", lista);
		session.setAttribute("grupo", grupo);
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		view.forward(request, response);

	}

	public int busca(Aluno aluno, ArrayList<Aluno> lista) {
		Aluno to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == aluno.getId()) {
				return i;
			}
		}
		return 0;
	}

}
