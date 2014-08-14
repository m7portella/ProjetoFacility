package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.QualificacaoAtividadeDAO;
import br.com.facility.dao.impl.QualificacaoAtividadeDAOImpl;
import br.com.facility.to.QualificacaoAtividade;
import br.com.facility.to.QualificacaoAtividadePK;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoAtividadeBO {

	EntityManager em;
	QualificacaoAtividadeDAO qaDAO;

	public QualificacaoAtividadeBO(EntityManager e) {

		em = e;
		qaDAO = new QualificacaoAtividadeDAOImpl(em);

	}

	public void cadastrar(QualificacaoAtividade qa, ServicoConcluido sc) {

		try {
			
			qa.setServicoConcluido(sc);
			
			qa.setDataQuaificacao(Calendar.getInstance());
			qaDAO.insert(qa);
			
		} catch (Exception e) {
			System.out.println("Erro ao cadastrar qualificação atividade!");
		}

	}

	public QualificacaoAtividade buscar(long id, ServicoConcluido sc) {

		QualificacaoAtividadePK qaPK = new QualificacaoAtividadePK();
		qaPK.setCodigo(id);
		qaPK.setServicoConcluido(sc.getId());
		
		QualificacaoAtividade qa = qaDAO.searchByID(qaPK);
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
