package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Questoes;

public interface QuestoesDAO extends JpaRepository<Questoes, Integer> {
	
	
	@Query("select q from Questoes q where q.enunciado = :enunciado and q.texto = :texto ")
	public Questoes findByEnunciadoTexto(String enunciado,String texto);

	

}
