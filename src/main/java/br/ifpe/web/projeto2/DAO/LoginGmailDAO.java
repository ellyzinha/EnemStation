package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.LoginGmail;

@Repository
public interface LoginGmailDAO extends JpaRepository<LoginGmail, Integer> {
	
	@Query("select l from LoginGmail l where l.email = :email")
	public LoginGmail findByLoginEmail(String email);

}
