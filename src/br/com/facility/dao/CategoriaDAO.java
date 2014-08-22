package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Categoria;

public interface CategoriaDAO extends DAO<Categoria, Integer> {

	List<Categoria> listar();
	
}
