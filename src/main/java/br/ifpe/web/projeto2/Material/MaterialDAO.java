package br.ifpe.web.projeto2.Material;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface MaterialDAO extends JpaRepository<Material, Integer> {

	//CONSULTANDO NOME DO MATERIAL
	@Query("select m from Material m where m.titulo = :titulo")
	public Material findByNomeMaterial(String titulo);
	
	//CONSULTANDO QUANTIDADE DE MATERIAIS 
		@Query("select count(m) from Material m")
		public Integer findByQuantidadeMaterial();
	
	//CONSULTANDO MATERIAL POR DISCIPLINA
	@Query("select m from Material m where m.disciplina = :id")
	public List<Material> findByMaterial(Integer id);
}