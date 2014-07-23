package br.com.facility.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.ServicoConcluidoDAO;
import br.com.facility.to.Negociacao;
import br.com.facility.to.ServicoConcluido;
import br.com.facility.to.ServicoConcluidoPK;

public class ServicoConcluidoDAOImpl extends
		DAOImpl<ServicoConcluido, ServicoConcluidoPK> implements
		ServicoConcluidoDAO {

	public ServicoConcluidoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public ServicoConcluido consultaPorNegociacao(Negociacao n) {
		Query q = em.createQuery(
				"from ServicoConcluido sc where negociacao = :n").setParameter(
				"n", n);
		ServicoConcluido sc = (ServicoConcluido) q.getSingleResult();
		return sc;
	}

}
