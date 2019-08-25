package br.ifpe.web.projeto2;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.UsuarioService;
import br.ifpe.web.projeto2.util.Util;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Exibir página de cadastro
	 @GetMapping("/cad")
	public ModelAndView cadastrar(Usuario usuario) {
		ModelAndView mv = new ModelAndView("Home/cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	} 
	 
	
	
	
	//Efetuar o cadastro
	@PostMapping("/addUsuario")
	public String addUsuario(@Valid @ModelAttribute Usuario usuario, BindingResult br, RedirectAttributes ra) throws Exception{
		

		if (br.hasErrors()) {
			ra.addFlashAttribute("Errors",br.getAllErrors());
		} else {
			if(usuario.getSenhaRepetida().isEmpty()) {
				ra.addFlashAttribute("Senha_conf","ops! você esqueceu de digita novamente seu senha!");
				return "redirect:/cad";
			}
			try {
				usuario.setSenha(Util.criptografarSenha(usuario.getSenha()));
				
				usuarioService.criarUsuario(usuario);
				ra.addFlashAttribute("mensagem", "Usuário: " + usuario.getNome() + ", cadastrado com sucesso!");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + e.getMessage());
			}
		}
		return "redirect:/cad";
	}
	
	//EFETUANDO LOGIN E/OU CADASTRA VIA GMAIL
	
	@RequestMapping(value = "/loginGmail", method = RequestMethod.POST)
	@ResponseBody
	public String salvarGmail(@RequestParam String nome, @RequestParam String email,HttpSession session) {
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		
		
		this.usuarioService.loginGmail(usuario);
		
		session.setAttribute("usuarioLogado",usuario);
		
		return "redirect:/loginGmailG";
	} 
	
	@GetMapping("/loginGmailG")
	public String login() {
		return "Usuario/login_gmail";
	}
	
	@GetMapping("/loginGmailRequisicao")
	public String requisicao() {
		return "Usuario/login_requisicao";
	}
	
	
	
	
	/*
	  @RequestMapping(value = "/loginGmail", method = RequestMethod.POST)
	@ResponseBody
	public String salvarGmail(@RequestParam String nome, @RequestParam String email,HttpSession session) {
		LoginGmail usuarioLogado = new LoginGmail();
		usuarioLogado.email=email;
		usuarioLogado.nome=nome;
		
		usuarioLogado =usuarioService.loginGmail(usuarioLogado);
		
		session.setAttribute("usuarioLogado",usuarioLogado);
		
		return "redirect:/perfil";
	} 
	 */
	
	

}
