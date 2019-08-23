package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.DadosUsuario;

@Repository
public interface DadosUsuarioDAO extends JpaRepository<DadosUsuario, Integer> {
	@Query("select u from DadosUsuario u where u.usuario = :usuario")
	DadosUsuario getOneUsuarioId();

}
