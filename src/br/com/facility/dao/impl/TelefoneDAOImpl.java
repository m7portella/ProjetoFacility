package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.TelefoneDAO;
import br.com.facility.to.Telefone;
import br.com.facility.to.TelefonePK;
import br.com.facility.to.Usuario;

public class TelefoneDAOImpl extends DAOImpl<Telefone, TelefonePK> implements TelefoneDAO {

	public TelefoneDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Telefone> buscarPorUsuario(Usuario usuario) {
		
		TypedQuery<Telefone> query = em.createQuery("SELECT t FROM Telefone t WHERE t.usuario = :p", Telefone.class);
		query.setParameter("p", usuario);
		
		return query.getResultList();
	}

}
