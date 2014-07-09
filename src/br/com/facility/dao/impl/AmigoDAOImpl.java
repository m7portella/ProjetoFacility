package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.to.Amigo;
import br.com.facility.to.AmigoPK;

public class AmigoDAOImpl extends DAOImpl<Amigo, AmigoPK>{

	public AmigoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
