package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.LocalAtendimentoDAO;
import br.com.facility.to.LocalAtendimento;

public class LocalAtendimentoDAOImpl extends DAOImpl<LocalAtendimento, Integer> implements LocalAtendimentoDAO{

	public LocalAtendimentoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<LocalAtendimento> listarTodos() {
		TypedQuery<LocalAtendimento> query = em.createQuery("FROM LocalAtendimento", LocalAtendimento.class);
		return query.getResultList();
	}

	@Override
	public List<LocalAtendimento> listarPorCidade(String estado, String cidade) {
		TypedQuery<LocalAtendimento> query = em.createQuery("FROM LocalAtendimento l WHERE l.estado LIKE :p1 AND l.cidade LIKE :p2", LocalAtendimento.class);
		query.setParameter("p1", estado);
		query.setParameter("p2", cidade);
		return query.getResultList();
	}

	@Override
	public List<LocalAtendimento> listarPorEstado(String estado) {
		TypedQuery<LocalAtendimento> query = em.createQuery("FROM LocalAtendimento l WHERE l.estado LIKE :p", LocalAtendimento.class);
		query.setParameter("p", estado);
		return query.getResultList();
	}

}
