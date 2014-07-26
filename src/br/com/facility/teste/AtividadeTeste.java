package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;

public class AtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static Atividade a1 = new Atividade();
	private static Atividade a2 = new Atividade();
	private static Atividade a3 = new Atividade();
	private static Atividade a4 = new Atividade();
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static List<Atividade> lista;
	
	public static void main(String[] args) {

		cadastarAtividade();
		listarAtividades();
		
	}
	
	public static void listarAtividades(){

		
		System.out.println("\n *** TESTE CONSULTAR ***");
		Atividade aSearch = aBO.buscar(1);
		System.out.println(
				"\nID: .............. " + aSearch.getId() +
				"\nNome: ............ " + aSearch.getNome() +
				"\nCategoria: ....... " + aSearch.getCategoria() + 
				"\n------------------------------------"
				);
		
		System.out.println("\n *** TESTE ALTERAR ***");
		aSearch.setNome("Costureira");
		aBO.alterar(aSearch);
		System.out.println(
				"\nID: .............. " + aSearch.getId() +
				"\nNome: ............ " + aSearch.getNome() +
				"\nCategoria: ....... " + aSearch.getCategoria() + 
				"\n------------------------------------"
				);
		
		System.out.println("\n *** TESTE LISTAR TODOS ***");
		lista = aBO.listar();		
		for (Atividade a : lista) {
			System.out.println(
					"\nID: .............. " + a.getId() +
					"\nNome: ............ " + a.getNome() +
					"\nCategoria: ....... " + a.getCategoria() + 
					"\n------------------------------------"
					);
		}
		
		System.out.println("\n *** TESTE REMOVER ***");
		System.out.println("\n REMOVENDO ATIVIDADE DE ID:" + a2.getId() + " ...");
		aBO.remover(a2);
		System.out.println("\n ATIVIDADE REMOVIDA COM SUCESSO!");
	}

	public static void cadastarAtividade() {
		a1.setNome("Construcao de Mesa de Madeira");
		a1.setCategoria(48);
		
		a2.setNome("Magico");
		a2.setCategoria(23);
		
		a3.setNome("Taxi");
		a3.setCategoria(11);
		
		a4.setNome("Desenvolvedor de Software");
		a4.setCategoria(19);
		
		aBO.cadastrar(a1);
		System.out.println("*** Atividade Cadastrada ***");
		
		aBO.cadastrar(a2);
		System.out.println("*** Atividade Cadastrada ***");
		
		aBO.cadastrar(a3);
		System.out.println("*** Atividade Cadastrada ***");
		
		aBO.cadastrar(a4);
		System.out.println("*** Atividade Cadastrada ***");
	}
	
}
