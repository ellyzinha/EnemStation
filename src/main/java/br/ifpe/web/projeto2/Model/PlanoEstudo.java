package br.ifpe.web.projeto2.Model;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
public class PlanoEstudo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_plano;
	
	@Column(nullable = false)
	private String diadasemana;
	
	@Column(nullable = false)
	@NotBlank(message = "Informe um horario de Inicio")
	private String horarioInicio;
	
	@Column(nullable = false)
	@NotBlank(message = "Informe um horario Final")
	private String horarioFinal;
	
	@OneToOne
	@NotNull(message = "Informe o Assunto")
	private Assunto assunto;
	
	@OneToOne
	@NotNull(message = "Informe a Disciplina")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Integer getId_plano() {
		return id_plano;
	}

	public void setId_plano(Integer id_plano) {
		this.id_plano = id_plano;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getDiadasemana() {
		return diadasemana;
	}

	public void setDiadasemana(String diadasemana) {
		this.diadasemana = diadasemana;
	}

	
	

	


	
	
	

}
