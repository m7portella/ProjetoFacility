package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.PagamentoDAO;
import br.com.facility.dao.impl.PagamentoDAOImpl;
import br.com.facility.enums.StatusPagamento;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Pagamento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class PagamentoBO {

	private EntityManager em;
	private PagamentoDAO pDAO;
	
	public PagamentoBO(EntityManager e){
		em = e;
		pDAO = new PagamentoDAOImpl(em);
	}
	
	public void registrar(Pagamento p, Negociacao n){
		
		// vincula Negociacao, Profissional e Usuario ao Pagamento
		p.setNegociacao(n);
		p.setUsuario(n.getUsuario());
		p.setProfissional(n.getProfissional());
		p.setData(Calendar.getInstance());
		// RN - status inicial BLOQUEADO
		p.setStatus(StatusPagamento.BLOQUEADO);
		p.setDataStatus(Calendar.getInstance());
		
		pDAO.insert(p);
		
	}
	
	public void alterar(Pagamento p){
		pDAO.update(p);
	}
	
	public Pagamento consultar(int id){
		Pagamento p = pDAO.searchByID(id);
		return p;
	}
	
	public List<Pagamento> listarPorNegociacao(Negociacao n){
		List<Pagamento> lista = pDAO.listaPorNegociacao(n);
		return lista;
	}
	
	public List<Pagamento> listarPorUsuario(Usuario u){
		List<Pagamento> lista = pDAO.listaPorUsuario(u);
		return lista;
	}

	public List<Pagamento> listarPorProfissional(Profissional p){
		List<Pagamento> lista = pDAO.listaPorProfissional(p);
		return lista;
	}
	
}
