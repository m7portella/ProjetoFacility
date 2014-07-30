/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoURLDAO;
import br.com.facility.to.CurriculoURL;


public class CurriculoURLDAOImpl extends DAOImpl<CurriculoURL, Integer> implements CurriculoURLDAO {

	public CurriculoURLDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
}
