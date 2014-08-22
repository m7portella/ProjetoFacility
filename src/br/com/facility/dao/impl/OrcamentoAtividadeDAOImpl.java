package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.facility.dao.OrcamentoAtividadeDAO;
import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoAtividade;
import br.com.facility.to.OrcamentoAtividadePK;

public class OrcamentoAtividadeDAOImpl extends DAOImpl<OrcamentoAtividade, OrcamentoAtividadePK> implements OrcamentoAtividadeDAO {

	public OrcamentoAtividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<OrcamentoAtividade> listaPorOrcamento(Orcamento orcamento) {
		TypedQuery<OrcamentoAtividade> query = em.createQuery("FROM OrcamentoAtividade WHERE orcamento = :p", OrcamentoAtividade.class);
		query.setParameter("p", orcamento);
		return query.getResultList();
	}

}
