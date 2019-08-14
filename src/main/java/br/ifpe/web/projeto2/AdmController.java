package br.ifpe.web.projeto2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web.projeto2.Material.MaterialService;

@Controller
@RequestMapping("adm")
public class AdmController {
	
	
	@Autowired
	private MaterialService materialService;
	
	@GetMapping("/adicionar_materiais")
	public ModelAndView adicionar_materiais() {
		ModelAndView mv = new ModelAndView("adicionar_materiais");
		//LISTA DISCIPLINAS
		mv.addObject("listaDisciplina",materialService.listarDisciplinas());
		return mv;
	}
}
