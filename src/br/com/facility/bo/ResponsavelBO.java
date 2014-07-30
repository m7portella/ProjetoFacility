/**
 * 
 */
package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;

import br.com.facility.config.ValidaCPF;
import br.com.facility.dao.ResponsavelDAO;
import br.com.facility.dao.impl.ResponsavelDAOImpl;
import br.com.facility.enums.StatusResponsavel;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;


public class ResponsavelBO {
	
	private EntityManager em;
	private ResponsavelDAO rDAO;
	
	public ResponsavelBO(EntityManager e) {
		em = e;
		rDAO = new ResponsavelDAOImpl(em);
	}	

	public void cadastrar(Responsavel resp, ClienteJuridico cj) {
		
		try {
			
			// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
			if (ValidaCPF.isCPF(resp.getCpf()) == true) 
				System.out.printf("%s\n", ValidaCPF.imprimeCPF(resp.getCpf())); 
			else System.out.printf("Erro, CPF invalido !!!\n"); 

					
					// status inicial ATIVO
					resp.setStatus(StatusResponsavel.ATIVO);
					resp.setDataStatus(Calendar.getInstance());
				
					rDAO.insert(resp);
			
		} catch (RuntimeErrorException e) {
			
			System.out.println("Erro ao cadastrar responsável!!");
			e.printStackTrace();
			
		}
	
	}
	
	public void alterar(Responsavel resp) {
		rDAO.update(resp);
	}
	
	public Responsavel buscar(ClienteJuridico cj) {
		Responsavel r = rDAO.consultaPorClienteJuridico(cj);
		return r;
	}
	
	public void deletar(Responsavel resp) {
		
		// RN - Responsaveis deletados são mantidos no BD com status DELETADO
		resp.setStatus(StatusResponsavel.DELETADO);
		resp.setDataStatus(Calendar.getInstance());
		
		rDAO.update(resp);
	}
	
	public List<Responsavel> listarPorCliente(ClienteJuridico cj) {
		return rDAO.listarPorCliente(cj);
	}
	
}
