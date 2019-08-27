package br.ifpe.web.projeto2.Controller;



import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;
import br.ifpe.web.projeto2.util.Util;

@Controller
public class AutenticacaoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//EFETUAR LOGIN
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("Home/index");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, RedirectAttributes ra, Errors errors, HttpSession session) throws br.ifpe.web.projeto2.service.ServiceException {
		Usuario usuarioLogado;
		if (errors.hasErrors()){
			ra.addFlashAttribute("mensagemErro","Email e Senha Inválidos");
		}
		
		
		
		try {
			usuario.setSenha(Util.criptografarSenha(usuario.getSenha()));
			usuarioLogado = this.usuarioService.efetuarLogin(usuario.getEmail(),usuario.getSenha());
			session.setAttribute("usuarioLogado", usuarioLogado);
			if(this.usuarioService.findByPermissao(usuarioLogado.getEmail()) == 1){
				return "redirect:/adicionar_materiais";
			}	
			
		} catch (Exception e) {
			ra.addFlashAttribute("mensagemErroModal", e.getMessage());
			return "redirect:/";
		}
		return "redirect:/perfil";
	}
	
	@GetMapping("/acesso-negado")
	public String acessoNegado() {
		return "acesso-negado";
	}


	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	//Método para modificar a senha do usuário que vai ser redirecionado pelo link do email.
 /**	@GetMapping("/modificarSenha")
	public ModelAndView alterarSenha(@RequestParam Integer id_usuario) {
		ModelAndView mv = new ModelAndView("/modificar_senha");
		mv.addObject("usuario", usuarioRep.getOne(id_usuario));
		return mv;
	} **/

}
