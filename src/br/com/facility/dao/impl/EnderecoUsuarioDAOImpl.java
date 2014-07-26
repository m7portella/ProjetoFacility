package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.EnderecoUsuarioDAO;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.EnderecoUsuarioPK;
import br.com.facility.to.Usuario;

public class EnderecoUsuarioDAOImpl extends DAOImpl<EnderecoUsuario, EnderecoUsuarioPK> implements EnderecoUsuarioDAO {

	public EnderecoUsuarioDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<EnderecoUsuario> listaPorUsuario(Usuario usuario) {
		TypedQuery<EnderecoUsuario> query = em.createQuery("FROM EnderecoUsuario e WHERE e.usuario = :p", EnderecoUsuario.class);
		query.setParameter("p", usuario);
		return query.getResultList();
	}
	
	

}
