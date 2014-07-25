/**
 * 
 */
package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.CurriculoDAO;
import br.com.facility.dao.CurriculoFormacaoDAO;
import br.com.facility.dao.CurriculoIdiomaDAO;
import br.com.facility.dao.CurriculoImagemDAO;
import br.com.facility.dao.CurriculoURLDAO;
import br.com.facility.dao.impl.CurriculoDAOImpl;
import br.com.facility.dao.impl.CurriculoFormacaoDAOImpl;
import br.com.facility.dao.impl.CurriculoIdiomaDAOImpl;
import br.com.facility.dao.impl.CurriculoImagemDAOImpl;
import br.com.facility.dao.impl.CurriculoURLDAOImpl;
import br.com.facility.to.Curriculo;
import br.com.facility.to.CurriculoFormacao;
import br.com.facility.to.CurriculoIdioma;
import br.com.facility.to.CurriculoImagem;
import br.com.facility.to.CurriculoURL;

/**
 * @author Andersson
 *
 * Data: 17/07/2014
 *
 */
public class CurriculoBO {

	
	private EntityManager em;
	private CurriculoDAO cDAO;
	private CurriculoFormacaoDAO cfDAO;
	private CurriculoIdiomaDAO iDAO;
	private CurriculoImagemDAO imDAO;
	private CurriculoURLDAO urlDAO;
	
	public CurriculoBO(EntityManager e) {
		em = e;
		cDAO = new CurriculoDAOImpl(em);
		cfDAO = new CurriculoFormacaoDAOImpl(em);
		iDAO = new CurriculoIdiomaDAOImpl(em);
		imDAO = new CurriculoImagemDAOImpl(em);
		urlDAO = new CurriculoURLDAOImpl(em);
	}
	
	public void cadastrarCurriculo(Curriculo c) {
		cDAO.insert(c);
	}
	
	public void removerCurriculo(Curriculo c) {
		cDAO.remove(c);
	}
	
	public void alterarCurriculo(Curriculo c) {
		cDAO.update(c);
	}
	
	public Curriculo consultarCurriculo(Integer id) {
		Curriculo c = cDAO.searchByID(id);
		return c;
	}
	
	public void cadastrarCFormacao(CurriculoFormacao cf) {
		
		cfDAO.insert(cf);
	}
	
	public void removerCFormacao(CurriculoFormacao cf) {
		cfDAO.remove(cf);
	}
	
	public void alterarCFormacao(CurriculoFormacao cf) {
		cfDAO.update(cf);
	}
	
	
	public void cadastrarCIdioma(CurriculoIdioma i) {
		iDAO.insert(i);
	}
	
	public void removerCIdioma(CurriculoIdioma i) {
		iDAO.remove(i);
	}
	
	public void alterarCIdioma(CurriculoIdioma i) {
		iDAO.update(i);
	}

	
	public void cadastrarCImagem(CurriculoImagem im) {
		imDAO.insert(im);
	}
	
	public void removerCImagem(CurriculoImagem im) {
		imDAO.remove(im);
	}
	
	public void alterarCImagem(CurriculoImagem im) {
		imDAO.update(im);
	}
	

	public void cadastrarCUrl(CurriculoURL url) {
		urlDAO.insert(url);
	}
	
	public void removerCUrl(CurriculoURL url) {
		urlDAO.remove(url);
	}
	
	public void alterarCUrl(CurriculoURL url) {
		urlDAO.update(url);
	}
	
}
