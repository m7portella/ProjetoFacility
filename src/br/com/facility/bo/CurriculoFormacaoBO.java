/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoFormacaoDAO;
import br.com.facility.dao.impl.CurriculoFormacaoDAOImpl;
import br.com.facility.to.CurriculoFormacao;

/**
 * @author Andersson
 * 
 * Data: 17/07/2014
 *
 */
public class CurriculoFormacaoBO {

	private EntityManager em;
	private CurriculoFormacaoDAO cfDAO;
	
	public CurriculoFormacaoBO(EntityManager e) {
		em = e;
		cfDAO = new CurriculoFormacaoDAOImpl(em);
	}
	
	public void cadastrar(CurriculoFormacao cf) {
		cfDAO.insert(cf);
	}
	
	public void remover(CurriculoFormacao cf) {
		cfDAO.remove(cf);
	}
	
	public void alterar(CurriculoFormacao cf) {
		cfDAO.update(cf);
	}
	
	public CurriculoFormacao consultar(Integer id) {
		CurriculoFormacao cf = cfDAO.searchByID(id);
		return cf;
	}
	
}
