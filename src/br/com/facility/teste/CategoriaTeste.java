package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.CategoriaBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Categoria;

public class CategoriaTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	private static Categoria c1 = new Categoria();
	private static Categoria c2 = new Categoria();
	private static Categoria c3 = new Categoria();
	private static Categoria c4 = new Categoria();
	
	private static CategoriaBO cBO = new CategoriaBO(em);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cadastrar();
		listar();
		alterar();
		buscar();
		remover();
	}

	private static void cadastrar() {
		c1.setNome("Construção");
		cBO.cadastrar(c1);
		System.out.println("\n *** CATEGORIA CADASTRADA **** \n");
		
		c2.setNome("TI");
		cBO.cadastrar(c2);
		System.out.println("\n *** CATEGORIA CADASTRADA **** \n");
		
		c3.setNome("Domestico");
		cBO.cadastrar(c3);
		System.out.println("\n *** CATEGORIA CADASTRADA **** \n");
	}
	
	private static void alterar() {
		System.out.println(
				"\nID: ........ " + c1.getId() +
				"\nNome: ...... " + c1.getNome()
				);
		c1.setNome("Transporte");
		cBO.alterar(c1);
		System.out.println("\n *** CATEGORIA ATUALIZADA *** \n");
		System.out.println(
				"\nID: ........ " + c1.getId() +
				"\nNome: ...... " + c1.getNome()
				);
	} 
	
	private static void buscar() {
		c4 = cBO.buscar(c1.getId());
		System.out.println(
				"\nID: ........ " + c4.getId() +
				"\nNome: ...... " + c4.getNome()
				);
	}
	
	private static void remover() {
		cBO.remover(c2);
		System.out.println("\n *** CATEGORIA REMOVIDA *** \n");
	}
	
	private static void listar() {
		List<Categoria> lista = cBO.listar();
		for (Categoria c : lista){
			System.out.println(
					"\nID: ........ " + c.getId() +
					"\nNome: ...... " + c.getNome()
					);
		}
	}
}
