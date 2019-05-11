package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atividade;
import service.AtividadeService;

public class VisualizarAtividade implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AtividadeService as = new AtividadeService();
		ArrayList <Atividade> listaAtividade = null;
		listaAtividade = as.listarAtividades();
		HttpSession sessao = request.getSession();
		sessao.setAttribute("lista_atividade", listaAtividade);
		
		RequestDispatcher disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
		disp.forward(request, response);
		
	}

}
