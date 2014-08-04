package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.QualificacaoAtividadeDAO;
import br.com.facility.dao.impl.QualificacaoAtividadeDAOImpl;
import br.com.facility.to.QualificacaoAtividade;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoAtividadeBO {

	EntityManager em;
	QualificacaoAtividadeDAO qaDAO;

	public QualificacaoAtividadeBO(EntityManager e) {

		em = e;
		qaDAO = new QualificacaoAtividadeDAOImpl(em);

	}

	public void cadastrar(QualificacaoAtividade qa) {

		qaDAO.insert(qa);

	}

	public QualificacaoAtividade buscar(Integer id) {

		QualificacaoAtividade qa = qaDAO.searchByID(id);
		return qa;

	}

	public List<QualificacaoAtividade> listarPorServicoConcluido(ServicoConcluido sc) {

		List<QualificacaoAtividade> lista = qaDAO.listarPorServicoConcluido(sc);
		return lista;

	}

	public void alterar(QualificacaoAtividade qa) {
		qaDAO.update(qa);
	}

}
