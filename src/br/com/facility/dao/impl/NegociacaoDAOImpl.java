package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.NegociacaoDAO;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class NegociacaoDAOImpl extends DAOImpl<Negociacao, Long> implements NegociacaoDAO{

	public NegociacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negociacao> listaPorUsuario(Usuario u) {
		Query q = em.createQuery("from Negociacao n where usuario = :u").setParameter("u", u);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Negociacao> listaPorProfissional(Profissional p) {
		Query q = em.createQuery("from Negociacao n where profissional = :p").setParameter("p", p);
		return q.getResultList();
	}

}