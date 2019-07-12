package br.ifpe.web.projeto2;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.Model.LoginGmail;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Exibir página de cadastro
	 @GetMapping("/cad")
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	} 
	
	
	
	//Efetuar o cadastro
	@PostMapping("/addUsuario")
	public String addUsuario(@Valid @ModelAttribute Usuario usuario, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + errors.getFieldErrors());
		} else {
			try {
				usuario.setAtivo(true);
				usuarioService.criarUsuario(usuario);
				ra.addFlashAttribute("mensagem", "Usuário [" + usuario.getNome() + "] criado com sucesso");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + e.getMessage());
			}
		}
		return "redirect:/cad";
	}
	
	//Salvando informações do gmail
	
@RequestMapping(value = "/loginGmail", method = RequestMethod.POST)
	@ResponseBody
	public String salvarGmail(@RequestParam String nome, @RequestParam String email) {
		LoginGmail lg = new LoginGmail();
		lg.email=email;
		lg.nome=nome;
		usuarioService.loginGmail(lg);
		
		return "redirect:/perfil";
	} 
	
	
	
	

}
