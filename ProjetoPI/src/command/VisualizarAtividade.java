package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Atividade;
import model.TurmaAluno;
import service.AtividadeService;

public class VisualizarAtividade implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		AtividadeService as = new AtividadeService();
		TurmaAluno turmaAluno = new TurmaAluno();
		ArrayList <Atividade> listaAtividade = null;
		
		HttpSession sessao = request.getSession();
		RequestDispatcher disp;
		turmaAluno = (TurmaAluno) sessao.getAttribute("turmaAluno");
		
		if (turmaAluno == null) {
			listaAtividade = as.listarAtividades();
			sessao.setAttribute("lista_atividade", listaAtividade);
			disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
			disp.forward(request, response);
		} else {
			listaAtividade = as.
					listarAtividadesPorAluno(turmaAluno.getAluno().getId());
			sessao.setAttribute("lista_atividade", listaAtividade);
			disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
			disp.forward(request, response);
			
		}
			
	}

}
