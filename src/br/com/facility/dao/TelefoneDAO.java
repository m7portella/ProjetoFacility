package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Telefone;
import br.com.facility.to.TelefonePK;
import br.com.facility.to.Usuario;

public interface TelefoneDAO extends DAO<Telefone, TelefonePK> {

	List<Telefone> buscarPorUsuario(Usuario usuario);
	
}
