package br.ifpe.web.projeto2.Model;

import java.util.Collection;
import java.util.List;

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

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false, length=10000)
	private String texto;
	private byte[] imagem;
	@Column(nullable=false, length=5000)
	private String enunciado;
	@Column(length=5000)
	private String comentario;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dificuldade")
	private Dificuldade dificuldade;
	@OneToOne
	private Grafico grafico;
	@OneToMany(targetEntity=Alternativa.class, fetch=FetchType.EAGER)
    @JoinColumn(name="id_questao")
	private List<Alternativa> alternativa;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "questoes")
	private Collection <Assunto> assunto;
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public List<Alternativa> getAlternativa() {
		return alternativa;
	}
	public void setAlternativa(List<Alternativa> alternativa) {
		this.alternativa = alternativa;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getComentário() {
		return comentario;
	}
	public void setComentário(String comentário) {
		this.comentario = comentário;
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
	
	public Collection<Assunto> getAssunto() {
		return assunto;
	}
	public void setAssunto(Collection<Assunto> assunto) {
		this.assunto = assunto;
	}
	
	
}
