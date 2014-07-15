package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.to.Atividade;


public class AitividadeDAOImpl extends DAOImpl<Atividade, Integer> implements AtividadeDAO{

	public AitividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> listarTodos() {
		Query q = em.createQuery("from Atividade");
		List<Atividade> lista = q.getResultList();
		return lista;
	}
	
}
