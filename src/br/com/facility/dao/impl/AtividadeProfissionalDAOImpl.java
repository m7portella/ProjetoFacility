package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.AtividadeProfissionalDAO;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.AtividadeProfissionalPK;
import br.com.facility.to.Profissional;

public class AtividadeProfissionalDAOImpl extends
		DAOImpl<AtividadeProfissional, AtividadeProfissionalPK> implements
		AtividadeProfissionalDAO {

	public AtividadeProfissionalDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AtividadeProfissional> listarPorProfissional(Profissional p) {
		Query q = em.createQuery(
				"from AtividadeProfissional ap where profissional = :p")
				.setParameter("p", p);
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AtividadeProfissional> listarPorAtividade(Atividade a) {
		Query q = em.createQuery(
				"from AtividadeProfissional ap where atividade = :a")
				.setParameter("a", a);
		return q.getResultList();
	}

}
