package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Grupo;
import model.Professor;

import service.GrupoService;

public class CriarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeGrupo = request.getParameter("nome");
		String numeroGrupo = request.getParameter("numero");
		String idProfessor = request.getParameter("professor");
		Grupo grupo = new Grupo();
		Professor prof = new Professor();

		prof.setId(Integer.parseInt(idProfessor));
		grupo.setProf(prof);
		grupo.setNome(nomeGrupo);
		grupo.setNum(Integer.parseInt(numeroGrupo));
		GrupoService cs = new GrupoService();	
		cs.criar(grupo);
		
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("AssociarAlunoGrupo.jsp");
		disp.forward(request, response);

	}

}
