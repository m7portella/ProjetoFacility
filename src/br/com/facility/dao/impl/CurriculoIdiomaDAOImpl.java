/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoIdiomaDAO;
import br.com.facility.to.CurriculoIdioma;


public class CurriculoIdiomaDAOImpl extends DAOImpl<CurriculoIdioma, Integer> implements CurriculoIdiomaDAO {

	public CurriculoIdiomaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

}
