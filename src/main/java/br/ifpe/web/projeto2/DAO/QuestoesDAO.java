package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Questoes;

public interface QuestoesDAO extends JpaRepository<Questoes, Integer> {
	
	@Query("select u from Questoes u where u.enunciado = :enunciado")
	public Questoes findByEnunciado(String enunciado);

	

}
