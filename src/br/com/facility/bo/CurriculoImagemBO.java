/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoImagemDAO;
import br.com.facility.dao.impl.CurriculoImagemDAOImpl;
import br.com.facility.to.CurriculoImagem;

/**
 * @author Andersson
 * 
 * Data: 17/07/2014
 *
 */
public class CurriculoImagemBO {

	private EntityManager em;
	private CurriculoImagemDAO imDAO;
	
	public CurriculoImagemBO(EntityManager e) {
		em = e;
		imDAO = new CurriculoImagemDAOImpl(em);
	}
	
	public void cadastrar(CurriculoImagem im) {
		imDAO.insert(im);
	}
	
	public void remover(CurriculoImagem im) {
		imDAO.remove(im);
	}
	
	public void alterar(CurriculoImagem im) {
		imDAO.update(im);
	}
	
	public CurriculoImagem consultar(Integer id) {
		CurriculoImagem im = imDAO.searchByID(id);
		return im;
	}
	
}
