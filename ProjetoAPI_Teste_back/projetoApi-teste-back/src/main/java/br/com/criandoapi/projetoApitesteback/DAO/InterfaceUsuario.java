package br.com.criandoapi.projetoApitesteback.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.criandoapi.projetoApitesteback.model.Usuario;

public interface InterfaceUsuario extends CrudRepository<Usuario, Integer> {

}
