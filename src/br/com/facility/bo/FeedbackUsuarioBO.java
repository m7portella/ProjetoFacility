package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.FeedbackUsuarioDAO;
import br.com.facility.dao.impl.AmigoDAOImpl;
import br.com.facility.dao.impl.FeedbackUsuarioDAOImpl;
import br.com.facility.to.FeedbackUsuario;

public class FeedbackUsuarioBO {

	private EntityManager em;
	private FeedbackUsuarioDAO fDAO;

	public FeedbackUsuarioBO(EntityManager e) {
		em = e;
		fDAO = new FeedbackUsuarioDAOImpl(em);
	}
	
	public void cadastrar(FeedbackUsuario f) {
		fDAO.insert(f);
	}
	
	public void remover(Integer id) {
		fDAO.removeById(id);
	}
	
	public FeedbackUsuario consultar(Integer id) {
		return fDAO.searchByID(id);
	}
}
