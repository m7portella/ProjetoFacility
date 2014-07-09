package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.UsuarioDAO;
import br.com.facility.to.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

}
