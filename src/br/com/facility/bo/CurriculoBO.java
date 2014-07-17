/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoDAO;
import br.com.facility.dao.impl.CurriculoDAOImpl;
import br.com.facility.to.Curriculo;

/**
 * @author Andersson
 *
 * Data: 17/07/2014
 *
 */
public class CurriculoBO {

	
	private EntityManager em;
	private CurriculoDAO cDAO;
	
	public CurriculoBO(EntityManager e) {
		em = e;
		cDAO = new CurriculoDAOImpl(em);
	}
	
	public void cadastrar(Curriculo c) {
		cDAO.insert(c);
	}
	
	public void remover(Curriculo c) {
		cDAO.remove(c);
	}
	
	public void alterar(Curriculo c) {
		cDAO.update(c);
	}
	
	public Curriculo consultar(Integer id) {
		Curriculo c = cDAO.searchByID(id);
		return c;
	}
	
	
}
