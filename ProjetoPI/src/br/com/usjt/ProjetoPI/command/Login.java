package br.com.usjt.ProjetoPI.command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Aluno;
import br.com.usjt.ProjetoPI.model.Atividade;
import br.com.usjt.ProjetoPI.model.Grupo;
import br.com.usjt.ProjetoPI.model.Professor;
import br.com.usjt.ProjetoPI.model.Turma;
import br.com.usjt.ProjetoPI.model.TurmaAluno;
import br.com.usjt.ProjetoPI.service.AlunoService;
import br.com.usjt.ProjetoPI.service.AtividadeService;
import br.com.usjt.ProjetoPI.service.GrupoService;
import br.com.usjt.ProjetoPI.service.ProfessorService;
import br.com.usjt.ProjetoPI.service.TurmaAlunoService;
import br.com.usjt.ProjetoPI.service.TurmaService;

public class Login implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login, senha, acesso;

		login = request.getParameter("email");
		senha = request.getParameter("senha");
		acesso = request.getParameter("acesso");
		

		if (acesso.equals("Aluno")) {
			loginAluno(request, response, login, senha);
			
		} else if (acesso.equals("Professor")) {
			loginProfessor(request, response, login, senha);
			
		} else if (acesso.equals("Administrador")) {
			loginAdm(request, response, login, senha);
			
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.include(request, response);
		}

	}

	public static void loginAluno(HttpServletRequest request, HttpServletResponse response, String login, String senha)
			throws ServletException, IOException {

		Aluno aluno = new Aluno();
		aluno.setEmail(login);
		aluno.setSenha(senha);

		AlunoService alunoService = new AlunoService();
		Aluno alunoSessao = new Aluno();
		alunoSessao = alunoService.autenticarAluno(aluno);
		

		if (alunoSessao.getEmail() != null) { // && turmaAluno.getId() != -1

			TurmaAlunoService turmaAlunoService = new TurmaAlunoService();
			TurmaAluno turmaAluno = new TurmaAluno();
			turmaAluno = turmaAlunoService.carregarAlunoTurmaGrupo(alunoSessao.getId());
			
			AtividadeService atividadeService = new AtividadeService();
			ArrayList<Atividade> listaAtividade = atividadeService.listarAtividadesPorAluno(alunoSessao.getId());;
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("listaAtividade", listaAtividade);
			sessao.setAttribute("alunoLogado", true);
			sessao.setAttribute("turmaAluno", turmaAluno);
			sessao.setAttribute("userLogado", alunoSessao);

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginProfessor(HttpServletRequest request, HttpServletResponse response, String login,
			String senha) throws ServletException, IOException {

		Professor prof = new Professor();
		prof.setEmail(login);
		prof.setSenha(senha);

		ProfessorService professorService = new ProfessorService();
		Professor profSessao = new Professor();
		profSessao = (Professor) professorService.autenticarProfessor(prof);
		

		if (profSessao.getId() != -1) {
			
			// CARREGAR TELA CRIAR GRUPO //
			ArrayList<Professor> comboProfessor = null;
			comboProfessor = professorService.listarProfessores();

			TurmaService turmaService = new TurmaService();
			ArrayList<Turma> comboTurma = null;
			comboTurma = turmaService.listarTurmas();
			
			//PRE CARREGAR TODOS OS GRUPOS
			GrupoService grupoService = new GrupoService();
			ArrayList<Grupo> listaGrupo = null;
			listaGrupo = grupoService.listarGrupos();
			
			HttpSession sessao = request.getSession();
			sessao.setAttribute("comboProfessor", comboProfessor);
			sessao.setAttribute("comboTurma", comboTurma);
			sessao.setAttribute("listaGrupos", listaGrupo);
			sessao.setAttribute("profLogado", true);
			sessao.setAttribute("userLogado", profSessao);

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public static void loginAdm(HttpServletRequest request, HttpServletResponse response, String login, String senha)
			throws ServletException, IOException {

		Professor prof = new Professor();
		prof.setEmail(login);
		prof.setSenha(senha);

		ProfessorService professorService = new ProfessorService();
		Professor admSessao = new Professor();
		admSessao = (Professor) professorService.autenticarAdm(prof);

		if (admSessao.getAdm() == 1) {
			
			// CARREGAR TELA CRIAR GRUPO //
			ArrayList<Professor> comboProfessor = null;
			comboProfessor = professorService.listarProfessores();

			TurmaService turmaService = new TurmaService();
			ArrayList<Turma> comboTurma = null;
			comboTurma = turmaService.listarTurmas();
			
			// CARREGAR TELA LISTAR ATIVIDADES
			AtividadeService atividadeService = new AtividadeService();
			ArrayList<Atividade> listaAtividade = atividadeService.listarAtividades();
			
			//PRE CARREGAR TODOS OS GRUPOS
			GrupoService grupoService = new GrupoService();
			ArrayList<Grupo> listaGrupo = null;
			listaGrupo = grupoService.listarGrupos();			

			HttpSession sessao = request.getSession();
			sessao.setAttribute("comboProfessor", comboProfessor);
			sessao.setAttribute("comboTurma", comboTurma);
			sessao.setAttribute("listaAtividade", listaAtividade);
			sessao.setAttribute("listaGrupos", listaGrupo);
			sessao.setAttribute("admLogado", true);
			sessao.setAttribute("userLogado", admSessao);

			RequestDispatcher disp = request.getRequestDispatcher("home.jsp");
			disp.forward(request, response);

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}
	}

}
