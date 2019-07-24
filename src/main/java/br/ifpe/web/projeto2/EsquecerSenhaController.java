package br.ifpe.web.projeto2;

import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpe.web.projeto2.DAO.SenhaTokenDAO;
import br.ifpe.web.projeto2.Model.EsquecerSenhaDto;
import br.ifpe.web.projeto2.Model.Mail;
import br.ifpe.web.projeto2.Model.SenhaToken;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.EmailService;
import br.ifpe.web.projeto2.service.UsuarioService;

@Controller
@RequestMapping("/esquecer_senha")
public class EsquecerSenhaController {
	
	@Autowired private UsuarioService usuarioService;
	
	@Autowired private SenhaTokenDAO tokenDAO;
	
	@Autowired private EmailService emailService;
	
	
	@ModelAttribute("esquecerSenhaForm")
	public EsquecerSenhaDto esquecerSenhaDto() {
		return new EsquecerSenhaDto();
	}
	
	@GetMapping
	public String displayEsquecerSenhaPage() {
		return "esquecer_senha";
	}
	
	@PostMapping
    public String processEsquecerSenhaForm(@ModelAttribute("esquecerSenhaForm") @Valid EsquecerSenhaDto form,
                                            BindingResult result,
                                            HttpServletRequest request) {

        if (result.hasErrors()){
            return "esquecer_senha";
        }
        
        Usuario usuario = usuarioService.findUsuarioByEmail(form.getEmail());
        if(usuario == null) {
        	result.rejectValue("email",null, "Não Encontramos uma conta com esse email");
        	return "esquecer_senha";
        }
        
        SenhaToken token = new SenhaToken();
        token.setToken(UUID.randomUUID().toString());
        token.setUsuario(usuario);
        token.setExpiryDate(30);
        tokenDAO.save(token);
        
        Mail mail = new Mail();
        mail.setFrom("adriellylovato@gmail.com");
        mail.setTo(usuario.getEmail());
        mail.setSubject("Modificar Senha");
        
        Map<String, Object> model = new HashMap<>();
        model.put("token", token);
        model.put("usuario", usuario);
        model.put("signature","https://memorynotfound.com");
        String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        model.put("resetUrl", url + "/modificar_senha?token=" + token.getToken());
        mail.setModel(model);
        emailService.enviarEmail(mail);
        
        return "redirect:/esquecer_senha?sucess";
        
        
        
	}       

}
