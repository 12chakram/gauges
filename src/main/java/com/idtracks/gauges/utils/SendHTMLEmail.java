package com.idtracks.gauges.utils;

import org.apache.log4j.Logger;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;



@Service("sendHTMLEmailService")
public class SendHTMLEmail {
	
	private MailSender mailSender;
	
	protected static Logger logger = Logger.getLogger(SendHTMLEmail.class);
	
	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	public String sendMail(String to) {

		String htmlBody = "<html><body>"
				+ "<div style='background-color:lightgray'>"
				+ "<div style='background-color:lightseagreen'><h2>Build Created</h2></div>"
				+ "<h1 style='color:blue'>Your build has been created successfully and is ready to use. Please log in to EasyFinder for more information.</h1>"
				+ "<Strong>Business ID:</strong>"+"<label></label></br></br>"
				+ "<Strong>Business Name:</strong>"+"<label></label></br></br>"
				+ "<Strong>Display Name:</strong>"+"<label></label></br></br>"
				+ "<Strong>Store Hours:</strong><label>Open:</label><label>Close:</label></br></br>"
				+ "<Strong>Business Address:</strong><label></label></br></br>"
				+ "</div>"
				+ "<div style='background-color:lightblue;text-align:end'>"
				+ "<label>TM and copyright © 2013 EasyFinder Inc. Hyderabad, India 500072.</label>"
				+ "</div>" + "</body>" + "</html>";

		try {
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom("kumar.v18@gmail.com");
			message.setTo(to);
			message.setSubject("Thank you for choosing EasyFinder");
			message.setText(htmlBody);
			mailSender.send(message);
			return "Sent message successfully.";
		} catch (Exception exception) {
			logger.debug(exception.getMessage());
		}
		return "unable to send..";
	}	
}
