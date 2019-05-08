package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grupo;
import service.GrupoService;

public class ListarGruposBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
//		String chave = request.getParameter("data[search]");
		
		GrupoService gs = new GrupoService();
		ArrayList<Grupo> lista = null;
		HttpSession session = request.getSession();
//		if (chave != null && chave.length() > 0) {
//			lista = gs.listarGrupos(chave);
//		} else {
//			lista = gs.listarGrupos();
//		}
		lista = gs.listarGrupos();
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarGrupos.jsp");
		dispatcher.forward(request, response);
	}
}
