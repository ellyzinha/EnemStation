package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(String email);

	@Query("select u from Usuario u where u.nome like %:nome% or u.email like %:email%")
	public Usuario findByNomeEmailAprox(String nome, String email); 
	
	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	public Usuario efetuarLogin(String email, String senha);
	
	@Modifying
    @Query("update Usuario u set u.senha = :senha where u.id_usuario = :id_usuario")
    void updateSenha(@Param("senha") String senha, @Param("id_usuario") Integer id_usuario);

}
