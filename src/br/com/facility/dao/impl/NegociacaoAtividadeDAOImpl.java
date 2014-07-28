package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.NegociacaoAtividadeDAO;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.NegociacaoAtividadePK;

public class NegociacaoAtividadeDAOImpl extends DAOImpl<NegociacaoAtividade, NegociacaoAtividadePK> implements NegociacaoAtividadeDAO {

	public NegociacaoAtividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
