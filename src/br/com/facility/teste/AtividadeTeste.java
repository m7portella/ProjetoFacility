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
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static List<Atividade> lista = aBO.listarTodos();
	
	private static void cadastarAtividade() {
		a1.setNome("Constru��o de Mesa de Madeira");
		a1.setCategoria(48);
		
		a2.setNome("M�gico");
		a2.setCategoria(23);
		
		a3.setNome("Taxi");
		a3.setCategoria(11);
		
		aBO.inserir(a1);
		System.out.println("/n *** Atividade Cadastrada *** /n");
		
		aBO.inserir(a2);
		System.out.println("/n *** Atividade Cadastrada *** /n");
		
		aBO.inserir(a3);
		System.out.println("/n *** Atividade Cadastrada *** /n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		cadastarAtividade();
		
		for (Atividade a : lista) {
			System.out.println(
					"\nID: .............. " + a.getId() +
					"\nNome: ............ " + a.getNome() +
					"\nCategoria: ....... " + a.getCategoria() + 
					"\n------------------------------------"
					);
		
		}
		
	}

}
