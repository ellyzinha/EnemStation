package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Disciplina;

public interface DisciplinaDAO extends JpaRepository<Disciplina, Integer> {
	
	@Query("select d from Disciplina d where d.descricao = :descricao")
	public Disciplina findbyDescricao(String descricao);

}
