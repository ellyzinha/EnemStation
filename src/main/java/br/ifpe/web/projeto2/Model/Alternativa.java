package br.ifpe.web.projeto2.Model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="tb_alternativas")
public class Alternativa {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	@NotBlank
	private String descricao;
	
	@Enumerated
	private Correta resposta;
	
	@ManyToOne
	@JoinColumn(name="id_questoes")
	private Questoes questoes;
	
	
	public Questoes getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Correta getResposta() {
		return resposta;
	}
	public void setResposta(Correta resposta) {
		this.resposta = resposta;
	}
	
	
	
	
	

}
