package br.ifpe.web.projeto2.DAO;

import br.ifpe.web.projeto2.Model.Alternativa;
import br.ifpe.web.projeto2.Model.Correta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.ifpe.web.projeto2.Model.Resposta;
import br.ifpe.web.projeto2.Model.Usuario;

public interface RespostaDAO extends JpaRepository<Resposta, Integer> {

	//Verificar a Resposta do usuário
//	@Query("select r from Resposta r where r.alternativa = (select c from Alternativa a where a.resposta = : ")
//	Resposta findRespostaAlternativa();
	//Pegar o Id do Usuário
	@Query("select u from Resposta u where u.usuario = :usuario")
	public Usuario UsuarioId(Usuario usuario);

}
