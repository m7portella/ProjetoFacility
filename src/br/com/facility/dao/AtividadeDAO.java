package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;

public interface AtividadeDAO extends DAO<Atividade, Integer> {

	List<Atividade> listarTodos();
	
	List<Atividade> listarPorCategoria(Categoria c);

}
