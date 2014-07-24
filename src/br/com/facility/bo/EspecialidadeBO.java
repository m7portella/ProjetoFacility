package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.EspecialidadeDAO;
import br.com.facility.dao.impl.EspecialidadeDAOImpl;
import br.com.facility.to.Especialidade;

public class EspecialidadeBO {

	private EntityManager em;
	private EspecialidadeDAO eDAO;
	
	public EspecialidadeBO(EntityManager e) {
		em = e;
		eDAO = new EspecialidadeDAOImpl(em);
	}
	
	public void incluir(Especialidade esp) {
		eDAO.insert(esp);
	}
	
	public void alterar(Especialidade esp) {
		eDAO.update(esp);
	}
	
	public Especialidade consultar(Integer id) throws Exception {
		return eDAO.searchByID(id);
	}
	
	public void excluir(Especialidade esp) {
		eDAO.remove(esp);
	}
	
	public List<Especialidade> listarTodos() {
		return eDAO.listarTodos();
	}
}
