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
		
		String id = request.getParameter("id");
		String entrega = request.getParameter("entrega");
		
		System.out.println(id+" "+entrega);
		AtividadeService as = new AtividadeService();
		as.atualizarFormatoEntrega(entrega, Integer.parseInt(id));
		
		RequestDispatcher disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
		disp.forward(request, response);

	}

}
