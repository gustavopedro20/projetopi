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
import model.Professor;
import model.Turma;
import service.AlunoService;
import service.GrupoService;
import service.TurmaService;

public class CriarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeGrupo = request.getParameter("nome");
		String numeroGrupo = request.getParameter("numero");
		String idProfessor = request.getParameter("professor");
		String idTurma = request.getParameter("turma");
		
		Turma turma = new Turma();
		Grupo grupo = new Grupo();
		Professor prof = new Professor();

		turma.setId(Integer.parseInt(idTurma));
		prof.setId(Integer.parseInt(idProfessor));
		grupo.setProf(prof);
		grupo.setNome(nomeGrupo);
		grupo.setNum(Integer.parseInt(numeroGrupo));
		grupo.setTurma(turma);
		
		GrupoService grupoService = new GrupoService();
		TurmaService turmaService = new TurmaService();
		
		grupoService.criar(grupo);
		turma = turmaService.carregar(turma.getId());
		
		RequestDispatcher disp = null;
		HttpSession sessao = request.getSession();
		
		// CARREGAR ALUNO COMBO BOX -- TELA ADICINAR ALUNO NO GRUPO -- 
		AlunoService as = new AlunoService();
		ArrayList<Aluno> comboAlunos = null;
		comboAlunos = as.listarAlunosPorTurmaSemGrupo(turma.getId());
		sessao.setAttribute("comboAlunoSemGrupo", comboAlunos);
		
		// CRIAR UMA LISTA DE ALUNOS -- TELA ADICINAR ALUNO NO GRUPO --
		ArrayList<Aluno> listaAlunos = new ArrayList<Aluno>();
		sessao.setAttribute("listaAlunosCriar", listaAlunos);
		
		//JOGAR O GRUPO NA LISTA DE GRUPOS NA TELA DE LISTAR
//		ArrayList<Grupo> listaGrupo = null;
//		listaGrupo = grupoService.listarGrupos(Integer.parseInt(idTurma));
//		
//		sessao.setAttribute("lista_grupos", listaGrupo);
		sessao.setAttribute("grupo", grupo);
		sessao.setAttribute("turma", turma);
		
		
		disp = request.getRequestDispatcher("AssociarAlunoGrupo.jsp");
		disp.forward(request, response);

	}

}
