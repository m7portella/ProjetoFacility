package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.LocalAtendimento;

public interface LocalAtendimentoDAO extends DAO<LocalAtendimento, Integer>{
	
	List<LocalAtendimento> listarTodos();
	
	List<LocalAtendimento> listarPorCidade(String estado, String cidade);
	
	List<LocalAtendimento> listarPorEstado(String estado);
}
