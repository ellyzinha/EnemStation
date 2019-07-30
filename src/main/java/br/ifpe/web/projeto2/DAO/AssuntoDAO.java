package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Assunto;

public interface AssuntoDAO extends JpaRepository<Assunto, Integer> {
	
	
	@Query("select a from Assunto a where a.descricao = :descricao")
	public Assunto findByDescricao(String descricao);

}
