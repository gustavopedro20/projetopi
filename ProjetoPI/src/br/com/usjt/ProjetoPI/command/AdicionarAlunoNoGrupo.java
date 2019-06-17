package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Grupo;
import model.Turma;
import service.AlunoService;
import service.TurmaAlunoService;

public class AdicionarAlunoNoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		RequestDispatcher disp = null;
		
		// PEGAR ALUNO DA COMBO E JOGAR NA LISTA
		String idAluno = request.getParameter("idAluno");
		
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(idAluno));
		
		AlunoService alunoService = new AlunoService();
		aluno = alunoService.carregar(aluno.getId());
		
		Grupo grupo = (Grupo) sessao.getAttribute("grupo");
		
		TurmaAlunoService turmaAlunoService = new TurmaAlunoService();
		turmaAlunoService.atualizarTurmaAluno(grupo.getId(), aluno.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>)sessao.getAttribute("listaAlunosCriar");
		listaAlunos.add(aluno);
		sessao.setAttribute("listaAlunosCriar", listaAlunos);
		
		// CARREGAR ALUNO COMBO BOX -- TELA ADICINAR ALUNO NO GRUPO -- 
		Turma turma = new Turma();
		turma = (Turma) sessao.getAttribute("turma");
		ArrayList<Aluno> comboAlunos = null;
		comboAlunos = alunoService.listarAlunosPorTurmaSemGrupo(turma.getId());
		sessao.setAttribute("comboAlunoSemGrupo", comboAlunos);
		
		disp = request.getRequestDispatcher("AssociarAlunoGrupo.jsp");
		disp.forward(request, response);

	}

}
