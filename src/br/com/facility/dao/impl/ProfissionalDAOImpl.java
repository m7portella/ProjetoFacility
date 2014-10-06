package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.to.Profissional;

public class ProfissionalDAOImpl extends DAOImpl<Profissional, Integer> implements ProfissionalDAO{

	public ProfissionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@Override
	public List<Profissional> listar() {
		Query q = em.createQuery("from Profissional");
		List<Profissional> lista = q.getResultList();
		return lista;
	}

}
