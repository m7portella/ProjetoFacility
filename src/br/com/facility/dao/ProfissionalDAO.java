package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Profissional;

public interface ProfissionalDAO extends DAO<Profissional, Integer>{

	List<Profissional> listar();
	List<Profissional> buscarProfissionalPorNome(String nome);
	List<Profissional> buscarProfissionalPorCidade(String cidade);
	List<Profissional> buscarProfissionalPorCategoria(Categoria categoria);
	List<Profissional> buscarProfissionalPorAtividade(Atividade atividade);
	List<Profissional> buscarProfissionalPorEspecialidade(Especialidade especialidade);
}
