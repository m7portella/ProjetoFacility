package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.ClienteJuridicoDAO;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Usuario;

public class ClienteJuridicoDAOImpl extends DAOImpl<ClienteJuridico, Usuario> implements ClienteJuridicoDAO{

	public ClienteJuridicoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
