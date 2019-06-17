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
import service.AlunoService;
import service.GrupoService;

public class ExcluirAlunoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idAluno = request.getParameter("idAluno");
		String idGrupo = request.getParameter("idGrupo");

		// CARREGA ALUNO
		Aluno aluno = new Aluno();
		AlunoService alunoService = new AlunoService();
		aluno.setId(Integer.parseInt(idAluno));
		aluno = alunoService.carregar(aluno.getId());

		// CARREGA GRUPO
		Grupo grupo = new Grupo();
		GrupoService grupoService = new GrupoService();
		grupo.setId(Integer.parseInt(idGrupo));
		grupo = grupoService.carregar(grupo.getId());

		// DELETA ALUNO DO GRUPO ESCOLHIDO
		alunoService.deletarAlunoGrupo(grupo.getId(), aluno.getId());

		RequestDispatcher disp = null;
		HttpSession sessao = request.getSession();
		@SuppressWarnings("unchecked")
		// ATT A LISTA DE ALUNOS
		ArrayList<Aluno> listaAlunos = (ArrayList<Aluno>) sessao.getAttribute("listaAlunos");
		listaAlunos.remove(busca(aluno, listaAlunos));
		sessao.setAttribute("listaAlunos", listaAlunos);
		sessao.setAttribute("grupo", grupo);
		disp = request.getRequestDispatcher("EditarGrupo.jsp");
		disp.forward(request, response);

	}

	public int busca(Aluno aluno, ArrayList<Aluno> listaAlunos) {
		Aluno a;
		for (int i = 0; i < listaAlunos.size(); i++) {
			a = listaAlunos.get(i);
			if (a.getId() == aluno.getId()) {
				return i;
			}
		}
		return -1;
	}

}
