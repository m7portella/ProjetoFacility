package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public interface ProjetoDAO extends DAO<Projeto, Long>{
	
	public List<Projeto> listarPorUsuario(Usuario u);
	
}
