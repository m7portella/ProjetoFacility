package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.MensagemDAO;
import br.com.facility.dao.NegociacaoAtividadeDAO;
import br.com.facility.dao.NegociacaoDAO;
import br.com.facility.dao.impl.MensagemDAOImpl;
import br.com.facility.dao.impl.NegociacaoAtividadeDAOImpl;
import br.com.facility.dao.impl.NegociacaoDAOImpl;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.to.Mensagem;
import br.com.facility.to.MensagemPK;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.Profissional;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class NegociacaoBO {

	private EntityManager em;
	private NegociacaoDAO nDAO;
	private MensagemDAO mDAO;
	private NegociacaoAtividadeDAO naDAO;
	
	public NegociacaoBO(EntityManager e){
		em = e;
		nDAO = new NegociacaoDAOImpl(em);
		naDAO = new NegociacaoAtividadeDAOImpl(em);
		mDAO = new MensagemDAOImpl(em);
	}
	
	public void cadastrar(Negociacao n, Projeto projeto, Profissional profissional){
		
		// vincula Projeto, Profissional e Usuario Ã  Negociacao
		n.setProfissional(profissional);
		n.setProjeto(projeto);
		n.setUsuario(projeto.getUsuario());
		// data atual
		n.setDataSolicitacao(Calendar.getInstance());
		// status inicial ATIVO
		n.setStatus(StatusNegociacao.ATIVO);
		n.setDataStatus(Calendar.getInstance());
		
		nDAO.insert(n);
		
	}
	
	public void alterar(Negociacao n){
		nDAO.update(n);
	}
	
	public Negociacao buscar(long protocolo){
		Negociacao n = nDAO.searchByID(protocolo);
		return n;
	}
	
	public List<Negociacao> listarPorUsuario(Usuario u){
		List<Negociacao> lista = nDAO.listaPorUsuario(u);
		return lista;
	}
	
	public List<Negociacao> listarPorProjeto(Projeto p){
		List<Negociacao> lista = nDAO.listaPorProjeto(p);
		return lista;
	}
	
	public List<Negociacao> listarPorProfissional(Profissional p){
		List<Negociacao> lista = nDAO.listaPorProfissional(p);
		return lista;
	}
	
	public void deletar(Negociacao n){
		
		// RN - Negociacao deletada Ã© mantida no BD com status DELETADO
		n.setStatus(StatusNegociacao.DELETADO);
		n.setDataStatus(Calendar.getInstance());
		nDAO.update(n);
		
	}
	
	public void enviaMensagem(Mensagem m){
		
		m.setDataEnvio(Calendar.getInstance());
		
		//TODO Enviar para servidor do GCM
		
		mDAO.insert(m);
		
	}
	
	public Mensagem buscar(long protocolo, long codigo){
		
		MensagemPK mPK = new MensagemPK();
		mPK.setCodigo(codigo);
		mPK.setProtocolo(protocolo);
		
		Mensagem m = mDAO.searchByID(mPK);
		return m;
		
	}
	
	public List<Mensagem> listarPorNegociacao(Negociacao n){
		
		List<Mensagem> lista = mDAO.listaPorNegociacao(n);
		return lista;
		
	}
	
	//Negociação Atividade
	
	public void cadastrarAtividade(NegociacaoAtividade na){
		naDAO.insert(na);
	}
	
	public void alterarAtividade(NegociacaoAtividade na){
		naDAO.update(na);
	}
	
	public void removerAtividade(NegociacaoAtividade na){
		naDAO.remove(na);
	}
	
	public NegociacaoAtividade buscarPorNegociacao(long id){
		
		NegociacaoAtividade na = naDAO.searchByID(id);
		return na;
	}
	
	public List<NegociacaoAtividade> listarAtividadesPorNegociacao(Negociacao negociacao){
		List<NegociacaoAtividade> lst = naDAO.listaPorNegociacao(negociacao);
		return lst;
	}
	
}
