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
import service.GrupoService;

public class CarregarEdicaoDoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("id_grupo");

		Grupo grupo = new Grupo();
		GrupoService cs = new GrupoService();
		grupo.setId(Integer.parseInt(idGrupo));
		grupo = cs.carregar(grupo.getId());

		HttpSession sessao = request.getSession();
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) sessao.getAttribute("lista_alunos");
		sessao.setAttribute("lista_alunos", listaAluno);
		request.setAttribute("grupo", grupo);
		
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("EditarGrupo.jsp");
		disp.forward(request, response);
		
	}

}
