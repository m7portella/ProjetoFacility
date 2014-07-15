package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.ProjetoDAO;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class ProjetoDAOImpl extends DAOImpl<Projeto, Long> implements ProjetoDAO{

	public ProjetoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Projeto> listarPorUsuario(Usuario u) {
		Query q = em.createQuery("from Projeto n where usuario = :u").setParameter("u", u);
		return q.getResultList();
	}

}
