/**
 * 
 */
package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.ResponsavelDAO;
import br.com.facility.enums.HierarquiaResponsavel;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;

/**
 * @author Andersson
 * 
 * Data:16/07/2014
 *
 */
public class ResponsavelDAOImpl extends DAOImpl<Responsavel, Integer> implements ResponsavelDAO {

	public ResponsavelDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Responsavel> listarPorCliente(ClienteJuridico cj) {
		Query q = em.createQuery("from Responsavel r where clienteJuridico = :cj").setParameter("cj", cj);
		return q.getResultList();
	}

	@Override
	public HierarquiaResponsavel consultarResponsavelPrincipal(HierarquiaResponsavel h){
		
		Query q = em.createQuery("from Responsavel r where hierarquia = :h").setParameter("h", h);
		return (HierarquiaResponsavel) q.getSingleResult();
	}
	
	
}
