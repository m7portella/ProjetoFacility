/**
 * 
 */
package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;

import br.com.facility.dao.ResponsavelDAO;
import br.com.facility.dao.impl.ResponsavelDAOImpl;
import br.com.facility.enums.HierarquiaResponsavel;
import br.com.facility.enums.StatusResponsavel;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;

/**
 * @author Andersson
 * 
 * Data:16/07/2014
 *
 */
public class ResponsavelBO {
	
	private EntityManager em;
	private ResponsavelDAO rDAO;
	
	public ResponsavelBO(EntityManager e) {
		em = e;
		rDAO = new ResponsavelDAOImpl(em);
	}	

	public void cadastrar(Responsavel resp, ClienteJuridico cj) {
		
		try {
		
			//Insere no responsavel o cliente juridico de acordo
			resp.setClienteJuridico(cj);
			
			if(resp.getHierarquia() == HierarquiaResponsavel.PRINCIPAL){
				
				//Vereficar se existe no banco, se existir n�o insere
				
				//Perguntar se vai fazer uma classe separada com o devido m�todo,
				//ou se ir� efetuar daqui msm a chamada do banco
				
			}else {
				
				// status inicial ATIVO
				resp.setStatus(StatusResponsavel.ATIVO);
				resp.setDataStatus(Calendar.getInstance());
			
				rDAO.insert(resp);
				
			
			}
			
		} catch (RuntimeErrorException e) {
			
			System.out.println("Erro ao cadastrar respons�vel!!");
			e.printStackTrace();
			
		}
	
	}
	
	public void alterar(Responsavel resp) {
		rDAO.update(resp);
	}
	
	public Responsavel consultar(Integer id) {
		return rDAO.searchByID(id);
	}
	
	public void excluir(Responsavel resp) {
		
		// RN - Responsaveis deletados s�o mantidos no BD com status DELETADO
		resp.setStatus(StatusResponsavel.DELETADO);
		resp.setDataStatus(Calendar.getInstance());
		
		rDAO.update(resp);
	}
	
	public List<Responsavel> listarPorCliente(ClienteJuridico cj) {
		return rDAO.listarPorCliente(cj);
	}
	
}
