package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Grupo;
import model.Professor;
import service.GrupoService;


/**
 * Servlet implementation class ManterClienteController
 */
@WebServlet("/ManterGrupo.do")
public class ManterGrupoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String pAcao = request.getParameter("acao");
		String pId = request.getParameter("id");
		//String pNomeProfessor = request.getParameter("professor");
		String pIdProfessor = request.getParameter("professor");
		String pNome = request.getParameter("nome");
		String pNumero = request.getParameter("numero");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {

		}

		Grupo grupo = new Grupo();
		Professor prof = new Professor();
		grupo.setId(id);
		prof.setId(Integer.parseInt(pIdProfessor));
		grupo.setProf(prof);
		grupo.setNome(pNome);
		grupo.setNum(Integer.parseInt(pNumero));
		GrupoService gs = new GrupoService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		if (pAcao.equals("Criar")) {
			gs.criar(grupo);
			ArrayList<Grupo> lista = new ArrayList<>();
			lista.add(grupo);
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarGrupos.jsp");
			
		} else if (pAcao.equals("Excluir")) {
			gs.deletar(grupo.getId());
			ArrayList<Grupo> lista = (ArrayList<Grupo>)session.getAttribute("lista");
			lista.remove(busca(grupo, lista));
			session.setAttribute("lista", lista);
			view = request.getRequestDispatcher("ListarGrupos.jsp");
			
		} else if (pAcao.equals("Alterar")) {
			gs.atualizar(grupo);
			ArrayList<Grupo> lista = (ArrayList<Grupo>)session.getAttribute("lista");
			int pos = busca(grupo, lista);
			lista.remove(pos);
			lista.add(pos, grupo);
			session.setAttribute("lista", lista);
			request.setAttribute("grupo", grupo);
			view = request.getRequestDispatcher("VisualizarGrupo.jsp");	
			
		} else if (pAcao.equals("Visualizar")) {
			grupo = gs.carregar(grupo.getId());
			request.setAttribute("grupo", grupo);
			view = request.getRequestDispatcher("VisualizarGrupo.jsp");	
			
		} else if (pAcao.equals("Editar")) {
			grupo = gs.carregar(grupo.getId());
			request.setAttribute("grupo", grupo);
			view = request.getRequestDispatcher("AlterarGrupo.jsp");		
		}
		
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
