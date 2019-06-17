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
import br.com.usjt.ProjetoPI.service.TurmaAlunoService;

public class AdicionarAlunoNoGrupoEditar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		RequestDispatcher disp = null;
		
		String idAluno = request.getParameter("idAluno");
		String idGrupo = request.getParameter("id_grupo");
		
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(idAluno));
		
		AlunoService alunoService = new AlunoService();
		aluno = alunoService.carregar(aluno.getId());
		
		GrupoService grupoService = new GrupoService();
		Grupo grupo = grupoService.carregar(Integer.parseInt(idGrupo));
		sessao.setAttribute("grupo", grupo);
		
		TurmaAlunoService turmaAlunoService = new TurmaAlunoService();
		turmaAlunoService.atualizarTurmaAluno(grupo.getId(), aluno.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>)sessao.getAttribute("listaAlunos");
		listaAlunos.add(aluno);
		sessao.setAttribute("listaAlunos", listaAlunos);
		
		ArrayList<Aluno> comboAlunos = alunoService.listarAlunosPorTurmaSemGrupo(grupo.getTurma().getId());
		System.out.println("ID DA TURMA: "+grupo.getTurma().getId());
		sessao.setAttribute("comboAlunoSemGrupo", comboAlunos);
		
		disp = request.getRequestDispatcher("EditarGrupo.jsp");
		disp.forward(request, response);

	}

}
