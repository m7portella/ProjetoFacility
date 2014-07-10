package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.TelefoneDAO;
import br.com.facility.to.Telefone;
import br.com.facility.to.TelefonePK;

public class TelefoneDAOImpl extends DAOImpl<Telefone, TelefonePK> implements TelefoneDAO {

	public TelefoneDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
