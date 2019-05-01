package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grupo;
import service.GrupoService;

public class EditarGrupo implements Command {

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
		GrupoService gs = new GrupoService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		grupo = gs.carregar(grupo.getId());
		request.setAttribute("grupo", grupo);
		view = request.getRequestDispatcher("AlterarGrupo.jsp");		
		
		view.forward(request, response);

	}

	public int busca(Grupo grupo, ArrayList<Grupo> lista) {
		Grupo to;
		for(int i = 0; i < lista.size(); i++){
			to = lista.get(i);
			if(to.getId() == grupo.getId()){
				return i;
			}
		}
		return -1;
	}

}
