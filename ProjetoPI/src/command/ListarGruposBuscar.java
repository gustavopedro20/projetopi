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
		
		String idTurma = request.getParameter("id_turma");
		GrupoService gs = new GrupoService();
		ArrayList<Grupo> listaGrupo = null;
		HttpSession sessao = request.getSession();

//		listaGrupo = gs.listarGrupos();
		listaGrupo = gs.listarGrupos(Integer.parseInt(idTurma));
		sessao.setAttribute("lista_grupos", listaGrupo);

		RequestDispatcher disp = request.getRequestDispatcher("ListarGrupos.jsp");
		disp.forward(request, response);
	}
}
