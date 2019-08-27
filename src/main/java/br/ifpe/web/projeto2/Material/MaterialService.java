package br.ifpe.web.projeto2.Material;

import java.util.List;

import br.ifpe.web.projeto2.exceptions.EmailExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifpe.web.projeto2.DAO.DisciplinaDAO;
import br.ifpe.web.projeto2.Model.Disciplina;

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
	
	public List<Material> listarMaterial(Integer id){
		return materialDAO.findByMaterial(id);
	}
	
	public String titulo(Integer id){
		return materialDAO.findByTitulo(id);
	}
	
	public List<Material> listarMaterial1(){
		return materialDAO.findAll();
	}
	
	public Integer quantidades(Integer codigo){
		return (int) materialDAO.findByQuantidadeMaterial(codigo);
	}
	
	
	//BUSCANDO TODOS OS DISCIPLINAS
	public List<Disciplina> listarDisciplinas(){
		return disciplinaDAO.findAll();
	}
}
