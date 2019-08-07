package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Alternativa;
import br.ifpe.web.projeto2.Model.Questoes;

public interface AlternativaDAO extends JpaRepository<Alternativa, Integer> {
	
	@Query("select descricao from Alternativa where questoes = :questoes")
	public Alternativa IdQuestaoAlternativa(Questoes questoes);

}
