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
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_disciplina")
public class Disciplina {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false)
	@NotBlank
	private String descricao;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplina")
	private Collection <Assunto> assunto;
	
	
	
	
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
	public Collection<Assunto> getAssunto() {
		return assunto;
	}
	public void setAssunto(Collection<Assunto> assunto) {
		this.assunto = assunto;
	}
	


	
}
