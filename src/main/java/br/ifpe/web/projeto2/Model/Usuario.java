package br.ifpe.web.projeto2.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;




@Entity @Table(name="tb_usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id_usuario;
	
	@Column(nullable = false)
	@NotBlank(message = "Campo obrigatório, Insira um nome")
	private String nome;
	
	@NotBlank(message = "Insira um email válido")
	@Email
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = true)
	@Size(min = 6, message = "Digite uma senha com minimo 6 caracteres")
	private String senha;
	
	
	
	
	private int permissao;
	
	@ManyToOne
	private DadosUsuario dadosUsuario;
	
	@Lob
	private byte[] foto;
	
	@Transient
	private String senhaRepetida;
	
	
	
	
	
	
	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}

	public byte[] getFoto() {
		return foto;
	}
	
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public int getPermissao() {
		return permissao;
	}
	
	public void setPermissao(int permissao) {
		this.permissao = permissao;
	}
	
	public DadosUsuario getDadosUsuario() {
		return dadosUsuario;
	}
	
	public void setDadosUsuario(DadosUsuario dadosUsuario) {
		this.dadosUsuario = dadosUsuario;
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
