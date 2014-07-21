package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.PagamentoDAO;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Pagamento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class PagamentoDAOImpl extends DAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager entityManager) {
		super(entityManager);	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagamento> listaPorNegociacao(Negociacao n) {
		Query q = em.createQuery("from Pagamento p where negociacao = :n").setParameter("n", n);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagamento> listaPorUsuario(Usuario u) {
		Query q = em.createQuery("from Pagamento p where usuario = :u").setParameter("u", u);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pagamento> listaPorProfissional(Profissional p) {
		Query q = em.createQuery("from Pagamento p where profissional = :p").setParameter("p", p);
		return q.getResultList();
	}
	

}
