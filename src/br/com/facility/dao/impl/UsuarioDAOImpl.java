package br.com.facility.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.UsuarioDAO;
import br.com.facility.to.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Usuario buscarPorUsername(String user) {
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u WHERE u.username LIKE :p1", Usuario.class);
		query.setParameter("p1", user);
		try{
			return query.getSingleResult();
		}catch(Exception e){
			return null;
		}
	}
	
	
	@Override
	public Usuario buscarPorEmail(String email) {
		TypedQuery<Usuario> query = em.createQuery("FROM Usuario u WHERE u.email LIKE :p1", Usuario.class);
		query.setParameter("p1", email);
		try{
			return query.getSingleResult();
		}catch(Exception e){
			return null;
		}
	}
}
