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

public class ListarGruposReiniciar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		GrupoService grupoService = new GrupoService();
		ArrayList<Grupo> listaGrupo = null;
		listaGrupo = grupoService.listarGrupos();
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("listaGrupos", listaGrupo);

		RequestDispatcher disp = request.getRequestDispatcher("ListarGrupos.jsp");
		disp.forward(request, response);
	}
}
