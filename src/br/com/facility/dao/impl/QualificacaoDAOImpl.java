package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.QualificacaoDAO;
import br.com.facility.to.Qualificacao;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoDAOImpl extends DAOImpl<Qualificacao, Long> implements QualificacaoDAO {

	public QualificacaoDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Qualificacao> listarPorServicoConcluido(ServicoConcluido sc) {
		Query q = em.createQuery("from Qualificacao q where servicoConcluido = :sc").setParameter("sc", sc);
		return q.getResultList();
	}
	
}
