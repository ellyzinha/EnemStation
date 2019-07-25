package br.ifpe.web.projeto2;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.AlternativaDAO;
import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.DificuldadeDAO;
import br.ifpe.web.projeto2.DAO.DisciplinaDAO;
import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.Model.Questoes;
import br.ifpe.web.projeto2.service.QuestoesService;

@Controller
public class QuestoesController {
	
	@Autowired
	private DificuldadeDAO dificuldadeRep;
	
	@Autowired
	private AlternativaDAO alternativasRep;
	
	@Autowired
	private QuestoesDAO questoesRep;
	
	@Autowired
	private AssuntoDAO assuntoRep;
	
	@Autowired
	private DisciplinaDAO disciplinaRep;
	
	@Autowired
	private QuestoesService questoesService;
	
	@GetMapping("/adicionando_questoes")
	public ModelAndView exibirFormQuestoes(Questoes questoes) {
		ModelAndView mv = new ModelAndView("adicionando_questoes");		
		mv.addObject("listaDificuldade", this.dificuldadeRep.findAll(Sort.by("descricao")));
		mv.addObject("listaAlternativas", this.alternativasRep.findAll(Sort.by("descricao")));
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		mv.addObject("questoes", questoes);
		return mv;
	}
	
	@GetMapping("/questoes")
	public ModelAndView exibirQuestoes(Questoes questoes) {
		ModelAndView mv = new ModelAndView("questoes");		
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		mv.addObject("questoes", questoes);
		return mv;
	}
	
	
	//@PostMapping("/salvarQuestoes")
	//public ModelAndView salvarFuncionario(@Valid Questoes questoes, BindingResult br) {
	//	if(br.hasErrors()) {
	//		ModelAndView mv = new ModelAndView("adicionando_questoes");
	//		mv.addObject("listaDificuldade", this.dificuldadeRep.findAll(Sort.by("descricao")));
	//		mv.addObject("listaAlternativas", this.alternativasRep.findAll(Sort.by("descricao")));
	//		return mv;
	//	}
	//	this.questoesRep.save(questoes);
	//	return exibirQuestoes();
	//}
	
	@PostMapping("/salvarQuestoes")
	public String salvarQuestoes(@Valid @ModelAttribute Questoes questoes, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "NÃ£o foi possÃ­vel criar questÃ£o: " + errors.getFieldErrors());
		} else {
			try {
				questoesService.criarQuestao(questoes);
				ra.addFlashAttribute("mensagem", "Questão criada com sucesso");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "NÃ£o foi possÃ­vel criar questÃ£o. " + e.getMessage());
			}
		}
		return "redirect:/adicionando_questoes";
	}
	
	@GetMapping("/adm-questoes")
	public ModelAndView exibirQuestoes() {
		ModelAndView mv = new ModelAndView("/adm-questoes");		
		mv.addObject("listaQuestoes", this.questoesRep.findAll(Sort.by("titulo")));
		return mv;
	}
	
	@PostMapping("/questao")
	public ModelAndView pesquisarQuestoes(@RequestParam(required=false) String nomePesquisa, RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView("/questao-achada");		
		
		List<Questoes> listaQuestoes;
		if (nomePesquisa == null || nomePesquisa.trim().isEmpty()) {
			ra.addFlashAttribute("mensagem", "QuestÃ£o nÃ£o encontrada");
			listaQuestoes = this.questoesRep.findAll(Sort.by("texto"));	
		} else {
			listaQuestoes = this.questoesRep.findByTexto(nomePesquisa);
			//listaQuestoes = this.questoesRep.findByAssunto(nomePesquisa);
		}
		
		mv.addObject("listaQuestoes", listaQuestoes);
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		return mv;
	}
	
	@GetMapping("/questao-achada")
	public ModelAndView exibirQuestaoAchada(Questoes questoes) {
		ModelAndView mv = new ModelAndView("/questao-achada");		
		mv.addObject("listaQuestoes", this.questoesRep.findAll(Sort.by("titulo")));
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		mv.addObject("questoes", questoes);
		return mv;
	}
	
	@GetMapping("/vermais")
	public ModelAndView verMais(Questoes questoes) {
		ModelAndView mv = new ModelAndView("/vermais");		
		mv.addObject("listaQuestoes", this.questoesRep.findAll(Sort.by("texto")));
		//mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		// Caso seja passado o Id do produto, esta chamada será para edição do produto
		//if (produto != null && produto.getId() != null) {
			questoes = this.questoesRep.getOne(questoes.getId());
		//} else { // Caso contrário, será uma adição de novo produto
		//	produto = new Produto();
		//}
		mv.addObject("questoes", questoes);
		return mv;
	}
	
	@GetMapping("edit/{id}")
	public ModelAndView exibirEdicao(@PathVariable("id") Integer id) {
		Questoes questoes = questoesService.findById(id);
		ModelAndView mv = new ModelAndView("questao-achada");
		mv.addObject("listaQuestoes", questoesService.listarTodos());
		mv.addObject("questoes", questoes);
		return mv;
	}
	

}

