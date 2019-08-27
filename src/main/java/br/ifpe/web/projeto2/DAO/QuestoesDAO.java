package br.ifpe.web.projeto2.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Questoes;

public interface QuestoesDAO extends JpaRepository<Questoes, Integer> {
	
	
	@Query("select q from Questoes q where q.enunciado = :enunciado and q.texto = :texto ")
	public Questoes findByEnunciadoTexto(String enunciado,String texto);

	@Query("select u from Questoes u where u.enunciado = :enunciado")
	public Questoes findByEnunciado(@Param("enunciado")String enunciado);
	
	public List<Questoes> findByTexto(String tituloPesquisa);
	
	public List<Questoes> findByAssunto(Assunto assunto);

	//Listar questões com paginação
	public Page<Questoes> findAll(Pageable pag);

	//EXIBIR QUESTOES DE UMA DISCIPLINA EXPECIFICA
	@Query(value="select * from tb_questoes where disciplina_id = :id", nativeQuery = true)
	public List<Questoes> findByQuestoes(Integer id);

	//CONSULTANDO DESCRICAO DA DISCIPLINA ESPECIFICA
	@Query("select d.descricao from Disciplina d where d.id = :id")
	public String findByTitulo(Integer id);


}
