package com.chandu.mail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	Properties emailProperties;
	Session Session;
	MimeMessage emailMsg;

	String host = "smtp.gmail.com";
	String port = "587";
	String from = "rahulreddy.arva55@gmail.com";
	String fromPassword = "illuminate@rahul";
	String[] to = { "rahulreddy.arva55@gmail.com" };

	public void setMailServerProperties() {
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", port);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
	}

	public void createEmailMessage(String emailSubject, String emailBody)
			throws AddressException, MessagingException {
		Session = Session.getDefaultInstance(emailProperties, null);
		emailMsg = new MimeMessage(Session);
		for (int i = 0; i < to.length; i++) {
			emailMsg.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to[i]));
		}
		emailMsg.setSubject(emailSubject);
		emailMsg.setContent(emailBody, "text/html");// for a html email
		// emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {
		Transport transport = Session.getTransport("smtp");
		transport.connect(host, from, fromPassword);
		transport.sendMessage(emailMsg, emailMsg.getAllRecipients());
		transport.close();
	}
}
