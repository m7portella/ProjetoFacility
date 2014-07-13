package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.ClienteJuridicoDAO;
import br.com.facility.to.ClienteJuridico;

public class ClienteJuridicoDAOImpl extends DAOImpl<ClienteJuridico, Integer> implements ClienteJuridicoDAO{

	public ClienteJuridicoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
