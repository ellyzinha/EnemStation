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

	
	
	
	
	@GetMapping("/administrador")
	public String administrador() {
		return "adm";
	}
	
	
	
	@GetMapping("/editar_plano")
	public String editar_plano() {
		return "Usuario/editar-plano";
	}
	
	@GetMapping("/desempenho")
	public String exibirDesempenho() {
		return "Usuario/desempenho";
	}
	
	
		
	
	 
		
}