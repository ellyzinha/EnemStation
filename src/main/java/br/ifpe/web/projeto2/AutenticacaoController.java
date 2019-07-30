package br.ifpe.web.projeto2;



import javax.servlet.http.HttpSession;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.UsuarioDAO;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;

@Controller
public class AutenticacaoController {
	
	@Autowired
	private UsuarioDAO usuarioRep;
	@Autowired
	private UsuarioService usuarioService;
	
	//Efetuar Login
	@GetMapping("/ind")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("usuario", new Usuario());
		return mv;
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Usuario usuario, RedirectAttributes ra, HttpSession session) throws br.ifpe.web.projeto2.service.ServiceException {
		Usuario usuarioLogado;
		try {
			usuarioLogado = this.usuarioService.efetuarLogin(usuario.getEmail(),usuario.getSenha());
			session.setAttribute("usuarioLogado", usuarioLogado);
		} catch (ServiceException e) {
			ra.addFlashAttribute("mensagemErro", e.getMessage());
			return "redirect:/ind";
		}
		
		return "redirect:/perfil";
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/ind";
	}
	
	
	//Exibir página do Administrador
		 @GetMapping("/PerfilAdm")
		 public ModelAndView adm(Usuario usuario) {
			 ModelAndView mv = new ModelAndView("/adm");
			 mv.addObject("usuario", new Usuario());
			 return mv;
		 }

}
