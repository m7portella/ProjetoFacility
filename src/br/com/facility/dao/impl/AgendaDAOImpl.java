package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AgendaDAO;
import br.com.facility.to.Agenda;
import br.com.facility.to.AgendaPK;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class AgendaDAOImpl extends DAOImpl<Agenda, AgendaPK> implements AgendaDAO{

	public AgendaDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agenda> listaPorNegociacao(Negociacao n) {
		Query q = em.createQuery("from Agenda a where negociacao = :n").setParameter("n", n);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agenda> listaPorUsuario(Usuario u) {
		Query q = em.createQuery("from Agenda a where usuario = :u").setParameter("u", u);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Agenda> listaPorProfissional(Profissional p) {
		Query q = em.createQuery("from Agenda a where profissional = :p").setParameter("p", p);
		return q.getResultList();
	}

	
	
}
