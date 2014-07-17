package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.MensagemDAO;
import br.com.facility.dao.impl.MensagemDAOImpl;
import br.com.facility.to.Mensagem;
import br.com.facility.to.MensagemPK;
import br.com.facility.to.Negociacao;

public class MensagemBO {

	private EntityManager em;
	private MensagemDAO mDAO;
	
	public MensagemBO(EntityManager e){
		em = e;
		mDAO = new MensagemDAOImpl(em);
	}

	public void registrar(Mensagem m, Negociacao n){
		
		m.setNegociacao(n);
		m.setDataEnvio(Calendar.getInstance());
		mDAO.insert(m);
		
	}
	
	public Mensagem consultar(long codigo, Negociacao n){
		
		MensagemPK mPK = new MensagemPK();
		mPK.setCodigo(codigo);
		mPK.setNegociacao(n.getProtocolo());
		
		Mensagem m = mDAO.searchByID(mPK);
		return m;
		
	}
	
	public List<Mensagem> listarPorNegociacao(Negociacao n){
		
		List<Mensagem> lista = mDAO.listaPorNegociacao(n);
		return lista;
		
	}
	
}
