package br.ifpe.web.projeto2;


import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.Model.Material;
import br.ifpe.web.projeto2.service.MaterialService;
import br.ifpe.web.projeto2.util.Util;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	
	
	@GetMapping("/adicionar_materiais")
	public ModelAndView adicionar_materiais() {
		ModelAndView mv = new ModelAndView("adicionar_materiais");
		//LISTA DISCIPLINAS
		mv.addObject("listaDisciplina",materialService.listarDisciplinas());
		return mv;
	}
	
	/*@PostMapping("/salvarMaterial")
	public String SalvarMaterial(@Valid @ModelAttribute Material material, @RequestParam("fileFoto") MultipartFile file) throws Exception {
		material.setFoto(file.getBytes());
		materialService.salvando(material);
		
		return "adicionar_materiais";
	}*/
	
	/*@PostMapping("/salvarMaterial")
	public String salvarMaterial(@Valid @ModelAttribute Material material,BindingResult br,RedirectAttributes ra,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		
		if(br.hasErrors()) {
			ra.addFlashAttribute("Errors",br.getAllErrors());
			if(file.isEmpty()) {
				ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
				return "redirect:/adicionar_materiais";
			}
			
			return "redirect:/adicionar_materiais";
		}else if(file.isEmpty()) {
			ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
			return "redirect:/adicionar_materiais";
		}
		
		String path = Util.caminhoParaArquivo(file.getOriginalFilename());
		File destino = new File(path);
		material.setCaminhoArquivo("/arquivos/" + file.getOriginalFilename());
		this.materialService.salvando(material);
		file.transferTo(destino);
		
		return "redirect:/adicionar_materiais";
	}*/
	
	@PostMapping("/salvarMaterial")
	public String salvarMaterial(@Valid @ModelAttribute Material material,BindingResult br,RedirectAttributes ra,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		
		if(br.hasErrors()) {
			ra.addFlashAttribute("Errors",br.getAllErrors());
			if(file.isEmpty()) {
				ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
				return "redirect:/adicionar_materiais";
			}
			
			return "redirect:/adicionar_materiais";
		}else if(file.isEmpty()) {
			ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
			return "redirect:/adicionar_materiais";
		}
		try {
			String path = Util.caminhoParaArquivo(file.getOriginalFilename());
			File destino = new File(path);
			material.setCaminhoArquivo("/arquivos/" + file.getOriginalFilename());
			
			this.materialService.salvando(material);
			
			file.transferTo(destino);
			ra.addFlashAttribute("MensagemSucesso","Material "+material.getTitulo()+", Adicionado com sucesso!");
		} catch (Exception e){
			ra.addFlashAttribute("mensagemTitulo", "Não foi possível adicionar o material! Já existe material com titulo: "+material.getTitulo());
			return "redirect:/adicionar_materiais";
		}
		return "redirect:/adicionar_materiais";
	}
	
	
	
	
}
