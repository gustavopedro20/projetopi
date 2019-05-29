//package command;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import util.EnviarEmailRecuperarSenha;
//
//public class RecuperarSenhaTeste implements Command {
//
//	@Override
//	public void executar(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		String email = request.getParameter("email");
//		RequestDispatcher disp = null;
//		
//		if(email == null) {
//			disp = request.getRequestDispatcher("RecuperarSenha.jsp");
//			disp.forward(request, response);
//		}
//		
//		// CRIAR UM METODO DAO BOOLEAN PRA VER SE O EMAIL EXISTE
//		
//		EnviarEmailRecuperarSenha e = new EnviarEmailRecuperarSenha();
//		e.enviar(email);
//	}
//
//}
