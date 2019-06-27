package br.ifpe.web.projeto2.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="usuario")
public class Usuario {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	private String email;
	private String nome;
	private String senha;
	private String conf_senha;
	
	public String getConf_senha() {
		return conf_senha;
	}
	public void setConf_senha(String conf_senha) {
		this.conf_senha = conf_senha;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	

}
