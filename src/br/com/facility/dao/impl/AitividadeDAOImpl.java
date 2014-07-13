package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.to.Amigo;
import br.com.facility.to.Atividade;


public class AitividadeDAOImpl extends DAOImpl<Atividade, Integer> implements AtividadeDAO{

	public AitividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Atividade> listarTodos(Atividade a) {
		Query q = em.createQuery("from T_ATIVIDADE a where a.atividade = :a").setParameter("a", a); //Nao conheço essa função, simplesmente substitui o codigo pelo que supus
		List<Atividade> lista = q.getResultList();
		return lista;
	}
	
}
