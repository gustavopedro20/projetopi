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
		String pNome = request.getParameter("nome");
		String pNumero = request.getParameter("numero");
		
		int id = -1;
		int numero = -1;
		try {
			id = Integer.parseInt(pId);
			numero = Integer.parseInt(pNumero);
		} catch (NumberFormatException e) {

		}

		Grupo grupo = new Grupo();
		grupo.setId(id);
		grupo.setNome(pNome);
		grupo.setNum(numero);
		GrupoService cs = new GrupoService();
		
		RequestDispatcher view = null;

		grupo = cs.carregar(grupo.getId());
		request.setAttribute("grupo", grupo);
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");

		view.forward(request, response);

	}

}
