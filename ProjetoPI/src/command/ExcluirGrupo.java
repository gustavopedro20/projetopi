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

public class ExcluirGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("id");
		System.out.println(idGrupo);
		Grupo grupo = new Grupo();
		grupo.setId(Integer.parseInt(idGrupo));
		GrupoService gs = new GrupoService();
		
		RequestDispatcher disp = null;
		HttpSession sessao = request.getSession();

		gs.deletar(grupo.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Grupo> listaGrupo = (ArrayList<Grupo>) sessao.getAttribute("lista_grupos");
		listaGrupo.remove(busca(grupo, listaGrupo));
		sessao.setAttribute("lista_grupos", listaGrupo);
		disp = request.getRequestDispatcher("ListarGrupos.jsp");
		disp.forward(request, response);

	}

	public int busca(Grupo grupo, ArrayList<Grupo> listaGrupo) {
		Grupo g;
		for (int i = 0; i < listaGrupo.size(); i++) {
			g = listaGrupo.get(i);
			if (g.getId() == grupo.getId()) {
				return i;
			}
		}
		return -1;
	}

}
