package br.ifpe.web.projeto2.Model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="questoes")
public class Questoes {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=255)
	private String titulo;
	
	private String imagem;
	
	@Column(nullable=false, length=5000)
	private String enunciado;
	
	@Column(length=5000)
	private String comentario;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dificuldade")
	private Dificuldade dificuldade;
	
	@OneToOne
	private Grafico grafico;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_alternativas")
	private Alternativa alternativas;
	
	@ManyToOne
	private Assunto assunto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Dificuldade getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(Dificuldade dificuldade) {
		this.dificuldade = dificuldade;
	}

	public Grafico getGrafico() {
		return grafico;
	}

	public void setGrafico(Grafico grafico) {
		this.grafico = grafico;
	}

	public Alternativa getAlternativas() {
		return alternativas;
	}

	public void setAlternativas(Alternativa alternativas) {
		this.alternativas = alternativas;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}
	
	
	
	
	
	
	
	
}
