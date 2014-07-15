package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;

public interface AtividadeDAO extends DAO<Atividade, Integer> {

	List<Atividade> listarTodos();

}
