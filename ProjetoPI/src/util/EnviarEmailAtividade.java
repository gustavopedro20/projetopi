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

public class EnviarEmailAtividade {

	public void enviar(String emailAluno) {//nome da ativida, link da atividade, data da atividade 

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

		/** Ativa Debug para sessão */
		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("enviaremailpi@gmail.com"));

			// Remetente
			Address[] toUser = InternetAddress.parse(emailAluno);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Atividade enviada com sucesso!");// Assunto
			message.setText("Sua atividade foi enviada para aprovação do orientador!");

			// Método para enviar a mensagem criada
			Transport.send(message);
			System.out.println("Menssagem enviada para: " + emailAluno + " com sucesso!");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
