package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AtividadeService;

public class EnviarAtividade implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idAtividade = request.getParameter("id");
		String formatoEntrega = request.getParameter("entrega");
		
		System.out.println(idAtividade+" "+formatoEntrega);
		AtividadeService as = new AtividadeService();
		as.atualizarFormatoEntrega(formatoEntrega, Integer.parseInt(idAtividade));
		
		RequestDispatcher disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
		disp.forward(request, response);

	}

}
