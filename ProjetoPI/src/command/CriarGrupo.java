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

public class CriarGrupo implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pNome = request.getParameter("nome");
		String pNumero = request.getParameter("numero");
		String pProfessorId = request.getParameter("professor");
		
		System.out.println(" nome:"+ pNome+" numero: "+pNumero+"professor: "+pProfessorId);
		
		int professorid = -1;
		int numero = -1;
		try {
			numero = Integer.parseInt(pNumero);
			professorid = Integer.parseInt(pProfessorId);
		} catch (Exception e) {
			e.getMessage();
		}
		Grupo grupo = new Grupo();
		Professor prof = new Professor();

		prof.setId(professorid);
		grupo.setProf(prof);
		grupo.setNome(pNome);
		grupo.setNum(numero);
		GrupoService cs = new GrupoService();
		cs.criar(grupo);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		ArrayList<Grupo> lista = new ArrayList<>();
		lista.add(grupo);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("VisualizarGrupo.jsp");

		view.forward(request, response);

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
