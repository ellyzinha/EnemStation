package br.ifpe.web.projeto2.service;

import java.util.List;

import br.ifpe.web.projeto2.exceptions.HorarioExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web.projeto2.DAO.PlanoEstudoDAO;
import br.ifpe.web.projeto2.Model.PlanoEstudo;
import br.ifpe.web.projeto2.Model.Usuario;

@Service
public class PlanoEstudoService {

	@Autowired
	private PlanoEstudoDAO planoEstudoDAO;
	
	public void criarPlano(PlanoEstudo planoEstudo) throws Exception {
		if (this.findByHorario(planoEstudo.getHorarioInicio(),planoEstudo.getHorarioFinal(), planoEstudo.getDiadasemana()) != null){
			throw new HorarioExistsException(" Já existe este horário cadastrado na " + planoEstudo.getDiadasemana());
		}
		planoEstudoDAO.save(planoEstudo);
	}

	public PlanoEstudo findByHorario(String horarioInicio,String horarioFinal,String diadasemana){
		return planoEstudoDAO.findByHorarioInicioeFinal(horarioInicio,horarioFinal,diadasemana);

	}

	
	public List<PlanoEstudo> listaPlano(String diadasemana, Usuario usuario) {
		return planoEstudoDAO.planoEstudo(diadasemana, usuario);
	}
	
	//public List<Assunto> listaAssunto(Integer id_disciplina){
	///	return planoEstudoDAO.listaAssunto(id_disciplina);
	//}

	public List<PlanoEstudo> findAll(){
		return planoEstudoDAO.findAll();
	}
	
	public void save(PlanoEstudo planoEstudo) {
		planoEstudoDAO.save(planoEstudo);
	}
	
	public PlanoEstudo getOne(Integer id) {
		return planoEstudoDAO.getOne(id);
	}
	
	public void deleteById(Integer id) {
		planoEstudoDAO.deleteById(id);
	}
}
