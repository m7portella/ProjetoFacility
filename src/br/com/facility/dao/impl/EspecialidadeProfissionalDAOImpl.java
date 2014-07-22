package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.EspecialidadeProfissionalDAO;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.EspecialidadeProfissionalPK;
import br.com.facility.to.Profissional;

public class EspecialidadeProfissionalDAOImpl extends
		DAOImpl<EspecialidadeProfissional, EspecialidadeProfissionalPK>
		implements EspecialidadeProfissionalDAO {

	public EspecialidadeProfissionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EspecialidadeProfissional> listarPorProfissional(Profissional p) {
		Query q = em.createQuery(
				"from EspecialidadeProfissional ep where profissional = :p")
				.setParameter("p", p);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EspecialidadeProfissional> listarPorEspecialidade(
			Especialidade e) {
		Query q = em.createQuery(
				"from EspecialidadeProfissional ep where especialidade = :e")
				.setParameter("e", e);
		return q.getResultList();
	}

}
