package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.SenhaToken;

@Repository
public interface SenhaTokenDAO extends JpaRepository<SenhaToken, Long> {
	
	SenhaToken findByToken(String token);

}
