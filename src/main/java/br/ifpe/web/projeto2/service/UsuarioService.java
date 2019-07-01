package br.ifpe.web.projeto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.ifpe.web.projeto2.DAO.UsuarioDAO;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web2.excecoes.EmailExistsException;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	//busca usuario pelo email
	public Usuario findUsuarioByEmail(String email) {
		return usuarioDAO.findByEmail(email);
	}
	
	//busca usuario pelo id
	public Usuario findById(Integer id_usuario) {
		return usuarioDAO.findById(id_usuario).orElse(null);
	}
	
	//criar usuario
	public void criarUsuario(Usuario usuario) throws Exception{
		
		if(this.findUsuarioByEmail(usuario.getEmail()) != null) {
			throw new EmailExistsException
			("já existe usuario com este e-mail: " + usuario.getEmail());
		}
		
		usuarioDAO.save(usuario);
	}
	
	//busca usuario pelo nome ou email
	public Object findUsuarioByNomeEmailAprox(String nome, String email) {
		return usuarioDAO.findByNomeEmailAprox(nome,email);
	}
}
