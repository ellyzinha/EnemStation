package br.ifpe.web.projeto2.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.ifpe.web.projeto2.exceptions.HorarioExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.DisciplinaDAO;


import br.ifpe.web.projeto2.Model.PlanoEstudo;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.PlanoEstudoService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class PlanoController {

	@Autowired
	private PlanoEstudoService planoEstudoService;

	@Autowired
	private DisciplinaDAO disciplinaDAO;

	@Autowired
	private AssuntoDAO assuntoDAO;


	//Exibir Formulario
	@GetMapping("/plano_estudo")
	public ModelAndView plano_estudo(PlanoEstudo planoEstudo) {
		ModelAndView mv = new ModelAndView("Usuario/plano_estudo");
		mv.addObject("planoEstudo", planoEstudo);
		mv.addObject("listaAssunto", assuntoDAO.findAll());
		mv.addObject("listaDisciplina", disciplinaDAO.findAll());
		return mv;
	}

	@PostMapping("/cadastroPlano")
	public ModelAndView cadastroPlano(@Valid @ModelAttribute PlanoEstudo planoEstudo, BindingResult br, HttpSession session, RedirectAttributes ra) throws Exception {
		ModelAndView mv = new ModelAndView();
		if (br.hasErrors()) {
			ra.addFlashAttribute("mensagemCampoPreencha","Preencha o Campo");
			mv.setViewName("Usuario/plano_estudo");
			mv.addObject("listaPlano", planoEstudoService.findAll());
			mv.addObject("listaAssunto", assuntoDAO.findAll());
			mv.addObject("listaDisciplina", disciplinaDAO.findAll());
			return mv;
		}
		try {
			mv.setViewName("redirect:/plano_estudo");
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			planoEstudo.setUsuario(usuario);
			this.planoEstudoService.criarPlano(planoEstudo);
			ra.addFlashAttribute("mensagem", "Plano cadastrado com sucesso!");
			return mv;
		} catch (Exception e) {
			ra.addFlashAttribute("mensagemErroHorario", "Não foi possível cadastrar o horário: " + e.getMessage());
			return mv;
		}

	}
	
//	@GetMapping("/formularioPlano/{id_disciplina}")
//	public ModelAndView listaAssunto(@PathVariable("id_disciplina") Integer id ) {
//		ModelAndView mv = new ModelAndView("/Usuario/listaAssunto::listaAssunto");
//		mv.addObject("listaAssunto", this.planoEstudoService.listaAssunto(id));
//		
//
//		return mv;
//	}
	
//	public String cadastroPlano(@Valid @ModelAttribute PlanoEstudo planoEstudo, Errors errors, RedirectAttributes ra) {
//		if(errors.hasErrors()) {
//			ra.addFlashAttribute("mensagemErro", "Preencha o Campo");
//			return "redirect:/plano_estudo";
//		} else {
//			try {
//				planoEstudoDAO.save(planoEstudo);
//				ra.addFlashAttribute("mensagem", "Plano Criado com Sucesso ");
//			} catch (Exception e) {
//				ra.addAttribute("mensagemErro", "Não foi possível criar o plano. " + e.getMessage());
//			}
//		}
//		return "redirect:/plano_estudo";
//	}
	
	@GetMapping("/editarPlano")
	public ModelAndView editarPlano(@RequestParam Integer id_plano) {
		ModelAndView mv = new ModelAndView("Usuario/plano_estudo");
		mv.addObject("planoEstudo", planoEstudoService.getOne(id_plano));
		mv.addObject("listaAssunto", assuntoDAO.findAll());
		mv.addObject("listaDisciplina", disciplinaDAO.findAll());
		return mv;
	}
	
	@GetMapping("/removerPlano")
	public String removerPlano(@RequestParam Integer id_plano) {
		planoEstudoService.deleteById(id_plano);
		return "redirect:/perfil";
	}
	
}
