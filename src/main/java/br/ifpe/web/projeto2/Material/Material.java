package br.ifpe.web.projeto2.Material;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ifpe.web.projeto2.Model.Disciplina;

@Entity
public class Material {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer codigo;
	
	@NotBlank(message="Informe um titulo!")
	@Column(length=20, nullable=false)
	@Size(max=20)
	public String titulo;
	
	@ManyToOne  
	@NotNull(message="selecione uma disciplina")
	@JoinColumn(name ="disciplina_id")
	public Disciplina disciplina;
	
	@Size(max=50)
	public String link;
	

	private String caminhoArquivo;

	
	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
