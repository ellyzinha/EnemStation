package br.ifpe.web.projeto2.Model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="alternativas")
public class Alternativa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_alternativas")
	private Integer id;
	
	private String descricao;
	
	private int resposta;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "alternativas")
	private Collection<Questoes> questoes;

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

	public int getResposta() {
		return resposta;
	}

	public void setResposta(int resposta) {
		this.resposta = resposta;
	}

	public Collection<Questoes> getQuestoes() {
		return questoes;
	}

	public void setQuestoes(Collection<Questoes> questoes) {
		this.questoes = questoes;
	}
	
	
	
	
	

}
