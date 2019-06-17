package br.com.usjt.ProjetoPI.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarEmailRecuperarSenha {

	public void enviar(String email, String novaSenha) {

		Properties props = new Properties();
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

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("enviaremailpi@gmail.com"));

			Address[] toUser = InternetAddress.parse(email);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Alteração de Senha");
			message.setText("Sua senha foi alterada para: " + novaSenha
					+ "\nVocê pode mudar essa senha automática quando logar no sistema");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
