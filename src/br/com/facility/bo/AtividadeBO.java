package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.dao.impl.AitividadeDAOImpl;
import br.com.facility.to.Atividade;

public class AtividadeBO {

	private EntityManager em;
	private AtividadeDAO aDAO;
	
	public AtividadeBO(EntityManager e) {
		em = e;
		aDAO = new AitividadeDAOImpl(em);
	}
	
	public void cadastrar(Atividade a) {
		aDAO.insert(a);
	}
	
	public void remover(Atividade a) {
		aDAO.remove(a);
	}
	
	public void alterar(Atividade a) {
		aDAO.update(a);
	}
	
	public Atividade buscar(Integer id) {
		Atividade a = aDAO.searchByID(id);
		return a;
	}
	
	public List<Atividade> listar() {
		List<Atividade> lista = aDAO.listarTodos();
		return lista;
	}
	
}
