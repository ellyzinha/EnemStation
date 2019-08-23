package br.ifpe.web.projeto2;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.ifpe.web.projeto2.Model.Usuario;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/email-enviado")
	public String enviarEmail(Usuario usuario) {
		try {
			MimeMessage mail = mailSender.createMimeMessage();
			
			MimeMessageHelper helper = new MimeMessageHelper( mail );
            helper.setTo(usuario.getEmail() );
            helper.setSubject( "Teste Envio de e-mail" );
            helper.setText("<p>Amigo ESTO AQUI</p>", true);
            mailSender.send(mail);

            return "redirect:/ind";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar e-mail";
        }
	}

}
