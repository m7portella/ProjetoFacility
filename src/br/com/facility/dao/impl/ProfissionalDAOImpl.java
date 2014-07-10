package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.to.Profissional;

public class ProfissionalDAOImpl extends DAOImpl<Profissional, Integer> implements ProfissionalDAO{

	public ProfissionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
