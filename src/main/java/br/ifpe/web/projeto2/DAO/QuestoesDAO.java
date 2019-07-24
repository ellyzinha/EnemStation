package br.ifpe.web.projeto2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web.projeto2.Model.Questoes;

public interface QuestoesDAO extends JpaRepository<Questoes, Integer> {
	
	@Query("select u from Questoes u where u.enunciado = :enunciado")
	public Questoes findByEnunciado(@Param("enunciado")String enunciado);

	@Query("select u from Questoes u where u.titulo like %:titulo% or u.enunciado like %:enunciado%")
	public Questoes findByEnunciadoAprox(@Param("titulo")String titulo,@Param("enunciado") String enunciado); 
	
	@Query("select u from Questoes u where u.titulo = :titulo")
	public Questoes findByTitulo(@Param("titulo")String titulo);
 
	
	public List<Questoes> findByTituloContainingIgnoreCase(String tituloPesquisa);
}
