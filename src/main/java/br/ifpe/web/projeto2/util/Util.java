package br.ifpe.web.projeto2.util;

import java.io.File;

public class Util {
	
	public static String caminhoParaArquivo(String nomeArquivo) {
		String caminhoCompleto = new File("").getAbsolutePath()
				+ "/src/main/resources/static/arquivos/";
		new File(caminhoCompleto).mkdirs();
		caminhoCompleto += nomeArquivo;
		return caminhoCompleto;
	}
}
