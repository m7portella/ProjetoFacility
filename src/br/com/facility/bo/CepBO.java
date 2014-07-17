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
	
	public void deletar(Cep cep){
		cDAO.remove(cep);
	}
	
	public void deletarPorId(int id){
		cDAO.removeById(id);
	}
	
	public Cep consultar(int id){
		return cDAO.searchByID(id);
	}
	
	public List<Cep> buscarCep(String nroCep){
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
//	 * É necessário login para utilizar o serviço com mais funções 
//	 */
//	public String consultarCEP(String cep){
//		CepServiceByJG cepService = new CepServiceByJG("amandayuri", "facility");
//		try {
//			cepService.obterVersao();
//			return cepService.obterLogradouro(cep);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "CEP inválido";
//		}
//	}
	
}
