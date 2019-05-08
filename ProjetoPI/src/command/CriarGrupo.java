package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grupo;
import model.Professor;
import service.GrupoService;
import service.ProfessorService;

public class CriarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ProfessorService ps = new ProfessorService();
		ArrayList<Professor> lista = new ArrayList<Professor>();
		lista = ps.listarProfessores();
		HttpSession session = request.getSession();
		session.setAttribute("lista", lista);

		RequestDispatcher view = null;
		view = request.getRequestDispatcher("CriarGrupo.jsp");
		view.forward(request, response);

		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pNumero = request.getParameter("numero");
		String pProfessorId = request.getParameter("professor");
		int id = -1;
		int professorid = -1;
		int numero = -1;
		try {
			id = Integer.parseInt(pId);
			numero = Integer.parseInt(pNumero);
			professorid = Integer.parseInt(pProfessorId);
		} catch (Exception e) {
			e.getMessage();
		}
		Grupo grupo = new Grupo();
		Professor prof = new Professor();

		prof.setId(professorid);
		grupo.setProf(prof);
		grupo.setId(id);
		grupo.setNome(pNome);
		grupo.setNum(numero);
		GrupoService cs = new GrupoService();
		cs.criar(grupo);

//		view = request.getRequestDispatcher("home.jsp");
//		view.forward(request, response);

	}

	public int busca(Grupo grupo, ArrayList<Grupo> lista) {
		Grupo g;
		for (int i = 0; i < lista.size(); i++) {
			g = lista.get(i);
			if (g.getId() == grupo.getId()) {
				return i;
			}
		}
		return -1;
	}

}
