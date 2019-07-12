package br.ifpe.web.projeto2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web.projeto2.DAO.DadosUsuarioDAO;
import br.ifpe.web.projeto2.Model.DadosUsuario;


@Controller
public class HomeController {
	
	@Autowired
	private DadosUsuarioDAO dadosUsuarioRep;

	
	@GetMapping("dados_pessoais")
	public ModelAndView dados_pessoais() {
		ModelAndView mv = new ModelAndView("informacoes_pessoais");
		mv.addObject("dadosUsuario", new DadosUsuario());
		return mv;
	}
	
	@PostMapping("add_dadosPessoais")
	public String add_dadosPessoais(@ModelAttribute DadosUsuario dadosUsuario) {
		dadosUsuarioRep.save(dadosUsuario);
		return "redirect:/dados_pessoais";
	}
	
	
	@GetMapping("/adicionar_materiais")
	public String adicionar_materiais() {
		return "adicionar_materiais";
	}
	
	@GetMapping("/adicionar_questoes")
	public String adicionar_questoes() {
		return "adicionar_questoes";
	}
	
	@GetMapping("/administrador")
	public String administrador() {
		return "adm";
	}
	
	@GetMapping("/editar_perfil")
	public String editar_perfil() {
		return "editar_perfil";
	}
	
	@GetMapping("/editar_plano")
	public String editar_plano() {
		return "editar-plano";
	}
	
	
	@GetMapping("/perfil")
	public String perfil() {
		return "perfil";
	}
	
	@GetMapping("/questoes")
	public String questoes() {
		return "questoes";
	}
	
	@GetMapping("/questoesport")
	public String questoesport() {
		return "questoesport";
	}
}