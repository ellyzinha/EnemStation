package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.Assunto;

@Repository
public interface AssuntoDAO extends JpaRepository<Assunto, Integer> {

}
