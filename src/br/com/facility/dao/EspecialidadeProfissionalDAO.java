package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.EspecialidadeProfissionalPK;
import br.com.facility.to.Profissional;

public interface EspecialidadeProfissionalDAO extends DAO<EspecialidadeProfissional, EspecialidadeProfissionalPK>{

	public List<EspecialidadeProfissional> listarPorProfissional(Profissional p);
	
	public List<EspecialidadeProfissional> listarPorEspecialidade(Especialidade e);
	
}
