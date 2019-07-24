package br.ifpe.web.projeto2.Model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Disciplina {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
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
