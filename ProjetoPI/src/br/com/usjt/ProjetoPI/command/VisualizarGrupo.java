package br.com.usjt.ProjetoPI.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Aluno;
import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.service.AlunoService;
import br.com.usjt.ProjetoPI.service.GrupoService;

public class VisualizarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("idGrupo");
		
		Grupo grupo = new Grupo();
		GrupoService grupoService = new GrupoService();
		grupo.setId(Integer.parseInt(idGrupo));
		grupo = grupoService.carregar(grupo.getId());
		
		AlunoService alunoService = new AlunoService();
		ArrayList<Aluno> listaAlunos = null;
		listaAlunos = alunoService.listarAlunosPorGrupo(grupo.getId());
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("listaAlunos", listaAlunos);	
		request.setAttribute("grupo", grupo);
		
		RequestDispatcher disp = request.getRequestDispatcher("VisualizarGrupo.jsp");
		disp.forward(request, response);

	}

}
