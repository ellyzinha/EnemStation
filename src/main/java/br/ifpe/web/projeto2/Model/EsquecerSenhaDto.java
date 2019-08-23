package br.ifpe.web.projeto2.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EsquecerSenhaDto {
	
	@Email
	@NotEmpty
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
