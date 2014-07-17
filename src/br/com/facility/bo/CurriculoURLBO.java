/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoURLDAO;
import br.com.facility.dao.impl.CurriculoURLDAOImpl;
import br.com.facility.to.CurriculoURL;

/**
 * @author Andersson
 *
 * Data: 17/07/2014
 *
 */
public class CurriculoURLBO {

	private EntityManager em;
	private CurriculoURLDAO urlDAO;
	
	public CurriculoURLBO(EntityManager e) {
		em = e;
		urlDAO = new CurriculoURLDAOImpl(em);
	}
	
	public void cadastrar(CurriculoURL url) {
		urlDAO.insert(url);
	}
	
	public void remover(CurriculoURL url) {
		urlDAO.remove(url);
	}
	
	public void alterar(CurriculoURL url) {
		urlDAO.update(url);
	}
	
	public CurriculoURL consultar(Integer id) {
		CurriculoURL url = urlDAO.searchByID(id);
		return url;
	}
	
}
