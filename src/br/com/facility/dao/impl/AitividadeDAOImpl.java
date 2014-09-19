package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;


public class AitividadeDAOImpl extends DAOImpl<Atividade, Integer> implements AtividadeDAO{

	public AitividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> listarTodos() {
		Query q = em.createQuery("from Atividade");
		List<Atividade> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> listarPorCategoria(Categoria c) {
		Query q = em.createQuery("from Atividade where categoria = :c").setParameter("c", c);
		List<Atividade> lista = q.getResultList();
		return lista;
	}
	
}
