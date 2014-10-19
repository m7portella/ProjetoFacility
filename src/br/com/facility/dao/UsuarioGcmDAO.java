package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Usuario;
import br.com.facility.to.UsuarioGCM;
import br.com.facility.to.UsuarioGcmPK;

public interface UsuarioGcmDAO extends DAO<UsuarioGCM, UsuarioGcmPK>{

	public List<UsuarioGCM> listarPorUsuario(Usuario u);
	
	public List<UsuarioGCM> listar();
	
}
