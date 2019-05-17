package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Entrega;
import model.TurmaAluno;
import service.EntregaService;

public class EnviarAtividade implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sessao = request.getSession();
		RequestDispatcher disp;
		
		String idAtividade = request.getParameter("id");
		String linkEntrega = request.getParameter("entrega");
		
		TurmaAluno turmaAluno = new TurmaAluno();	
		turmaAluno = (TurmaAluno) sessao.getAttribute("turmaAluno");
		Entrega entrega = new Entrega();
		entrega.getAtividade().setId(Integer.parseInt(idAtividade));
		entrega.getGrupo().setId(turmaAluno.getGrupo().getId());
		entrega.setLinkAtividade(linkEntrega);
		
		EntregaService entregaService = new EntregaService();
		entregaService.criar(entrega);
		
		System.out.println(idAtividade+" "+linkEntrega+" "+turmaAluno.getGrupo().getId());
		disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
		disp.forward(request, response);

	}

}
