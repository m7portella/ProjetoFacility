/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoIdiomaDAO;
import br.com.facility.dao.impl.CurriculoIdiomaDAOImpl;
import br.com.facility.to.CurriculoIdioma;

/**
 * @author Andersson
 * 
 * Data: 17/07/2014
 *
 */
public class CurriculoIdiomaBO {

	private EntityManager em;
	private CurriculoIdiomaDAO iDAO;
	
	public CurriculoIdiomaBO(EntityManager e) {
		em = e;
		iDAO = new CurriculoIdiomaDAOImpl(em);
	}
	
	public void cadastrar(CurriculoIdioma i) {
		iDAO.insert(i);
	}
	
	public void remover(CurriculoIdioma i) {
		iDAO.remove(i);
	}
	
	public void alterar(CurriculoIdioma i) {
		iDAO.update(i);
	}
	
	public CurriculoIdioma consultar(Integer id) {
		CurriculoIdioma i = iDAO.searchByID(id);
		return i;
	}
	
}
