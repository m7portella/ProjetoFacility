package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.to.Atividade;


public class AitividadeDAOImpl extends DAOImpl<Atividade, Integer> implements AtividadeDAO{

	public AitividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	
}
