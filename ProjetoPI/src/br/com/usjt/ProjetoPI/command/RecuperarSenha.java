package br.com.usjt.ProjetoPI.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.usjt.ProjetoPI.mail.EnviarEmailRecuperarSenha;
import br.com.usjt.ProjetoPI.service.UsuarioService;
import br.com.usjt.ProjetoPI.util.GerarSenha;

public class RecuperarSenha implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		UsuarioService service = new UsuarioService();
		EnviarEmailRecuperarSenha enviarEmail = new EnviarEmailRecuperarSenha();
		GerarSenha gerar = new GerarSenha();
		RequestDispatcher disp = null;

		if (email == null || !service.verificarEmail(email)) {
			request.setAttribute("invalido", true);
			disp = request.getRequestDispatcher("RecuperarSenha.jsp");
			disp.forward(request, response);
		} else {
			String novaSenha = gerar.gerarSenha();
			service.atualizarSenha(novaSenha, email);
			enviarEmail.enviar(email, novaSenha);
			request.setAttribute("valido", true);
			disp = request.getRequestDispatcher("RecuperarSenha.jsp");
			disp.forward(request, response);
		}
	}
}
