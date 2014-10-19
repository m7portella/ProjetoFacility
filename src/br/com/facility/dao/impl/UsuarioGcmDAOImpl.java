package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.UsuarioGcmDAO;
import br.com.facility.to.Usuario;
import br.com.facility.to.UsuarioGCM;
import br.com.facility.to.UsuarioGcmPK;

public class UsuarioGcmDAOImpl extends DAOImpl<UsuarioGCM, UsuarioGcmPK> implements UsuarioGcmDAO{

	public UsuarioGcmDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}
	
	@SuppressWarnings("unchecked")
	public List<UsuarioGCM> listarPorUsuario(Usuario u){
		Query q = em.createQuery("from UsuarioGCM where usuario = :u").setParameter("u", u);
		List<UsuarioGCM> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsuarioGCM> listar() {
		Query q = em.createQuery("from UsuarioGCM");
		List<UsuarioGCM> lista = q.getResultList();
		return lista;
	};

}
