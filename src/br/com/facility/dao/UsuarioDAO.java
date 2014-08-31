package br.com.facility.dao;

import br.com.facility.to.Usuario;

public interface UsuarioDAO extends DAO<Usuario, Integer> {

	Usuario buscarPorUsername(String username);
	
}
