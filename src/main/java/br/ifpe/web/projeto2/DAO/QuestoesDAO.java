package br.ifpe.web.projeto2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Questoes;

public interface QuestoesDAO extends JpaRepository<Questoes, Integer> {
	
	@Query("select u from Questoes u where u.enunciado = :enunciado")
	public Questoes findByEnunciado(@Param("enunciado")String enunciado);
	
	public List<Questoes> findByTexto(String tituloPesquisa);
	
	public List<Questoes> findByAssunto(Assunto assunto);

	

}
