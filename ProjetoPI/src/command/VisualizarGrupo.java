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
		
		String pId = request.getParameter("id");
		Grupo grupo = new Grupo();
		grupo.setId(Integer.parseInt(pId));
		GrupoService cs = new GrupoService();
		
		AlunoService as = new AlunoService();
		ArrayList<Aluno> lista = new ArrayList<>();
		lista = as.listarAlunosPorGrupo(Integer.parseInt(pId));
		HttpSession session = request.getSession();
		session.setAttribute("lista", lista);
		
		grupo = cs.carregar(grupo.getId());
		request.setAttribute("grupo", grupo);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		view.forward(request, response);

	}

}
