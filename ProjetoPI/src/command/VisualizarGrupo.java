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
import service.AlunoService;
import service.GrupoService;

public class VisualizarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("id");
		Grupo grupo = new Grupo();
		grupo.setId(Integer.parseInt(idGrupo));
		GrupoService cs = new GrupoService();
		
		AlunoService as = new AlunoService();
		ArrayList<Aluno> listaAluno = null;
		listaAluno = as.listarAlunosPorGrupo(grupo.getId());
		HttpSession sessao = request.getSession();
		sessao.setAttribute("lista_alunos", listaAluno);

		grupo = cs.carregar(grupo.getId());
		request.setAttribute("grupo", grupo);
		
		RequestDispatcher disp = request.getRequestDispatcher("VisualizarGrupo.jsp");
		disp.forward(request, response);

	}

}
