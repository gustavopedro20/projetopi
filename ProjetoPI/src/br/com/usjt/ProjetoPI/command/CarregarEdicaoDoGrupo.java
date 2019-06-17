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

public class CarregarEdicaoDoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idGrupo = request.getParameter("idGrupo");
		Grupo grupo = new Grupo();
		GrupoService cs = new GrupoService();
		grupo.setId(Integer.parseInt(idGrupo));
		grupo = cs.carregar(grupo.getId());
		
		HttpSession sessao = request.getSession();
		
		// CARREGAR ALUNO COMBO BOX -- TELA ADICINAR ALUNO NO GRUPO -- 
		AlunoService as = new AlunoService();
		ArrayList<Aluno> comboAlunos = null;
		comboAlunos = as.listarAlunosPorTurmaSemGrupo(1);
		sessao.setAttribute("comboAlunoSemGrupo", comboAlunos);
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) sessao.getAttribute("listaAlunos");
		sessao.setAttribute("listaAlunos", listaAlunos);
		request.setAttribute("grupo", grupo);
	
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("EditarGrupo.jsp");
		disp.forward(request, response);
		
	}

}
