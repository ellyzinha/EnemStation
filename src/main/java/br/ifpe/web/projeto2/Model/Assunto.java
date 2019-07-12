package br.ifpe.web.projeto2.Model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Assunto {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_questoes")
	private Questoes questoes;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
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
	public Questoes getQuestoes() {
		return questoes;
	}
	public void setQuestoes(Questoes questoes) {
		this.questoes = questoes;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	

	
}
