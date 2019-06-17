package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.EnviarEmailAtividade;
import model.Aluno;
import model.Atividade;
import model.Entrega;
import model.Grupo;
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
		Atividade atividade = new Atividade();
		Grupo grupo = new Grupo();
		
		atividade.setId(Integer.parseInt(idAtividade));
		grupo.setId(turmaAluno.getGrupo().getId());
		
		entrega.setAtividade(atividade);
		entrega.setGrupo(grupo);
		entrega.setLinkAtividade(linkEntrega);
		
		EntregaService entregaService = new EntregaService();
		entregaService.criar(entrega);
		
		try {
			//ENVIAR NOTIFICAÇÃO POR EMAIL
			Aluno aluno = (Aluno) sessao.getAttribute("userLogado");
			String alunoEmail = aluno.getEmail();
			EnviarEmailAtividade EnviarEmail = new EnviarEmailAtividade();
			EnviarEmail.enviar(alunoEmail);
		} catch (Exception e) {
			request.setAttribute("msgErro", true);
			System.out.println("Erro tentar enviar notificação por email - atividade: " + e.getMessage());
		}
		
		@SuppressWarnings("unchecked")
		//ATT A LISTA DE atividade
		ArrayList<Atividade> listaAtividade = (ArrayList<Atividade>) sessao.getAttribute("listaAtividade");
		int pos = busca(atividade, listaAtividade);
		listaAtividade.remove(pos);
		sessao.setAttribute("listaAtividade", listaAtividade);
		disp = request.getRequestDispatcher("VisualizarAtividade.jsp");
		disp.forward(request, response);

	}
	
	public int busca(Atividade atividade, ArrayList<Atividade> listaAtividade) {
		Atividade a;
		for (int i = 0; i < listaAtividade.size(); i++) {
			a = listaAtividade.get(i);
			if (a.getId() == atividade.getId()) {
				return i;
			}
		}
		return 0;
	}

}