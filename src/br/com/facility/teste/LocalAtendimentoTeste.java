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
		
		alteraLocalAtend();
		consultaLocalAtend(1);
		
		listarTodos();
		listarPorCidade("S�o Paulo", "S�o Paulo");
		listarPorEstado("S�o Paulo");
		
//		deletaLocalAtend();
		deletaLocalPorID(1);
		
		listarTodos();

	}
	
	public static void adicionaLocalAtend(){
		l = new LocalAtendimento();
			l.setBairro("Pomp�ia");
			l.setCidade("S�o Paulo");
			l.setEstado("S�o Paulo");
			l.setPais("Brasil");
		lBO.cadastrar(l);
		
		System.out.println("**Local Atendimento cadastrado**");
			
	}
	
	public static void alteraLocalAtend(){
		l.setBairro("Vila Mariana");
		
		lBO.alterar(l);
		
		System.out.println("**Local Atendimento alterado**");
	}
	
	public static void deletaLocalAtend(){
		lBO.remover(l);
		
		System.out.println("**Local Atendimento deletado**");
	}
	
	public static void deletaLocalPorID(int id){
		lBO.removerPorID(id);
		
		System.out.println("**Local Atendimento deletado**");
	}
	
	public static void consultaLocalAtend(int id){
		l = lBO.buscar(id);
		
		if(l != null){
			System.out.println("\n" + l.getPais());
			System.out.println(l.getEstado());
			System.out.println(l.getCidade());
			System.out.println(l.getBairro());
		} else {
			System.out.println("**Local de Atendimento n�o cadastrado**");
		}
	}
	
	/**
	 * Lista todos os Locais Cadastrados
	 */
	public static void listarTodos(){
		List<LocalAtendimento> lstLocal = lBO.listar();
		
		if(lstLocal != null){
			for (LocalAtendimento local : lstLocal) {
				System.out.println("\n" + local.getPais());
				System.out.println(local.getEstado());
				System.out.println(local.getCidade());
				System.out.println(local.getBairro());
			}
		} else {
			System.out.println("**N�o h� Local de Atendimento cadastrado**");
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
			System.out.println("**N�o h� Local de Atendimento cadastrado para esta Cidade**");
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
			System.out.println("**N�o h� Local de Atendimento cadastrado para este Estado**");
		}
	}

}
