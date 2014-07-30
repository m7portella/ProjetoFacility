/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoDAO;
import br.com.facility.to.Curriculo;


public class CurriculoDAOImpl extends DAOImpl<Curriculo, Integer> implements CurriculoDAO {

	public CurriculoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
}
