package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.ClienteFisicoDAO;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.Usuario;

public class ClienteFisicoDAOImpl extends DAOImpl<ClienteFisico, Usuario> implements ClienteFisicoDAO{

	public ClienteFisicoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
