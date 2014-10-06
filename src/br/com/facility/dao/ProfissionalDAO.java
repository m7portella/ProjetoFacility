package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Profissional;

public interface ProfissionalDAO extends DAO<Profissional, Integer>{

	List<Profissional> listar();
	
}
