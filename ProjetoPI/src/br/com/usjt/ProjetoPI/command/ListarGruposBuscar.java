package br.com.usjt.ProjetoPI.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.model.Turma;
import br.com.usjt.ProjetoPI.service.GrupoService;

public class ListarGruposBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String sigla = request.getParameter("sigla");
		String ano = request.getParameter("ano");
		String semestre = request.getParameter("semestre");
		
		GrupoService grupoService = new GrupoService();
		ArrayList<Grupo> listaGrupo = null;

		Turma turma = new Turma();
		turma.setSigla(sigla);
		turma.setAnoLetivo(Integer.parseInt(ano));
		turma.setSemestreLetivo(Integer.parseInt(semestre));

		listaGrupo = grupoService.listarGruposPorTurma(turma);
		HttpSession sessao = request.getSession();
		sessao.setAttribute("listaGrupos", listaGrupo);

		RequestDispatcher disp = request.getRequestDispatcher("ListarGrupos.jsp");
		disp.forward(request, response);
	}
}
