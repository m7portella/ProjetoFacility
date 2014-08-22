package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.to.Categoria;
import br.com.facility.dao.CategoriaDAO;

public class CategoriaDAOImpl extends DAOImpl<Categoria, Integer> 
							implements CategoriaDAO{



	public CategoriaDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listar() {
		Query q = em.createQuery("FROM Categoria");
		List<Categoria> lista = q.getResultList();
		return lista;
	}

}
