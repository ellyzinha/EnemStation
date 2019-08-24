package br.ifpe.web.projeto2.service;



import javax.mail.internet.InternetAddress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.ifpe.web.projeto2.DAO.LoginGmailDAO;
import br.ifpe.web.projeto2.DAO.UsuarioDAO;
import br.ifpe.web.projeto2.Model.LoginGmail;
import br.ifpe.web.projeto2.Model.Usuario;
import br.ifpe.web.projeto2.exceptions.EmailExistsException;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UsuarioService {
	
	@Autowired
	private UsuarioDAO usuarioDao;
	@Autowired
	private LoginGmailDAO loginGmailDAO;
	
	
	public Usuario efetuarLogin(String email, String senha) throws ServiceException {
		Usuario usuario = this.usuarioDao.efetuarLogin(email, senha);
		if (usuario == null) {
			throw new ServiceException("Login/senha não encontrados");
		}
		if (!usuario.isAtivo()) {
			throw new ServiceException("Usuário [" + usuario.getNome() + "] está bloqueado");
		}
		return usuario;
	}
	
	public Usuario findUsuarioByEmail(String email) {
		return usuarioDao.findByEmail(email);
	}
	
	public Usuario findById(Integer id_usuario) {
		return usuarioDao.findById(id_usuario).orElse(null);
	}
	
	public Object findUsuarioByNomeEmailAprox(String nome, String email) {
		return usuarioDao.findByNomeEmailAprox(nome, email);
	}
	
	public void criarUsuario(Usuario usuario) throws Exception {
			
		    if (this.findUsuarioByEmail(usuario.getEmail()) != null) {
		        throw new EmailExistsException
		          ("Já existe usuário com este e-mail: " + usuario.getEmail());
		    }
	//	    usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		 
			usuarioDao.save(usuario);
		}
	
	public void updateSenha(String senha, Integer id_usuario) {
        usuarioDao.updateSenha(senha, id_usuario);
    }
	
	

	public InternetAddress findUsuarioByEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//VERIFICANDO EMAIL DA NO BANCO
	public LoginGmail findByLoginGmail(String email) {
		return loginGmailDAO.findByLoginEmail(email);
	}
	
	//VERIFICANDO SE O EMAIL DA API JÁ EXISTE NO BANCO, CASO NÃO ESTEJA SALVA
	public LoginGmail loginGmail(LoginGmail lg) {
		
		
		if(this.findByLoginGmail(lg.email) != null){
			return lg;
			
		}
		loginGmailDAO.save(lg);
		return lg;
	}
	
	public Integer findByPermissao(String email) {
		return usuarioDao.findByPermissao(email);
	}
	

	
	
	



}
