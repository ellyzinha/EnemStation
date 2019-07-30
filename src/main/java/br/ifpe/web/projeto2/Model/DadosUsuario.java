package br.ifpe.web.projeto2.Model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity @Table(name="dados_usuario")
public class DadosUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_usuario;
	
	private String estado;
	
	private String cidade;
	
	private String sexo;
	
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
	
	private String escolaridade;
	
	private String cursoPretendido;
	
	private String instituicao;
	
	private String tipoInstituicao;
	
	private String provas;
	
	private String enem;
	
	@OneToOne
	private Usuario usuario;
	
	
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCursoPretendido() {
		return cursoPretendido;
	}
	public void setCursoPretendido(String cursoPretendido) {
		this.cursoPretendido = cursoPretendido;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public String getTipoInstituicao() {
		return tipoInstituicao;
	}
	public void setTipoInstituicao(String tipoInstituicao) {
		this.tipoInstituicao = tipoInstituicao;
	}
	public String getProvas() {
		return provas;
	}
	public void setProvas(String provas) {
		this.provas = provas;
	}
	public String getEnem() {
		return enem;
	}
	public void setEnem(String enem) {
		this.enem = enem;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
}
