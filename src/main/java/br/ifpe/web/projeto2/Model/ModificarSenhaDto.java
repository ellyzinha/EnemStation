package br.ifpe.web.projeto2.Model;

import javax.validation.constraints.NotEmpty;


public class ModificarSenhaDto {

    @NotEmpty
    private String senha;

    @NotEmpty
    private String confirmarSenha;

    @NotEmpty
    private String token;

   

    

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}