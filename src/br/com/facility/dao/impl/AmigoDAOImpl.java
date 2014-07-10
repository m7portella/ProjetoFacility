package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AmigoDAO;
import br.com.facility.to.Amigo;
import br.com.facility.to.AmigoPK;
import br.com.facility.to.Usuario;

public class AmigoDAOImpl extends DAOImpl<Amigo, AmigoPK> implements AmigoDAO{

	public AmigoDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Amigo> listarAmigos(Usuario u) {
		Query q = em.createQuery("from Amigo a where a.usuario = :u").setParameter("u", u);
		List<Amigo> lista = q.getResultList();
		return lista;
	}
	

}
