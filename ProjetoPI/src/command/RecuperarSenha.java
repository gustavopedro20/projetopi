package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.UsuarioService;
import util.EnviarEmailRecuperarSenha;

public class RecuperarSenha implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		UsuarioService us = new UsuarioService();
		EnviarEmailRecuperarSenha enviarEmail = new EnviarEmailRecuperarSenha();
		RequestDispatcher disp = null;

		if (email == null || !us.verificarEmail(email)) {
			disp = request.getRequestDispatcher("RecuperarSenha.jsp");
			disp.forward(request, response);
		} else {
			String novaSenha = gerarSenha();
			us.atualizarSenha(novaSenha, email);
			enviarEmail.enviar(email, novaSenha);
			disp = request.getRequestDispatcher("index.jsp");
			disp.forward(request, response);
		}

	}

	public String gerarSenha() {

		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };

		String senha = "";

		for (int i = 0; i < 10; i++) {
			int j = (int) (Math.random() * carct.length);
			senha += carct[j];
		}
		return senha;
	}

}
