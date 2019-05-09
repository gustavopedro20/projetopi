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
		ArrayList<Professor> listaProfessor = new ArrayList<Professor>();
		listaProfessor = ps.listarProfessores();
		HttpSession session = request.getSession();
		session.setAttribute("lista_professor", listaProfessor);
		
		TurmaService ts = new TurmaService();
		ArrayList<Turma> listaTurma = new ArrayList<>();
		listaTurma = ts.listarTurmas();
		session.setAttribute("lista_turma", listaTurma);
		
		AlunoService as = new AlunoService();
		ArrayList<Aluno> listaAluno = new ArrayList<>();
		listaAluno = as.listarAlunos();
		session.setAttribute("lista_aluno", listaAluno);
		
		RequestDispatcher view = null;
		view = request.getRequestDispatcher("CriarGrupo.jsp");
		view.forward(request, response);

	}

}
