package br.ifpe.web.projeto2.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {
	
	public static String caminhoParaArquivo(String nomeArquivo) {
		String caminhoCompleto = new File("").getAbsolutePath()
				+ "/src/main/resources/static/arquivos/";
		new File(caminhoCompleto).mkdirs();
		caminhoCompleto += nomeArquivo;
		return caminhoCompleto;
	}
	
	public static String criptografarSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		MessageDigest algorithm = MessageDigest.getInstance("SHA-512");
		byte messageDigestSenha[] = algorithm.digest(senha.getBytes("UTF-8"));
		StringBuilder hexStringSenha = new StringBuilder();
		for(byte b : messageDigestSenha) {
			hexStringSenha.append(String.format("%02X", 0xFF & b));
		}
		//SENHA CRIPTOGRAFADA
		return hexStringSenha.toString();
	}
}
