package br.ifpe.web.projeto2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.ifpe.web.projeto2.DAO.AlternativaDAO;
import br.ifpe.web.projeto2.DAO.AssuntoDAO;
import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.Model.Alternativa;
import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Questoes;
import br.ifpe.web.projeto2.exceptions.EnunciadoExistsException;
import br.ifpe.web.projeto2.exceptions.TituloExistsException;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class QuestoesService {
	
	@Autowired
	private QuestoesDAO questoesDAO; 
	@Autowired AlternativaDAO alternativaDAO;
	@Autowired AssuntoDAO assuntoDAO;
	
	public void criarQuestao(Questoes questoes) throws Exception {
		
	    if (this.findQuestoesByEnunciado(questoes.getEnunciado()) != null) {
	        throw new EnunciadoExistsException
	          ("Já existe questão com este enunciado: " + questoes.getEnunciado());
	//    } else if(this.findQuestoesByTitulo(questoes.getTitulo()) != null) {
	    //	throw new TituloExistsException
	  //        ("Já existe questão com este titulo: " + questoes.getTitulo());
	    }
//	    usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	 
		questoesDAO.save(questoes);
	}
	
	public void criarAssunto(Assunto assunto) {
		assuntoDAO.save(assunto);
	}
	
	public void criarAlternativa(Alternativa alternativa) {
		alternativaDAO.save(alternativa);
	}
	
	public Questoes findQuestoesByEnunciado(String enunciado) {
		return questoesDAO.findByEnunciado(enunciado);
	}
	
	

}
