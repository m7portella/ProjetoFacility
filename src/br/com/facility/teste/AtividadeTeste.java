package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;

public class AtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static Atividade a1 = new Atividade();
	private static Atividade a2 = new Atividade();
	private static Atividade a3 = new Atividade();
	private static Atividade a4 = new Atividade();
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static List<Atividade> lista;

	public static void main(String[] args) {

		cadastar();
		listar();
		buscar(a1.getId());
		alterar(a1);
		remover(a1);
		listar();

	}

	public static void cadastar() {
		a1.setNome("Construcao de Mesa de Madeira");
		a1.setCategoria(48);
		aBO.cadastrar(a1);
		System.out.println("*** Atividade Cadastrada ***");

		a2.setNome("Magico");
		a2.setCategoria(23);
		aBO.cadastrar(a2);
		System.out.println("*** Atividade Cadastrada ***");

		a3.setNome("Taxi");
		a3.setCategoria(11);
		aBO.cadastrar(a3);
		System.out.println("*** Atividade Cadastrada ***");

		a4.setNome("Desenvolvedor de Software");
		a4.setCategoria(19);
		aBO.cadastrar(a4);
		System.out.println("*** Atividade Cadastrada ***");
		
	}

	
	public static void alterar(Atividade a) {
		System.out.println("\n *** TESTE ALTERAR ***");
		a.setNome("Nova Atividade");
		a.setCategoria(111);
		aBO.alterar(a);
		System.out.println("\nID: .............. " + a.getId()
				+ "\nNome: ............ " + a.getNome()
				+ "\nCategoria: ....... " + a.getCategoria()
				+ "\n------------------------------------");
	}

	public static Atividade buscar(int id) {
		System.out.println("\n *** TESTE BUSCAR ***");
		
		Atividade a = aBO.buscar(id);
		System.out.println("\nID: .............. " + a.getId()
				+ "\nNome: ............ " + a.getNome()
				+ "\nCategoria: ....... " + a.getCategoria()
				+ "\n------------------------------------");
		return a;
	}

	public static void listar() {

		System.out.println("\n *** TESTE LISTAR TODOS ***");
		lista = aBO.listar();
		for (Atividade a : lista) {
			System.out.println("\nID: .............. " + a.getId()
					+ "\nNome: ............ " + a.getNome()
					+ "\nCategoria: ....... " + a.getCategoria()
					+ "\n------------------------------------");
		}
	}

	public static void remover(Atividade a) {
		System.out.println("\n *** TESTE REMOVER ***");
		aBO.remover(a);
		System.out.println("Atividade Removida com Sucesso!");
	}
}
