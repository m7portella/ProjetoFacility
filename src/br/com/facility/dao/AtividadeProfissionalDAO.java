package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.AtividadeProfissionalPK;
import br.com.facility.to.Profissional;

public interface AtividadeProfissionalDAO extends DAO<AtividadeProfissional, AtividadeProfissionalPK>{
	
	public List<AtividadeProfissional> listarPorProfissional(Profissional p);
	
	public List<AtividadeProfissional> listarPorAtividade(Atividade a);

}
