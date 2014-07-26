package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import br.com.facility.dao.AgendaDAO;
import br.com.facility.dao.impl.AgendaDAOImpl;
import br.com.facility.enums.StatusAgenda;
import br.com.facility.to.Agenda;
import br.com.facility.to.AgendaPK;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class AgendaBO {
	
	private EntityManager em;
	private AgendaDAO aDAO;
	
	public AgendaBO(EntityManager e){
		em = e;
		aDAO = new AgendaDAOImpl(em);
	}
	
	public void cadastrar(Agenda a, Negociacao n){
		
		// vincula Negociacao, Profissional e Usuario a Agenda
		a.setNegociacao(n);
		a.setUsuario(n.getUsuario());
		a.setProfissional(n.getProfissional());
		//a.setData(Calendar.getInstance());
		// RN - status inicial ENVIADO
		a.setStatus(StatusAgenda.ENVIADO);
		a.setDataStatus(Calendar.getInstance());
		
		aDAO.insert(a);
		
	}
	
	public Agenda buscar(int codigo,Negociacao n){
		AgendaPK aPK = new AgendaPK();
		aPK.setCodigo(codigo);
		aPK.setNegociacao(n.getProtocolo());
		Agenda a = aDAO.searchByID(aPK);
		return a;
	}
	
	public void alterar(Agenda a){
		aDAO.update(a);
	}
	
	public void alterarStatus(Agenda a, StatusAgenda s){
		a.setStatus(s);
		a.setDataStatus(Calendar.getInstance());
		aDAO.update(a);
	}
	
	public List<Agenda> listarPorNegociacao(Negociacao n){
		List<Agenda> lista = aDAO.listaPorNegociacao(n);
		return lista;
	}
	
	public List<Agenda> listarPorUsuario(Usuario u){
		List<Agenda> lista = aDAO.listaPorUsuario(u);
		return lista;
	}
	
	public List<Agenda> listarPorProfissional(Profissional p){
		List<Agenda> lista = aDAO.listaPorProfissional(p);
		return lista;
	}

}
