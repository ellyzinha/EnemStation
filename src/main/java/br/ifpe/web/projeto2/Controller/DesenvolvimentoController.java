package br.ifpe.web.projeto2.Controller;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web.projeto2.DAO.UsuarioDAO;
import br.ifpe.web.projeto2.Model.Grafico;
import br.ifpe.web.projeto2.Model.Usuario;

@Controller
public class DesenvolvimentoController {

	@Autowired
	private UsuarioDAO usuarioRep;
	
	@GetMapping("/desempenho")
	public ModelAndView exibirDesempenho(HttpSession session) {
		Usuario usuario=(Usuario) session.getAttribute("usuarioLogado");
		
		ModelAndView mv = new ModelAndView("Usuario/desempenho");
		//Array ARRAY = usuarioRep.Desempenho();
		mv.addObject("porcentagem",usuarioRep.Desempenho(usuario.getId_usuario()));
		return mv;
	}
	
}
