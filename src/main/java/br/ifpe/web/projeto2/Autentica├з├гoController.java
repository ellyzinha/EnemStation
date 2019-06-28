package br.ifpe.web.projeto2;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web.projeto2.DAO.UsuarioDAO;

@Controller
public class AutenticaçãoController {
	
	@Autowired
	private UsuarioDAO usuarioRep;
	
	
	//Método para modificar a senha do usuário que vai ser redirecionado pelo link do email.
	@GetMapping("/modificarSenha")
	public ModelAndView alterarSenha(@RequestParam Integer id_usuario) {
		ModelAndView mv = new ModelAndView("/modificar_senha");
		mv.addObject("usuario", usuarioRep.getOne(id_usuario));
		return mv;
	}

}
