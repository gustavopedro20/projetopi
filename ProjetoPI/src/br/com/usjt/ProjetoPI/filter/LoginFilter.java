package br.com.usjt.ProjetoPI.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.usjt.ProjetoPI.model.Usuario;

@WebFilter("/controller.do")
public class LoginFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession sessao = req.getSession();
		Usuario userLogado = (Usuario) sessao.getAttribute("userLogado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		if (comando == null) {
			comando = "";
		}

		if (userLogado == null && !uri.equals(path + "/index.jsp") && !comando.equals("Login")
				&& !uri.equals(path + "/RecuperarSenha.jsp") && !comando.equals("RecuperarSenha")) {
			((HttpServletResponse) response).sendRedirect(path + "/index.jsp");
		} else {
			chain.doFilter(request, response);
		}
	}

}
