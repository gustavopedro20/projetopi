package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import service.AlunoService;

public class AdicionarAlunoNoGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// PEGAR ALUNO DA COMBO E JOGAR NA LISTA
		String idAluno = request.getParameter("id_aluno");
		System.out.println("ALUNO COMBO: " + idAluno);
		Aluno aluno = new Aluno();
		AlunoService as = new AlunoService();
		aluno.setId(Integer.parseInt(idAluno));
		aluno = as.carregar(aluno.getId());

		HttpSession sessao = request.getSession();
		RequestDispatcher disp = null;

//		ArrayList<Aluno> listaAluno = new ArrayList<Aluno>();
		//@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAluno = null;
		//int pos = busca(aluno, listaAluno);
		//listaAluno.remove(pos);
		listaAluno.add(aluno);
		sessao.setAttribute("lista_alunos_criar", listaAluno);

		disp = request.getRequestDispatcher("CriarGrupo.jsp");
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
