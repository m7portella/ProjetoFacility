package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.ProjetoAtividadeDAO;
import br.com.facility.to.Projeto;
import br.com.facility.to.ProjetoAtividade;
import br.com.facility.to.ProjetoAtividadePK;

public class ProjetoAtividadeDAOImpl extends DAOImpl<ProjetoAtividade, ProjetoAtividadePK> implements ProjetoAtividadeDAO {

	public ProjetoAtividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ProjetoAtividade> listaAtividadesPorProjeto(Projeto projeto) {
		TypedQuery<ProjetoAtividade> query = em.createQuery("FROM ProjetoAtividade WHERE projeto = :p", ProjetoAtividade.class);
		query.setParameter("p", projeto);
		return query.getResultList();
	}

}
