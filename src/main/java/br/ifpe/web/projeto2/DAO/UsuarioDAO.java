package br.ifpe.web.projeto2.DAO;







import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.Grafico;
import br.ifpe.web.projeto2.Model.Usuario;

@Repository
public interface UsuarioDAO extends JpaRepository<Usuario, Integer> {
	
	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(String email);

	@Query("select u from Usuario u where u.nome like %:nome% or u.email like %:email%")
	public Usuario findByNomeEmailAprox(String nome, String email); 
	
	@Query("select u from Usuario u where u.email = :email and u.senha = :senha")
	public Usuario efetuarLogin(String email, String senha);
	
	@Modifying
    @Query("update Usuario u set u.senha = :senha where u.id_usuario = :id_usuario")
    void updateSenha(@Param("senha") String senha, @Param("id_usuario") Integer id_usuario);
	
	@Query("select permissao from Usuario where email = :email")
	public Integer findByPermissao(String email);
	
	
	
	
	//OS CODIGOS ABAIXO SERVIRA PARA REPRESENTACAO DO DESEMPENHO
	//CONSULTANDO QUANTIDADE DE ERROS DAS REPOSTAS DE PORTUGUES
	@Query(value="select disciplinas.descricao, ( select count(tb_resposta.id) from tb_resposta \r\n" + 
			" inner join tb_alternativas on (tb_alternativas.id = tb_resposta.alternativa_id) \r\n" + 
			" inner join tb_questoes on(tb_questoes.id = tb_alternativas.id_questoes) \r\n" + 
			" inner join tb_disciplina on(tb_disciplina.id = tb_questoes.disciplina_id) \r\n" + 
			" where tb_resposta.usuario_id_usuario=1 and tb_alternativas.resposta = 1 and tb_disciplina.id = disciplinas.id)acertos , \r\n" + 
			" \r\n" + 
			" ( select count(tb_resposta.id) from tb_resposta  inner join tb_alternativas on (tb_alternativas.id = tb_resposta.alternativa_id) \r\n" + 
			" inner join tb_questoes on(tb_questoes.id = tb_alternativas.id_questoes) \r\n" + 
			" inner join tb_disciplina on(tb_disciplina.id = tb_questoes.disciplina_id)\r\n" + 
			" where tb_resposta.usuario_id_usuario=1 and tb_alternativas.resposta = 0 and tb_disciplina.id = disciplinas.id)erros \r\n" + 
			" \r\n" + 
			" from tb_disciplina disciplinas", nativeQuery = true)
	public ArrayList Desempenho();
	
	
	/*@Query(value="select disciplinas.descricao, ( select count(Resposta.id) from Resposta \r\n" + 
			" inner join Alternativa on (Alternativa.id = Resposta.alternativa) \r\n" + 
			" inner join Questoes on(Questoes.id = Alternativa.questoes) \r\n" + 
			" inner join Disciplina on(Disciplina.id = Questoes.disciplina) \r\n" + 
			" where Resposta.usuario=1 and Alternativas.resposta = 1 and Disciplina.id = disciplinas.id)acertos , \r\n" + 
			" \r\n" + 
			" ( select count(Resposta.id) from Resposta  inner join Alternativa on (Alternativa.id = Resposta.alternativa) \r\n" + 
			" inner join Questoes on(Questoes.id = Alternativas.questoes) \r\n" + 
			" inner join Disciplina on(Disciplina.id = Questoes.disciplina)\r\n" + 
			" where Resposta.usuario=1 and Alternativa.resposta = 0 and Disciplina.id = disciplinas.id)erros \r\n" + 
			" \r\n" + 
			" from Disciplina disciplinas", nativeQuery = true)
	public ArrayList<Grafico> Desempenho();
	*/

}
