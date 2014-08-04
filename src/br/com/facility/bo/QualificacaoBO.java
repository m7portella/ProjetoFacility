package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.QualificacaoDAO;
import br.com.facility.dao.impl.QualificacaoDAOImpl;
import br.com.facility.to.Qualificacao;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoBO {

	EntityManager em;
	QualificacaoDAO qDAO;
	
	public QualificacaoBO(EntityManager e) {
		
		em = e;
		qDAO = new QualificacaoDAOImpl(em);
		
	}
	
	public void cadastrar(Qualificacao q){
		
		qDAO.insert(q);
		
	}
	
	public Qualificacao buscar(Long id){
		
		Qualificacao q = qDAO.searchByID(id);
		return q;
		
	}
	
	public List<Qualificacao> listarPorServicoConcluido(ServicoConcluido sc){
		
		List<Qualificacao> lista = qDAO.listarPorServicoConcluido(sc);
		return lista;
		
	}
	
	public void alterar(Qualificacao q){
		qDAO.update(q);
	}
	
}
