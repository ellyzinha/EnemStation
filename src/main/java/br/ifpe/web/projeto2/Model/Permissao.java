package br.ifpe.web.projeto2.Model;

public enum Permissao {
	
ADMIN("Administrador"), PADRAO("Usuário padrão");
	
	public String texto;
	
	Permissao(String t) {
		texto = t;
	}

}
