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
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> listarTodos() {
		Query q = em.createQuery("FROM Especialidade");
		List<Especialidade> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Especialidade> listarPorAtividade(Atividade a) {
		Query q = em.createQuery("from Especialidade where atividade = :a").setParameter("a", a);
		List<Especialidade> lista = q.getResultList();
		return lista;
	}

}
