package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.LocalAtendimentoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.LocalAtendimento;

public class LocalAtendimentoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static LocalAtendimentoBO lBO = new LocalAtendimentoBO(em);
	private static LocalAtendimento l;
	
	public static void main(String[] args) {
		
		adicionaLocalAtend();
		consultaLocalAtend(1);
		
//		alteraLocalAtend();
//		consultaLocalAtend(1);
		
		listarTodos();
		
//		deletaLocalAtend();
//		deletaLocalPorID(1);
		
		listarTodos();
		listarPorCidade("São Paulo", "Campinas");
		listarPorEstado("São Paulo");

	}
	
	public static void adicionaLocalAtend(){
		l = new LocalAtendimento();
			l.setBairro("Pompéia");
			l.setCidade("São Paulo");
			l.setEstado("São Paulo");
			l.setPais("Brasil");
		lBO.cadastrar(l);
		
		System.out.println("**Local Atendimento cadastrado**");
			
	}
	
	public static void alteraLocalAtend(){
		l.setBairro("Pompéia");
		
		lBO.alterar(l);
		
		System.out.println("**Local Atendimento alterado**");
	}
	
	public static void deletaLocalAtend(){
		lBO.deletar(l);
		
		System.out.println("**Local Atendimento deletado**");
	}
	
	public static void deletaLocalPorID(int id){
		lBO.deletarPorID(id);
		
		System.out.println("**Local Atendimento deletado**");
	}
	
	public static void consultaLocalAtend(int id){
		l = lBO.consultar(id);
		
		if(l != null){
			System.out.println("\n" + l.getPais());
			System.out.println(l.getEstado());
			System.out.println(l.getCidade());
			System.out.println(l.getBairro());
		} else {
			System.out.println("**Local de Atendimento não cadastrado**");
		}
	}
	
	/**
	 * Lista todos os Locais Cadastrados
	 */
	public static void listarTodos(){
		List<LocalAtendimento> lstLocal = lBO.listarTodos();
		
		if(lstLocal != null){
			for (LocalAtendimento local : lstLocal) {
				System.out.println("\n" + local.getPais());
				System.out.println(local.getEstado());
				System.out.println(local.getCidade());
				System.out.println(local.getBairro());
			}
		} else {
			System.out.println("**Não há Local de Atendimento cadastrado**");
		}
	} 
	
	/**
	 * Lista todos os Locais por Cidade fazendo busca pelo nome do Estado e da Cidade
	 * @param nmEstado - Nome do Estado
	 * @param nmCidade - Nome da Cidade
	 */
	public static void listarPorCidade(String nmEstado, String nmCidade){
		List<LocalAtendimento> lstLocal = lBO.listarPorCidade(nmEstado, nmCidade);
		
		System.out.println("-- Busca por: " + nmEstado + " - " + nmCidade);
		if(lstLocal != null){
			for (LocalAtendimento local : lstLocal) {
				System.out.println("\n" + local.getBairro());
			}
		} else {
			System.out.println("**Não há Local de Atendimento cadastrado para esta Cidade**");
		}
	}
	
	/**
	 * Lista todos os Locais por Estado fazendo uma busca pelo nome do Estado
	 * @param nmEstado
	 */
	public static void listarPorEstado(String nmEstado){
		List<LocalAtendimento> lstLocal = lBO.listarPorEstado(nmEstado);
		
		System.out.println("-- Busca por Estado: " + nmEstado);
		if(lstLocal != null){
			for (LocalAtendimento local : lstLocal) {
				System.out.println("\n" + local.getCidade());
				System.out.println(local.getBairro());
			}
		} else {
			System.out.println("**Não há Local de Atendimento cadastrado para este Estado**");
		}
	}

}
