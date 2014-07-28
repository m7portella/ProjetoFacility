package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.NegociacaoAtividadeDAO;
import br.com.facility.dao.impl.NegociacaoAtividadeDAOImpl;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.NegociacaoAtividadePK;

public class NegociacaoAtividadeBO {

	private EntityManager em;
	private NegociacaoAtividadeDAO naDAO;
	
	public NegociacaoAtividadeBO(EntityManager e){
		em = e;
		naDAO = new NegociacaoAtividadeDAOImpl(em);
	}
	
	public void cadastrar(NegociacaoAtividade na){
		naDAO.insert(na);
	}
	
	public NegociacaoAtividade buscar(long codigo, Negociacao negociacao){
		NegociacaoAtividadePK cod = new NegociacaoAtividadePK();
		cod.setCodigo(codigo);
		cod.setNegociacao(negociacao.getProtocolo());
		
		NegociacaoAtividade na = naDAO.searchByID(cod);
		return na;
	}
	
}
