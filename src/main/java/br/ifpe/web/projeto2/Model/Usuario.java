package br.ifpe.web.projeto2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;




@Entity @Table(name="usuario")
public class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_usuario;
	@Column(nullable = false)
	@NotBlank(message = "Campo obrigatório, Insira um nome")
	private String nome;
	@NotBlank(message = "Insira um email válido")
	@Email
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	@NotBlank(message = "Insira uma senha para prosseguir")
	@Min(value = 6, message = "Digite uma senha com mais de 6 caracteres")
	private String senha;
	private boolean ativo;
	@ManyToOne
	private DadosUsuario dadosUsuario;
	
	
	
	
	
	
	public DadosUsuario getDadosUsuario() {
		return dadosUsuario;
	}
	public void setDadosUsuario(DadosUsuario dadosUsuario) {
		this.dadosUsuario = dadosUsuario;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public Integer getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
	
	
	
}
