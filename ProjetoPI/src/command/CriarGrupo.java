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
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pNumero = request.getParameter("numero");
		int id = -1;
		int numero = -1;
		try {
			id = Integer.parseInt(pId);
			numero = Integer.parseInt(pNumero);
		} catch (NumberFormatException e) {

		}

		Grupo grupo = new Grupo();
		grupo.setId(id);
		grupo.setNome(pNome);
		grupo.setNum(numero);
		GrupoService cs = new GrupoService();
		
		//REFAZER
		Professor prof = new Professor();
		ProfessorService ps = new ProfessorService();
		ArrayList<Professor> listaProfessor = ps.listarProfessores(); 

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		cs.criar(grupo);
		ArrayList<Grupo> lista = new ArrayList<>();
		lista.add(grupo);
		
		session.setAttribute("lista", lista);
		session.setAttribute("lista_professor", listaProfessor);
		view = request.getRequestDispatcher("ListarGrupos.jsp");

		view.forward(request, response);

	}

	public int busca(Grupo grupo, ArrayList<Grupo> lista) {
		Grupo to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == grupo.getId()) {
				return i;
			}
		}
		return -1;
	}

}
