package br.ifpe.web.projeto2.DAO;

import br.ifpe.web.projeto2.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpe.web.projeto2.Model.Resposta;
import org.springframework.data.jpa.repository.Query;

public interface RespostaDAO extends JpaRepository<Resposta, Integer> {

    //Verificar a Resposta do usuário
//	@Query("select r from Resposta r where r.alternativa.resposta = :0")
//	public Resposta alternativaErrada(Alternativa alternativa);

//	@Query("select r from Resposta r where r.alternativa.resposta = :1")
//	public Resposta alternativaCorreta(Alternativa alternativa);

    @Query("select u from Resposta u where u.usuario = :usuario")
    public Usuario UsuarioId(Usuario usuario);





}
