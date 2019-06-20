package br.com.usjt.ProjetoPI.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.service.GrupoService;
import br.com.usjt.ProjetoPI.service.ProfessorService;


public class EditarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idGrupo = request.getParameter("id_grupo");
		String nomeGrupo = request.getParameter("nome_grupo");
		String numeroGrupo = request.getParameter("numero_grupo");
		String idProfessor = request.getParameter("id_prof");

		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		ProfessorService ps = new ProfessorService();
		//CARREGAR PROFESSOR
		prof.setId(Integer.parseInt(idProfessor));
		prof = (Professor) ps.carregar(prof.getId());
		//CARREGAR GRUPO
		grupo.setProf(prof);
		grupo.setId(Integer.parseInt(idGrupo));
		grupo.setNome(nomeGrupo);
		grupo.setNum(Integer.parseInt(numeroGrupo));
		
		GrupoService gs = new GrupoService();
		gs.atualizar(grupo);
		
		RequestDispatcher view = null;
		HttpSession sessao = request.getSession();
		
		sessao.setAttribute("grupo", grupo);		
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		view.forward(request, response);

	}

}
