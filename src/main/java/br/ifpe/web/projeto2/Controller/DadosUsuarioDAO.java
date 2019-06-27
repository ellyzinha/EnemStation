package br.ifpe.web.projeto2.Controller;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosUsuarioDAO extends JpaRepository<DadosUsuario, Integer> {

}
