package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import service.GrupoService;

public class VisualizarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String pId = request.getParameter("id");
		Grupo grupo = new Grupo();
		grupo.setId(Integer.parseInt(pId));
		GrupoService cs = new GrupoService();
		
		grupo = cs.carregar(grupo.getId());
		request.setAttribute("grupo", grupo);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		view.forward(request, response);

	}

}
