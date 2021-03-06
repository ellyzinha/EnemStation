package br.ifpe.web.projeto2.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web.projeto2.DAO.DadosUsuarioDAO;
import br.ifpe.web.projeto2.DAO.PlanoEstudoDAO;
import br.ifpe.web.projeto2.DAO.UsuarioDAO;
import br.ifpe.web.projeto2.Model.DadosUsuario;
import br.ifpe.web.projeto2.Model.PlanoEstudo;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.service.PlanoEstudoService;
import br.ifpe.web.projeto2.service.UsuarioService;


@Controller
public class PerfilController {
	
	@Autowired
	public UsuarioDAO usuarioRep;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private DadosUsuarioDAO dadosUsuarioRep;
	@Autowired
	private PlanoEstudoService planoEstudoService;
	
	
	@GetMapping("/perfil")
	public ModelAndView exibirPerfil() {
		ModelAndView mv = new ModelAndView("Usuario/perfil");
		mv.addObject("listaUsuarios", this.usuarioRep.findAll(Sort.by("nome")));
		return mv;
	}
	
	@GetMapping("/planoEstudo/{diadasemana}")
	public ModelAndView planoEstudo(@PathVariable("diadasemana")String diadasemana,  HttpSession session) {
		ModelAndView mv = new ModelAndView("/Usuario/perfil::planoEstudo");
		Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
		mv.addObject("planoEstudo", this.planoEstudoService.listaPlano(diadasemana, usuario));
		return mv;
	}
	
	
	@GetMapping("/editar_perfil")
	public ModelAndView exibirEditarPerfil(Usuario usuario) {
		ModelAndView mv = new ModelAndView("Usuario/editar_perfil");		
		mv.addObject("listaUsuarios", this.usuarioRep.findAll(Sort.by("nome")));
		if (usuario != null && usuario.getId_usuario() != null) {
			usuario = this.usuarioRep.getOne(usuario.getId_usuario());
		} else { 
			return mv;
		}
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	/*@PostMapping("/salvarPerfil")
	public ModelAndView salvarPerfil(@Valid @ModelAttribute Usuario usuario, @RequestParam("fileFoto")MultipartFile file, BindingResult br) throws IOException {
		if (br.hasErrors()) {
			ModelAndView mv = new ModelAndView("/editar_perfil");
			return mv;
		} 
			usuario.setFoto(file.getBytes());
		this.usuarioRep.save(usuario);
		return exibirPerfil();
	} */
	
	@PostMapping("/salvarPerfil")
	public String salvarPerfil (@Valid @ModelAttribute Usuario usuario, BindingResult br, RedirectAttributes ra, HttpSession session, @RequestParam("fileFoto") MultipartFile file) {
		Usuario usuarioLogado;
		
		try {
			usuarioLogado = this.usuarioService.efetuarLogin(usuario.getEmail(),usuario.getSenha());
			session.setAttribute("usuarioLogado", usuarioLogado);
			if(br.hasErrors()) {
				ra.addFlashAttribute("Errors",br.getAllErrors());
				return "redirect:/editar-perfil?id_usuario=" + usuarioLogado.getId_usuario();
			} else {
			try {
				usuario.setFoto(file.getBytes());
			} catch (IOException e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível realizar alteração " + e.getMessage());
				e.printStackTrace();
			}
			this.usuarioRep.save(usuario);
			ra.addFlashAttribute("mensagemSucesso", "Alterações salvas");
			return "redirect:/editar_perfil?id_usuario=" + usuarioLogado.getId_usuario();
		}
			
		} catch (Exception e){
			ra.addFlashAttribute("mensagemErro", e.getMessage());
			return "redirect:/perfil";
		}	
		
	}
	
	@GetMapping("/perfilRem")
	public String removerPerfil(Usuario usuario) {
		if (usuario != null && usuario.getId_usuario() != null) {
			this.usuarioRep.delete(usuario);
			return "redirect:/";
		}
		return "redirect:/perfil";
	}
	
	@GetMapping("/dados_pessoais")
	public ModelAndView dados_pessoais(DadosUsuario dadosUsuario, Usuario usuario) {
		ModelAndView mv = new ModelAndView("/Usuario/informacoes_pessoais");
		if (dadosUsuario != null && dadosUsuario.getUsuario() != null) {
			dadosUsuario = this.dadosUsuarioRep.getOneUsuarioId();
			return exibirPerfil();
		} else { // Caso contrário, será uma adição de novo produto
			dadosUsuario = new DadosUsuario();
		}
		
		mv.addObject("dadosUsuario", new DadosUsuario());
		return mv;
	}

	
	
}
