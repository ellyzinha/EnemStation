package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Usuario;

public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	public Usuario efetuarLogin(String email, String senha);

}
