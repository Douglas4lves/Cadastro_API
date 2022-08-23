package br.com.criandoapi.projetoApitesteback.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.criandoapi.projetoApitesteback.model.Usuario;

public interface InterfaceUsuario extends JpaRepository<Usuario, Integer> {

}
