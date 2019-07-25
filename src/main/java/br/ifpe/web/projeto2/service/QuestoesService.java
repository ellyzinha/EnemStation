package br.ifpe.web.projeto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.ifpe.web.projeto2.DAO.QuestoesDAO;
import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.Questoes;
import br.ifpe.web.projeto2.exceptions.EnunciadoExistsException;
import br.ifpe.web.projeto2.exceptions.TituloExistsException;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class QuestoesService {
	
	@Autowired
	private QuestoesDAO questoesDAO; 
	
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
	
	public Questoes findQuestoesByEnunciado(String enunciado) {
		return questoesDAO.findByEnunciado(enunciado);
	}
	
	public Questoes findById(Integer id) {
		return questoesDAO.findById(id).orElse(null);
	}
	
	public List<Questoes> listarTodos() {
		return questoesDAO.findAll();
	}

	public Questoes getOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Questoes> findQuestoesByAssunto(Assunto assunto){
		return questoesDAO.findByAssunto(assunto);
	}
		
}
