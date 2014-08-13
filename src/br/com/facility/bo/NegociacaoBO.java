package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.NegociacaoAtividadeDAO;
import br.com.facility.dao.NegociacaoDAO;
import br.com.facility.dao.impl.NegociacaoAtividadeDAOImpl;
import br.com.facility.dao.impl.NegociacaoDAOImpl;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.Profissional;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class NegociacaoBO {

	private EntityManager em;
	private NegociacaoDAO nDAO;
	private NegociacaoAtividadeDAO naDAO;
	
	public NegociacaoBO(EntityManager e){
		em = e;
		nDAO = new NegociacaoDAOImpl(em);
		naDAO = new NegociacaoAtividadeDAOImpl(em);
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
	
	public void deletar(Negociacao n){
		
		// RN - Negociacao deletada Ã© mantida no BD com status DELETADO
		n.setStatus(StatusNegociacao.DELETADO);
		n.setDataStatus(Calendar.getInstance());
		nDAO.update(n);
		
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
