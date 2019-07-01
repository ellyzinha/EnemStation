package br.ifpe.web.projeto2.Model;

public enum Permissao {
	
	ADMIN("administrador"),PADRAO("Usuario padrão");
	
	public String texto;
	
	Permissao(String t){
		texto = t;
	}
}
