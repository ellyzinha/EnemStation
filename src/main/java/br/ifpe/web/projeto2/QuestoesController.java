package br.ifpe.web.projeto2;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.DificuldadeDAO;
import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.Model.Alternativa;
import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Correta;
import br.ifpe.web.projeto2.Model.Questoes;
import br.ifpe.web.projeto2.Model.Resposta;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.QuestoesService;
import br.ifpe.web.projeto2.service.UsuarioService;

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
	private UsuarioService user;
	
	//Exibir formulário de adicionar questões
	@GetMapping("/adicionando_questoes")
	public ModelAndView exibirFormQuestoes(Questoes questoes, Alternativa alternativa) {
		ModelAndView mv = new ModelAndView("Questao/adicionando_questoes");		
		mv.addObject("listaDificuldade", this.dificuldadeRep.findAll());
		mv.addObject("listaAssunto", this.assuntoRep.findAll());
		mv.addObject("questoes", questoes);
		mv.addObject("alternativa", alternativa);
		mv.addObject("certa",Correta.Certa);
		mv.addObject("errada",Correta.Errada);
		return mv;
	}
	
	@GetMapping("/questoes")
	public ModelAndView exibirQuestoes(Questoes questoes) {
		ModelAndView mv = new ModelAndView("Questao/questoes");		
		mv.addObject("listaAssunto", this.assuntoRep.findAll(Sort.by("descricao")));
		mv.addObject("listaDisciplinas", this.questoesService.listarDisciplinas());
		mv.addObject("questoes", questoes);
		return mv;
	}
	
	//Exibir formulário de adicionar assuntos
	@GetMapping("/exibir_assuntos")
	public ModelAndView exibirAssuntos (Assunto assunto) {
		ModelAndView mv = new ModelAndView("Administrador/adicionar_assunto");
		mv.addObject("assunto", assunto);
		mv.addObject("listar",this.assuntoRep.findAll());
		return mv;
	}
	
	
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
	
	
	
	
	@PostMapping("/questao")
	public ModelAndView pesquisarQuestoes(@RequestParam(required=false) String nomePesquisa, RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView("Questao/questao-achada");		
		
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
		ModelAndView mv = new ModelAndView("Questao/questao-achada");		
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
	
	//Exibir questões para o usuário responder
	
	@GetMapping("/listaQuestoes")
	public ModelAndView exibirMaterial(Resposta resposta) {
		ModelAndView mv=  new ModelAndView("Questao/ExibirQuestoes");
	//	List<Questoes> questoes = questoesService.listarQuestoes();
		mv.addObject("listarQuestoes",questoesService.listarQuestoes());
		mv.addObject("resposta",resposta);
	
		return mv;
	}
	
	// Salvar resposta do usuário
	@PostMapping("/salvarResposta")
	public String salvarResposta(@ModelAttribute Resposta resposta, HttpSession session) {
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		resposta.setUsuario(usuario);
		this.questoesService.salvarResposta(resposta);
		return "redirect:/listaQuestoes";
	}
	

}
