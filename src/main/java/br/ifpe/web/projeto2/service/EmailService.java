package br.ifpe.web.projeto2.service;

import java.nio.charset.StandardCharsets;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring5.SpringTemplateEngine;

import br.ifpe.web.projeto2.Model.Mail;
import org.thymeleaf.context.Context;

@Service
public class EmailService {
	
	@Autowired private JavaMailSender emailSender;
	@Autowired private SpringTemplateEngine templateEngine;
	
	
	
	
	public void enviarEmail(Mail mail) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
			
			Context context = new Context();
			context.setVariables(mail.getModel());
			String html = templateEngine.process("email-template", context);
			
			helper.setTo(mail.getTo());
			helper.setText(html, true);
			helper.setSubject(mail.getSubject());
			helper.setFrom(mail.getFrom());
			
			emailSender.send(message);
			} catch(Exception e) {
				throw new RuntimeException(e);
			}
	}

}
