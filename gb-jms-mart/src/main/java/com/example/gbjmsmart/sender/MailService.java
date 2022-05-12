package com.example.gbjmsmart.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

	private final JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public void sendSimpleMessage(String to, String subject, String text){
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(sender);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		System.out.println(message);
		mailSender.send(message);
	}
}