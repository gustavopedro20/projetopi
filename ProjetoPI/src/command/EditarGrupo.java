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
import service.GrupoService;
import service.ProfessorService;


public class EditarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String idGrupo = request.getParameter("id_grupo");
		String nomeGrupo = request.getParameter("nome_grupo");
		String numeroGrupo = request.getParameter("numero_grupo");
		String idProfessor = request.getParameter("id_prof");

		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		ProfessorService ps = new ProfessorService();
		//CARREGAR PROFESSOR
		prof.setId(Integer.parseInt(idProfessor));
		prof = (Professor) ps.carregar(prof.getId());
		//CARREGAR GRUPO
		grupo.setProf(prof);
		grupo.setId(Integer.parseInt(idGrupo));
		grupo.setNome(nomeGrupo);
		grupo.setNum(Integer.parseInt(numeroGrupo));
		
		GrupoService gs = new GrupoService();
		gs.atualizar(grupo);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		@SuppressWarnings("unchecked")
		ArrayList<Aluno> listaAluno = (ArrayList<Aluno>) session.getAttribute("lista_alunos");
		//int pos = busca(grupo, listaGrupo);
		
//		listaAluno.remove(pos);
//		listaAluno.add(pos, grupo);
		
		session.setAttribute("lista_alunos", listaAluno);
		request.setAttribute("grupo", grupo);
		
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");
		view.forward(request, response);

	}

//	public int busca(Grupo grupo, ArrayList<Grupo> lista) {
//		Grupo to;
//		for(int i = 0; i < lista.size(); i++){
//			to = lista.get(i);
//			if(to.getId() == grupo.getId()){
//				return i;
//			}
//		}
//		return -1;
//	}

}
