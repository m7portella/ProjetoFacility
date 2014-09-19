package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.CategoriaBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;

public class AtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private static AtividadeBO aBO = new AtividadeBO(em);
	
	private static Atividade a1 = new Atividade();
	private static Atividade a2 = new Atividade();
	private static Atividade a3 = new Atividade();
	private static Atividade a4 = new Atividade();
	
	private static CategoriaBO cBO = new CategoriaBO(em);
	
	private static Categoria c1 = new Categoria();
	private static Categoria c2 = new Categoria();
	private static Categoria c3 = new Categoria();
	
	private static List<Atividade> lista;

	public static void main(String[] args) {
		
		cadastraCategoria();
		
		cadastrar();
		listar();
		buscar(a1.getId());
		alterar(a1);
		remover(a1);
		listar();

	}

	public static void cadastraCategoria() {
		
		c1.setNome("Informática");
		c2.setNome("Transporte");
		c3.setNome("Doméstico");
		
		cBO.cadastrar(c1);
		cBO.cadastrar(c2);
		cBO.cadastrar(c3);
	}
	
	public static void cadastrar() {
		a1.setNome("Construcao de Mesa de Madeira");
		a1.setCategoria(c1);
		aBO.cadastrar(a1);
		System.out.println("*** Atividade Cadastrada ***");

		a2.setNome("Magico");
		a2.setCategoria(c1);
		aBO.cadastrar(a2);
		System.out.println("*** Atividade Cadastrada ***");

		a3.setNome("Taxi");
		a3.setCategoria(c2);
		aBO.cadastrar(a3);
		System.out.println("*** Atividade Cadastrada ***");

		a4.setNome("Desenvolvedor de Software");
		a4.setCategoria(c1);
		aBO.cadastrar(a4);
		System.out.println("*** Atividade Cadastrada ***");
		
	}

	
	public static void alterar(Atividade a) {
		System.out.println("\n *** TESTE ALTERAR ***");
		a.setNome("Nova Atividade");
		a.setCategoria(c1);
		aBO.alterar(a);
		System.out.println("\nID: .............. " + a.getId()
				+ "\nNome: ............ " + a.getNome()
				+ "\nCategoria: ....... " + a.getCategoria()
				+ "\n------------------------------------");
	}

	public static Atividade buscar(int id) {
		System.out.println("\n *** TESTE BUSCAR ***");
		
		Atividade a = aBO.buscarAtividade(id);
		System.out.println("\nID: .............. " + a.getId()
				+ "\nNome: ............ " + a.getNome()
				+ "\nCategoria: ....... " + a.getCategoria()
				+ "\n------------------------------------");
		return a;
	}

	public static void listar() {

		System.out.println("\n *** TESTE LISTAR TODOS ***");
		lista = aBO.listarAtividades();
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
