package br.ifpe.web.projeto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web.projeto2.DAO.PlanoEstudoDAO;
import br.ifpe.web.projeto2.Model.Assunto;
import br.ifpe.web.projeto2.Model.PlanoEstudo;
import br.ifpe.web.projeto2.Model.Usuario;

@Service
public class PlanoEstudoService {

	@Autowired
	private PlanoEstudoDAO planoEstudoDAO;
	
	public void criarPlano(PlanoEstudo planoEstudo) {
		planoEstudoDAO.save(planoEstudo);
	}
	
	public List<PlanoEstudo> listaPlano(String diadasemana, Usuario usuario) {
		return planoEstudoDAO.planoEstudo(diadasemana, usuario);
	}
	
	public List<Assunto> listaAssunto(Integer id_disciplina){
		return planoEstudoDAO.listaAssunto(id_disciplina);
	}

	public List<PlanoEstudo> findAll(){
		return planoEstudoDAO.findAll();
	}
	
	public void save( PlanoEstudo planoEstudo){
		planoEstudoDAO.save(planoEstudo);
	}
	
	public PlanoEstudo getOne(Integer id) {
		return planoEstudoDAO.getOne(id);
	}
	
	public void deleteById(Integer id) {
		planoEstudoDAO.deleteById(id);
	}
}
