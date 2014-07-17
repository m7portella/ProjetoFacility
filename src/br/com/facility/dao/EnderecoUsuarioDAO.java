package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.EnderecoUsuarioPK;
import br.com.facility.to.Usuario;

public interface EnderecoUsuarioDAO extends DAO<EnderecoUsuario, EnderecoUsuarioPK>{

	List<EnderecoUsuario> listaPorUsuario(Usuario usuario);
}
