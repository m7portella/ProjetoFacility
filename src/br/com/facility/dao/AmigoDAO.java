package br.com.facility.dao;

import java.util.List;

import javax.persistence.Query;

import br.com.facility.to.Amigo;
import br.com.facility.to.AmigoPK;
import br.com.facility.to.Usuario;

public interface AmigoDAO extends DAO<Amigo, AmigoPK>{
	
	public List<Amigo> listarAmigos(Usuario u);
}
