package br.ifpe.web2.excecoes;

public class EmailExistsException extends Exception {
	
	public EmailExistsException(String string) {
		super(string);
	}
	
	private static final long serialVersionUID = 1L;

}
