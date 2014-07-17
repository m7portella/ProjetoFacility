package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Cep;

public interface CepDAO extends DAO<Cep, Integer> {

	List<Cep> listarCep(String nroCep);
}
