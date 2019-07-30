package br.ifpe.web.projeto2;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.AlternativaDAO;
import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.DificuldadeDAO;
import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.Model.Alternativa;
import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Correta;
import br.ifpe.web.projeto2.Model.Questoes;
import br.ifpe.web.projeto2.service.QuestoesService;

@Controller
public class QuestoesController {
	
	@Autowired
	private DificuldadeDAO dificuldadeRep;

	@Autowired
	private QuestoesDAO questoesRep;
	@Autowired
	private QuestoesService questoesService;
	@Autowired
	private AssuntoDAO assuntoRep;
	@Autowired
	private AlternativaDAO alternativaRep;
	
	//Exibir formulário de adicionar questões
	@GetMapping("/adicionando_questoes")
	public ModelAndView exibirFormQuestoes(Questoes questoes, Alternativa alternativa) {
		ModelAndView mv = new ModelAndView("adicionando_questoes");		
		mv.addObject("listaDificuldade", this.dificuldadeRep.findAll(Sort.by("descricao")));
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		mv.addObject("questoes", questoes);
		mv.addObject("alternativa", alternativa);
		mv.addObject("certa",Correta.Certa);
		mv.addObject("errada",Correta.Errada);
		return mv;
	}
	
	//Exibir página de questões
	@GetMapping("/exibir_questoes")
	public ModelAndView questoes (Questoes questoes) {
		ModelAndView mv = new ModelAndView("listarQuestoes");
		mv.addObject("exibirQuestao", this.questoesRep.findAll());
		mv.addObject("exibirAlternativa", this.alternativaRep.findAll());
		return mv;
	}
	
	//Exibir formulário de adicionar assuntos
	@GetMapping("/exibir_assuntos")
	public ModelAndView exibirAssuntos (Assunto assunto) {
		ModelAndView mv = new ModelAndView("adicionar_assunto");
		mv.addObject("assunto", assunto);
		mv.addObject("listar",this.assuntoRep.findAll());
		return mv;
	}
	
	
	
	//Método para salvar alternativas
//	@PostMapping("/salvarAlternativa")
//	public String salvarAlternativa(@Valid @ModelAttribute Alternativa alternativa, Errors errors, RedirectAttributes ra) {
//		if(errors.hasErrors()) {
//			ra.addFlashAttribute("mensagemErro", "Não foi possível criar alternativas: " + errors.getFieldError());
//		}else {
//			try {
//				questoesService.criarAlternativa(alternativa);
//				ra.addFlashAttribute("mensagem", "Alternativas criadas com sucesso");
//			}catch(Exception e) {
//				ra.addFlashAttribute("mensagemErro","Não foi possível criar alternativas " + e.getMessage());
//			}
//		}
//		return "redirect:/adicionando_questoes";
//	}
	
	
	//Método para salvar questões
	@PostMapping("/salvarQuestoes")
	public String salvarQuestoes(@Valid @ModelAttribute Questoes questoes, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar questão: " + errors.getFieldErrors());
			ra.addFlashAttribute("mensagemCampo","Preencha o campo");
			return "redirect:/adicionando_questoes";
		} else {
			try {
				questoesService.criarQuestao(questoes);
				ra.addFlashAttribute("mensagem", "Questão criada com sucesso");
			} catch (Exception e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar questão. " + e.getMessage());
				
			}
		}
		return "redirect:/adicionando_questoes";
	}
	
	//Método para salvar assunto
	@PostMapping("/salvarAssunto")
	public String salvarAssunto(@Valid @ModelAttribute Assunto assunto, Errors errors,RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar assunto: "+ errors.getFieldErrors());
		}else {
			try {
				questoesService.criarAssunto(assunto);
				ra.addFlashAttribute("mensagem", "Assunto criado com sucesso");
			}catch (Exception a) {
				ra.addFlashAttribute("mensagemErro","Não foi possível criar questão: " + a.getMessage());
			}
		}
		return "redirect:/exibir_assuntos";
	}
	
	
	

}
