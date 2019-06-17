package br.com.usjt.ProjetoPI.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.service.GrupoService;

public class ExcluirGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("idGrupo");
		Grupo grupo = new Grupo();
		grupo.setId(Integer.parseInt(idGrupo));
		GrupoService grupoService = new GrupoService();
		
		RequestDispatcher disp = null;
		HttpSession sessao = request.getSession();

		grupoService.deletar(grupo.getId());

		@SuppressWarnings("unchecked")
		ArrayList<Grupo> listaGrupo = (ArrayList<Grupo>) sessao.getAttribute("listaGrupos");
		listaGrupo = grupoService.listarGrupos();
		sessao.setAttribute("listaGrupos", listaGrupo);
		disp = request.getRequestDispatcher("ListarGrupos.jsp");
		disp.forward(request, response);

	}

}
