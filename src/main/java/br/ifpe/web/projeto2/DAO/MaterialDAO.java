package br.ifpe.web.projeto2.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ifpe.web.projeto2.Model.Material;

@Repository
public interface MaterialDAO extends JpaRepository<Material, Integer> {

	//CONSULTANDO NOME DO MATERIAL
	@Query("select m from Material m where m.titulo = :titulo")
	public Material findByNomeMaterial(String titulo);
}
