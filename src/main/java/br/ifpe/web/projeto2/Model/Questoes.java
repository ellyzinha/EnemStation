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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "tb_questoes")
public class Questoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10000)
    @NotBlank
    private String texto;

    @Column(nullable = true, length = 1000)
    private byte[] imagem;

    @Column(nullable = false, length = 5000)
    @NotBlank
    private String enunciado;

    @Column(length = 5000)
    private String comentario;


    @OneToOne
    @JoinColumn(name = "id_dificuldade")
    private Dificuldade dificuldade;

    @OneToMany(mappedBy = "questoes", targetEntity = Alternativa.class,
            fetch = FetchType.LAZY)
    private List<Alternativa> alternativa;

    @OneToOne
    @JoinColumn(name = "id_assunto")
    private Assunto assunto;

    @OneToOne
    private Disciplina disciplina;


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

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }


}
