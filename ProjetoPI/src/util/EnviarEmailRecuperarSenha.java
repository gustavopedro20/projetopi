package util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import service.UsuarioService;

public class EnviarEmailRecuperarSenha {

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
	
	public void enviar(String email) {//nome da ativida, link da atividade, data da atividade 

		Properties props = new Properties();
		// Parâmetros de conexão com servidor Gmail
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("enviaremailpi@gmail.com", "projetopi2019");
			}
		});
		
		String novaSenha = gerarSenha();
		try {
			UsuarioService us = new UsuarioService();
			us.atualizarSenha(novaSenha, email);
		} catch (Exception e1) {
			e1.printStackTrace();
			System.out.println(e1.getMessage()); 
		}

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("enviaremailpi@gmail.com"));

			// Remetente
			Address[] toUser = InternetAddress.parse(email);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Alteração de Senha");// Assunto
			message.setText("Sua senha foi alterada para " + novaSenha);

			// Método para enviar a mensagem criada
			Transport.send(message);
			System.out.println("Menssagem enviada para: " + email + " com sucesso!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
