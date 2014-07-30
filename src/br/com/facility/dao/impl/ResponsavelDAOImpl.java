/**
 * 
 */
package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.ResponsavelDAO;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;
import br.com.facility.to.ResponsavelPK;

public class ResponsavelDAOImpl extends DAOImpl<Responsavel, ResponsavelPK> implements ResponsavelDAO {

	public ResponsavelDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

	@Override
	public Responsavel consultaPorClienteJuridico(ClienteJuridico cj) {
		Query q = em.createQuery(
				"from Responsavel r where clienteJuridico = :cj").setParameter(
				"cj", cj);
		Responsavel r = (Responsavel) q.getSingleResult();
		return r;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Responsavel> listarPorCliente(ClienteJuridico cj) {
		Query q = em.createQuery("from Responsavel r where clienteJuridico = :cj").setParameter("cj", cj);
		return q.getResultList();
	}
	
}
