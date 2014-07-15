package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.EspecialidadeDAO;
import br.com.facility.to.Atividade;
import br.com.facility.to.Especialidade;

public class EspecialidadeDAOImpl extends DAOImpl<Especialidade, Integer> implements EspecialidadeDAO {

	public EspecialidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> listarTodos(Atividade atividade) {
		// TODO Auto-generated method stub
		Query q = em.createQuery("SELECT e FROM Especialidade e WHERE e.atividade = :a ");
		q.setParameter("a", atividade);
		List<Especialidade> lista = q.getResultList();
		return lista;
	}

}
