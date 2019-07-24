package br.ifpe.web.projeto2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web.projeto2.DAO.DisciplinaDAO;
import br.ifpe.web.projeto2.DAO.MaterialDAO;
import br.ifpe.web.projeto2.Model.Disciplina;
import br.ifpe.web.projeto2.Model.Material;
import br.ifpe.web2.excecoes.EmailExistsException;

@Service
public class MaterialService {

	@Autowired
	private MaterialDAO materialDAO;
	
	@Autowired
	private DisciplinaDAO disciplinaDAO;
	
	public Material findByNomeMaterial(String titulo) {
		return materialDAO.findByNomeMaterial(titulo);
	}
	
	//SALVANDO MATERIAIS NO BANCO
	public void salvando(Material material) throws Exception {
		
		//VERIFICANDO SE EXISTE ALGUM MATERIAL COM O NOME INFORMADO
		if(this.findByNomeMaterial(material.getTitulo()) !=null) {
			throw new EmailExistsException
				("Já existe material com esse titulo: "+material.getTitulo());
		}
		materialDAO.save(material);
		
	}
	
	
	
	//BUSCANDO TODOS OS DISCIPLINAS
	public List<Disciplina> listarDisciplinas(){
		return disciplinaDAO.findAll();
	}
}
