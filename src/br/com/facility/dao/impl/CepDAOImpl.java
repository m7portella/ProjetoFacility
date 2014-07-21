package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.CepDAO;
import br.com.facility.to.Cep;

public class CepDAOImpl extends DAOImpl<Cep, Integer> implements CepDAO {

	public CepDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Cep> listarCep(String nroCep) {
		TypedQuery<Cep> query = em.createQuery("FROM Cep WHERE numero = :p", Cep.class);
		query.setParameter("p", nroCep);
		return query.getResultList();
	}

}
