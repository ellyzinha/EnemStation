package br.ifpe.web.projeto2.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.PlanoEstudo;
import br.ifpe.web.projeto2.Model.Usuario;

public interface PlanoEstudoDAO extends JpaRepository<PlanoEstudo, Integer> {

	@Query("select p from PlanoEstudo p where p.diadasemana = :diadasemana and p.usuario = :usuario")
	public List<PlanoEstudo> planoEstudo(String diadasemana, Usuario usuario);
	
	@Query("select a from Assunto a where a.disciplina.id = :id_disciplina")
	public List<Assunto> listaAssunto(Integer id_disciplina);
	
}
