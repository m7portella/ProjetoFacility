package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.MensagemDAO;
import br.com.facility.to.Mensagem;
import br.com.facility.to.MensagemPK;
import br.com.facility.to.Negociacao;

public class MensagemDAOImpl extends DAOImpl<Mensagem, MensagemPK> implements MensagemDAO{

	public MensagemDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mensagem> listaPorNegociacao(Negociacao n) {
		Query q = em.createQuery("from Mensagem m where negociacao = :n").setParameter("n", n);
		return q.getResultList();
	}

}
