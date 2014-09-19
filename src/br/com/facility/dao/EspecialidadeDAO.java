package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;
import br.com.facility.to.Especialidade;

public interface EspecialidadeDAO extends DAO<Especialidade, Integer> {

	List<Especialidade> listarTodos();
	
	List<Especialidade> listarPorAtividade(Atividade a);
	
}
