package br.com.facility.bo;

import java.util.List;
import javax.persistence.EntityManager;
import br.com.facility.dao.CepDAO;
import br.com.facility.dao.impl.CepDAOImpl;
import br.com.facility.to.Cep;

public class CepBO {
	
	private EntityManager em;
	private CepDAO cDAO;
	
	public CepBO(EntityManager e){
		em = e;
		cDAO = new CepDAOImpl(em);
	}
	
	public void cadastrar(Cep cep){
		cDAO.insert(cep);
	}
	
	public void alterar(Cep cep){
		cDAO.update(cep);
	}
	
	public void remover(Cep cep){
		cDAO.remove(cep);
	}
	
	public void removerPorId(int id){
		cDAO.removeById(id);
	}
	
	public Cep buscar(int id){
		return cDAO.searchByID(id);
	}
	
	public List<Cep> listarPorCep(String nroCep){
		List<Cep> lstCeps = cDAO.listarCep(nroCep);
		return lstCeps;
	}
	
	
//	/**
//	 * 	Apenas utilizando o WebService
//	 */
//	private static WebServiceCep cep;
//	
//	public WebServiceCep buscarCepWebService(String CEP){
//		cep = WebServiceCep.searchCep(CEP);
//		
//		return cep;
//		
//	}
//	
//	/**
//	 * Servico disponibilizado pela ByJG
//	 * � necess�rio login para utilizar o servi�o com mais fun��es 
//	 */
//	public String consultarCEP(String cep){
//		CepServiceByJG cepService = new CepServiceByJG("amandayuri", "facility");
//		try {
//			cepService.obterVersao();
//			return cepService.obterLogradouro(cep);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "CEP inv�lido";
//		}
//	}
	
}
