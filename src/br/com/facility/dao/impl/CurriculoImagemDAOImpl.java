/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoImagemDAO;
import br.com.facility.to.CurriculoImagem;


public class CurriculoImagemDAOImpl extends DAOImpl<CurriculoImagem, Integer> implements CurriculoImagemDAO {

	public CurriculoImagemDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

}
