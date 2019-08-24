package br.ifpe.web.projeto2.Material;


import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.util.Util;

@Controller
public class MaterialController {
	
	@Autowired
	private MaterialService materialService;
	
	//CHAMA A PÁGINA DE ADICIONAR MATERIAIS
	@GetMapping("/adicionar_materiais")
	public ModelAndView adicionar_materiais() {
		ModelAndView mv = new ModelAndView("Material/adicionar_materiais");
		//LISTA DISCIPLINAS
		mv.addObject("listaDisciplina",materialService.listarDisciplinas());
		return mv;
	}
	
	
	//CHAMA PÁGINA QUE LISTA AS DISCIPLINAS DOS MATERIAIS 
	@GetMapping("/material_disciplina")
	public ModelAndView material() {
		ModelAndView mv= new ModelAndView("Material/materialPorDisciplina");
		mv.addObject("listarDisciplinas", materialService.listarDisciplinas());
		return mv;
	}
	
	//VERIFICANDO E ACIONANDO METODO DO SERVICE PARA ADICIONAR MATERIAL NO BANCO 
	@PostMapping("/salvarMaterial")
	public String salvarMaterial(@Valid @ModelAttribute Material material,BindingResult br,RedirectAttributes ra,@RequestParam MultipartFile file) throws IllegalStateException, IOException {
		
		//VALIDAÇÃO
		if(br.hasErrors()) {
			ra.addFlashAttribute("Errors",br.getAllErrors());
			
			//VERICANDO SE O ARQUIVO FOI ANEXADO 
			if(file.isEmpty()) {
				ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
				return "redirect:/adicionar_materiais";
			}
			return "redirect:/adicionar_materiais";
			
		}else if(file.isEmpty()) {
			//VERICANDO SE O ARQUIVO FOI ANEXADO
			ra.addFlashAttribute("Mensagem","Upload do arquivo Obrigatorio!");
			return "redirect:/adicionar_materiais";
		}
		try {
			//SALVANDO ARQUIVO NA PASTA
			String path = Util.caminhoParaArquivo(file.getOriginalFilename());
			File destino = new File(path);
			material.setCaminhoArquivo("/arquivos/" + file.getOriginalFilename());
			ra.addFlashAttribute("carregando","");
			this.materialService.salvando(material);
			
			file.transferTo(destino);
			ra.addFlashAttribute("MensagemSucesso","Material "+material.getTitulo()+", Adicionado com sucesso!");
		} catch (Exception e){
			ra.addFlashAttribute("mensagemTitulo", "Não foi possível adicionar o material! "+e.getMessage());
			
		}
		return "redirect:/adicionar_materiais";
	}
	
	/*@GetMapping("/lista_material/{id}")
	public ModelAndView exibirMaterial(@PathVariable("id") Integer id) {
		ModelAndView mv=  new ModelAndView("Material/listaMaterial");
		mv.addObject("listarMateriais",materialService.listarMaterial());
		mv.addObject("quantidade",materialService.quantidades());
		//mv.addObject("semMaterial","não há materiais.");
		if(mv.addObject("quantidade",materialService.listarMaterial()) == null) {
			mv.addObject("semMaterial","não há materiais.");
		}
		return mv;
	}
	
	@GetMapping("/lista_material")
	public ModelAndView exibirMaterial() {
	
		ModelAndView mv=  new ModelAndView("Material/listaMaterial");
		try {
		mv.addObject("listarMateriais",materialService.listarMaterial());
		
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return mv;
	}*/
	
	

	@GetMapping("/lista_material/{id}")
	public ModelAndView exibirMaterial(@PathVariable("id") Integer id,RedirectAttributes ra) {
		ModelAndView mv=  new ModelAndView("Material/listaMaterial");
		mv.addObject("listarMateriais",materialService.listarMaterial(id));
		mv.addObject("titulo",materialService.titulo(id));
		if(materialService.listarMaterial(id) == null) {
			ra.addFlashAttribute("Mensagem","Nenhum material Disponivel!");
			return mv;
		}
		
		
		return mv;
	}
	
	@GetMapping("/teste")
	public ModelAndView teste() {
		ModelAndView mv= new ModelAndView("Material/listaMaterial1");
		mv.addObject("listarDisciplinas", materialService.listarDisciplinas());
		return mv;
	}
	
	
}
