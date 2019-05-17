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
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String idAluno = request.getParameter("id_aluno");
		String idGrupo = request.getParameter("id_grupo");
		
		//CARREGA ALUNO
		Aluno aluno = new Aluno();
		AlunoService as = new AlunoService();
		aluno.setId(Integer.parseInt(idAluno));
		aluno = as.carregar(aluno.getId());
		
		//CARREGA GRUPO
		Grupo grupo = new Grupo();
		GrupoService gs = new GrupoService();
		grupo.setId(Integer.parseInt(idGrupo));
		grupo = gs.carregar(grupo.getId());
		
		//DELETA ALUNO DO GRUPO ESCOLHIDO
		as.deletarAlunoGrupo(grupo.getId(), aluno.getId());
		
		RequestDispatcher disp = null;
		HttpSession sessao = request.getSession();
		@SuppressWarnings("unchecked")
		//ATT A LISTA DE ALUNOS
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) sessao.getAttribute("lista_alunos");
		int pos = busca(aluno, listaAluno);
		listaAluno.remove(pos);
		sessao.setAttribute("lista_alunos", listaAluno);
		request.setAttribute("grupo", grupo);
		disp = request.getRequestDispatcher("EditarGrupo.jsp");
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
		return 0;
	}

}
