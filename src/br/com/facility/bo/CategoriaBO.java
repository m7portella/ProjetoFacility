package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.CategoriaDAO;
import br.com.facility.dao.impl.CategoriaDAOImpl;
import br.com.facility.to.Categoria;

public class CategoriaBO {

	private EntityManager em;
	private CategoriaDAO cDAO;
	
	public CategoriaBO(EntityManager e){
		em = e;
		cDAO = new CategoriaDAOImpl(em);
	}
	
	public void cadastrar(Categoria c) {
		cDAO.insert(c);
	}
	
	public void alterar(Categoria c) {
		cDAO.update(c);
	}
	
	public Categoria buscar(Integer id) {
		return cDAO.searchByID(id);
	}
	
	public List<Categoria> listar() {
		return cDAO.listar();
		
	}
	
	public void remover(Categoria c) {
		cDAO.remove(c);
	}
}
