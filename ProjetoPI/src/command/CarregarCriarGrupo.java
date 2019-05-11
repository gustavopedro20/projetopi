package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Professor;
import model.Turma;
import service.AlunoService;
import service.ProfessorService;
import service.TurmaService;

public class CarregarCriarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ProfessorService ps = new ProfessorService();
		ArrayList<Professor> listaProfessor = null;
		listaProfessor = ps.listarProfessores();
		HttpSession sessao = request.getSession();
		sessao.setAttribute("lista_professor", listaProfessor);
		
		TurmaService ts = new TurmaService();
		ArrayList<Turma> listaTurma = null;
		listaTurma = ts.listarTurmas();
		sessao.setAttribute("lista_turma", listaTurma);
		
		AlunoService as = new AlunoService();
		ArrayList<Aluno> listaAluno = null;
		listaAluno = as.listarAlunos();
		sessao.setAttribute("lista_aluno", listaAluno);
		
		ArrayList<Aluno> listaAlunoGrid = new ArrayList<Aluno>();
		sessao.setAttribute("lista_alunos_criar", listaAlunoGrid);
		
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("CriarGrupo.jsp");
		disp.forward(request, response);

	}

}
