package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.projeto2.Model.Dificuldade;

public interface DificuldadeDAO extends JpaRepository<Dificuldade, Integer> {

}
