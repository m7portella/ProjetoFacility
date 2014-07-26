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
	
	public void cadastrar(Especialidade esp) {
		eDAO.insert(esp);
	}
	
	public void alterar(Especialidade esp) {
		eDAO.update(esp);
	}
	
	public Especialidade buscar(Integer id) {
		return eDAO.searchByID(id);
	}
	
	public void remover(Especialidade esp) {
		eDAO.remove(esp);
	}
	
	public List<Especialidade> listar() {
		return eDAO.listarTodos();
	}
}
