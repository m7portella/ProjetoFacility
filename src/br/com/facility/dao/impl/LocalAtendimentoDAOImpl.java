package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.LocalAtendimentoDAO;
import br.com.facility.to.LocalAtendimento;

public class LocalAtendimentoDAOImpl extends DAOImpl<LocalAtendimento, Integer> implements LocalAtendimentoDAO{

	public LocalAtendimentoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
