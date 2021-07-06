package controller;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {
	@Autowired
	private JavaMailSender mailSender;
	public void sendMail(String reciver, String userId, 
			String content,String subject) throws Exception {
		MimeMessage msg = mailSender.createMimeMessage();

		msg.setHeader("content-type", "text/html; charset=UTF-8");
		msg.setContent(content, "text/html; charset=UTF-8");
		msg.setSubject(subject);
		msg.setRecipient(MimeMessage.RecipientType.TO , new InternetAddress(reciver));
		mailSender.send(msg);
	}
}
