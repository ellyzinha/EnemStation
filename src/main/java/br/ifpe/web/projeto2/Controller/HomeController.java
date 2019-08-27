package br.ifpe.web.projeto2.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class HomeController {

	
	
	
	
	@GetMapping("/administrador")
	public String administrador() {
		return "adm";
	}
	
	
	
	@GetMapping("/editar_plano")
	public String editar_plano() {
		return "Usuario/editar-plano";
	}
	
	
	
	
		
	
	 
		
}