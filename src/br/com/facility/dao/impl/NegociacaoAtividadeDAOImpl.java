package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.NegociacaoAtividadeDAO;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.NegociacaoAtividadePK;

public class NegociacaoAtividadeDAOImpl extends DAOImpl<NegociacaoAtividade, NegociacaoAtividadePK> implements NegociacaoAtividadeDAO {

	public NegociacaoAtividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<NegociacaoAtividade> listaPorNegociacao(Negociacao negociacao) {
		TypedQuery<NegociacaoAtividade> query = em.createQuery("FROM NegociacaoAtividade WHERE negociacao = :p", NegociacaoAtividade.class);
		query.setParameter("p", negociacao);
		return query.getResultList();
	}

}
