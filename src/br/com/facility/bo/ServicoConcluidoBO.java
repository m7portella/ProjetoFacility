package br.com.facility.bo;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.facility.dao.ServicoConcluidoDAO;
import br.com.facility.dao.impl.ServicoConcluidoDAOImpl;
import br.com.facility.to.Negociacao;
import br.com.facility.to.ServicoConcluido;

public class ServicoConcluidoBO {
	
	private EntityManager em;
	private ServicoConcluidoDAO scDAO;
	
	public ServicoConcluidoBO(EntityManager e){
		em = e;
		scDAO = new ServicoConcluidoDAOImpl(em);
	}
	
	public void cadastrar(ServicoConcluido sc, Negociacao n){
		
		sc.setNegociacao(n);
		// TODO data de conclusão tbm é sempre a atual?
		sc.setDataStatus(Calendar.getInstance());
		scDAO.insert(sc);
		
	}
	
	public void alterar(ServicoConcluido sc){
		scDAO.update(sc);
	}
	
	public ServicoConcluido buscar(Negociacao n){
		ServicoConcluido sc = scDAO.consultaPorNegociacao(n);
		return sc;
	}

}
