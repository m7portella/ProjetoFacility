/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoIdiomaDAO;
import br.com.facility.to.CurriculoIdioma;

/**
 * @author Andersson
 * 
 * Data:16/07/2014
 *
 */
public class CurriculoIdiomaDAOImpl extends DAOImpl<CurriculoIdioma, Integer> implements CurriculoIdiomaDAO {

	public CurriculoIdiomaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

}
