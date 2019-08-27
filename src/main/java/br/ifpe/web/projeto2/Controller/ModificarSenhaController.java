package br.ifpe.web.projeto2.Controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.SenhaTokenDAO;
import br.ifpe.web.projeto2.Model.EsquecerSenhaDto;
import br.ifpe.web.projeto2.Model.ModificarSenhaDto;
import br.ifpe.web.projeto2.Model.SenhaToken;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;

@Controller
@RequestMapping("/modificar_senha")
public class ModificarSenhaController {
	
	@Autowired private UsuarioService usuarioService;
	@Autowired private SenhaTokenDAO tokenDAO;
	
	@ModelAttribute("modificarSenhaForm")
	public ModificarSenhaDto esquecerSenha() {
		return new ModificarSenhaDto();
	}
	
	@GetMapping
	public String displayModificarSenhaPage(@RequestParam(required = false) String token,
            Model model) {
		
		SenhaToken resetToken = tokenDAO.findByToken(token);
		if(resetToken == null) {
			 model.addAttribute("error", "Could not find password reset token.");
        } else if (resetToken.isExpired()){
            model.addAttribute("error", "Token has expired, please request a new password reset.");
        } else {
            model.addAttribute("token", resetToken.getToken());
        }

        return "Usuario/modificar_senha";
    }
	
	@PostMapping
    @Transactional
    public String handlePasswordReset(@ModelAttribute("modificarSenhaForm") @Valid ModificarSenhaDto form,
                                      BindingResult result,
                                      RedirectAttributes redirectAttributes) {

        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute(BindingResult.class.getName() + ".modificarSenhaForm", result);
            redirectAttributes.addFlashAttribute("passwordResetForm", form);
            return "redirect:/modificar_senha?token=" + form.getToken();
        }

        SenhaToken token = tokenDAO.findByToken(form.getToken());
        Usuario usuario = token.getUsuario();
        usuarioService.updateSenha(form.getSenha(), usuario.getId_usuario());
        tokenDAO.delete(token);

        return "redirect:/?resetSuccess";
			
		}
	}


