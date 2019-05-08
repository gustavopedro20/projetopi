package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grupo;
import model.Professor;
import service.GrupoService;

public class ExcluirGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
			System.out.println(e.getStackTrace());
		}

		Grupo grupo = new Grupo();
		grupo.setId(id);
		GrupoService gs = new GrupoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		gs.deletar(grupo.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Grupo> lista = (ArrayList<Grupo>) session.getAttribute("lista");
		lista.remove(busca(grupo, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarGrupos.jsp");
		view.forward(request, response);

	}

	public int busca(Grupo grupo, ArrayList<Grupo> lista) {
		Grupo to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == grupo.getId()) {
				return i;
			}
		}
		return -1;
	}

}
