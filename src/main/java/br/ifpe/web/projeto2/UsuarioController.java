package br.ifpe.web.projeto2;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	//chama pagiga de cadastro
	@GetMapping("/cadastro")
	public ModelAndView cadastra(Usuario usuario) {
		ModelAndView mv = new ModelAndView("cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	//salvando usuario no banco
	@PostMapping("/addUsuario")
	public String salvarUsuario(@Valid @ModelAttribute Usuario usuario, Errors errors, RedirectAttributes ra) {
		if(errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possíivel criar usuário: "+ errors.getFieldErrors());
		}else {
			try {
				usuario.setAtivo(true);
				usuarioService.criarUsuario(usuario);
				ra.addFlashAttribute("mensagem", "Usuário [" + usuario.getNome() + "] criado com sucesso");
			}catch (Exception e) {
				ra.addFlashAttribute("mensagemErro","Não foi possível criar usuário : " + e.getMessage());
			}
		}
		return "redirect:/cadastro";
	}
	
	//login via gmail
	@GetMapping("/gmail")
	public String loginGmail() {
		return "gmail";
	}
	
}
