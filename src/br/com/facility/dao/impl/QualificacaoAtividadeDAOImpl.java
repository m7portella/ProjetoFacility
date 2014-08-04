package br.com.facility.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.facility.dao.QualificacaoAtividadeDAO;
import br.com.facility.to.QualificacaoAtividade;
import br.com.facility.to.ServicoConcluido;



public class QualificacaoAtividadeDAOImpl extends DAOImpl<QualificacaoAtividade, Integer> implements  QualificacaoAtividadeDAO{

	public QualificacaoAtividadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QualificacaoAtividade> listarPorServicoConcluido(ServicoConcluido sc){
		Query q = em.createQuery("from QualificacaoAtividade qa where servicoConcluido = :sc").setParameter("sc", sc);
		return q.getResultList();
	}

}
