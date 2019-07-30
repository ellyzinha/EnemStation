package br.ifpe.web.projeto2;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.DadosUsuarioDAO;
import br.ifpe.web.projeto2.Model.DadosUsuario;
import br.ifpe.web.projeto2.Model.Usuario;


@Controller
public class HomeController {
	
	@Autowired
	private DadosUsuarioDAO dadosUsuarioRep;

	/*
	@GetMapping("dados_pessoais")
	public ModelAndView dados_pessoais(DadosUsuario dadosUsuario, Usuario usuario) {
		ModelAndView mv = new ModelAndView("informacoes_pessoais");
		if (dadosUsuario != null && dadosUsuario.getUsuario() != null) {
			dadosUsuario = this.dadosUsuarioRep.getOneUsuarioId();
			return exibirPerfil();
		} else { // Caso contrário, será uma adição de novo produto
			dadosUsuario = new DadosUsuario();
		}
		
		mv.addObject("dadosUsuario", new DadosUsuario());
		return mv;
	}
	
	@PostMapping("add_dadosPessoais")
	public String add_dadosPessoais(@ModelAttribute DadosUsuario dadosUsuario) {
		dadosUsuarioRep.save(dadosUsuario);
		return "redirect:/dados_pessoais";
	} */
	
	@PostMapping("add_dadosPessoais")
	public String add_dadosPessoais(@Valid @ModelAttribute DadosUsuario dadosUsuario, BindingResult br, RedirectAttributes ra) {
		if(br.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Erro");
			return "redirect:/dados_pessoais";
		}
		dadosUsuarioRep.save(dadosUsuario);
		ra.addFlashAttribute("mensagemSucesso", "Dados salvos com sucesso!");
		return "redirect:/dados_pessoais";
	}
	
	
	
	@GetMapping("/adicionar_questoes")
	public String adicionar_questoes() {
		return "adicionar_questoes";
	}
	
	@GetMapping("/administrador")
	public String administrador() {
		return "adm";
	}
	
	
	
	@GetMapping("/editar_plano")
	public String editar_plano() {
		return "editar-plano";
	}
	
	
	@GetMapping("/questoesport")
	public String questoesport() {
		return "questoesport";
	}
}