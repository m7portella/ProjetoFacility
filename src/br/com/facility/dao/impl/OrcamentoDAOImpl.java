package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.OrcamentoDAO;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoPK;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class OrcamentoDAOImpl extends DAOImpl<Orcamento, OrcamentoPK> implements OrcamentoDAO{

	public OrcamentoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orcamento> listaPorNegociacao(Negociacao n) {
		Query q = em.createQuery("from Orcamento o where negocicao = :n").setParameter("n", n);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orcamento> listaPorUsuario(Usuario u) {
		Query q = em.createQuery("from Orcamento o where usuario = :u").setParameter("u", u);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Orcamento> listaPorProfissional(Profissional p) {
		Query q = em.createQuery("from Orcamento o where profissional = :p").setParameter("p", p);
		return q.getResultList();
	}

}
