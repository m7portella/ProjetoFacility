/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoDAO;
import br.com.facility.to.Curriculo;

/**
 * @author Andersson
 * 
 * Data:16/07/2014
 *
 */
public class CurriculoDAOImpl extends DAOImpl<Curriculo, Integer> implements CurriculoDAO {

	public CurriculoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
}
