package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.FeedbackUsuarioDAO;
import br.com.facility.to.FeedbackUsuario;


public class FeedbackUsuarioDAOImpl extends DAOImpl<FeedbackUsuario, Integer>
									implements FeedbackUsuarioDAO{

	public FeedbackUsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
