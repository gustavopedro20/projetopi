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
		String idAluno = request.getParameter("aluno_combo");
		System.out.println("ID ALUNO COMBO: "+idAluno);
		
		Aluno aluno = new Aluno();
		aluno.setId(Integer.parseInt(idAluno));
		
		AlunoService as = new AlunoService();
		aluno = as.carregar(aluno.getId());
		
		Grupo grupo;
		grupo = (Grupo) sessao.getAttribute("grupo");
		
		TurmaAlunoService tas = new TurmaAlunoService();
		tas.atualizarTurmaAluno(grupo.getId(), aluno.getId());
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>)sessao.getAttribute("lista_alunos_criar");
		//int pos = busca(aluno, listaAluno);
		//listaAluno.remove(pos);
		listaAluno.add(aluno);
		sessao.setAttribute("lista_alunos_criar", listaAluno);
		
		// CARREGAR ALUNO COMBO BOX -- TELA ADICINAR ALUNO NO GRUPO -- 
		//AlunoService as = new AlunoService();
		Turma turma = new Turma();
		turma = (Turma) sessao.getAttribute("turma");
		ArrayList<Aluno> listaAlunoCombo = null;
		listaAlunoCombo = as.listarAlunosPorTurmaSemGrupo(turma.getId());
		sessao.setAttribute("lista_aluno", listaAlunoCombo);
		
		disp = request.getRequestDispatcher("AssociarAlunoGrupo.jsp");
		disp.forward(request, response);

	}

	public int busca(Aluno aluno, ArrayList<Aluno> listaAluno) {
		Aluno a;
		for (int i = 0; i < listaAluno.size(); i++) {
			a = listaAluno.get(i);
			if (a.getId() == aluno.getId()) {
				return i;
			}
		}
		return -1;
	}

}
