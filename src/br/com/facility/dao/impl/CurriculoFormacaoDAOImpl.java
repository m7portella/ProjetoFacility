/**
 * 
 */
package br.com.facility.dao.impl;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoFormacaoDAO;
import br.com.facility.to.CurriculoFormacao;


public class CurriculoFormacaoDAOImpl extends DAOImpl<CurriculoFormacao, Integer> implements CurriculoFormacaoDAO {

	public CurriculoFormacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}
	
}
