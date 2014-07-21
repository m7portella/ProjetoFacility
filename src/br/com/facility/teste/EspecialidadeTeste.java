package br.com.facility.teste;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Especialidade;

public class EspecialidadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	private static Especialidade e;
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	
	private static Atividade a;
	private static AtividadeBO aBO = new AtividadeBO(em);
	
	private static void cadastarAtividade() {
		a = new Atividade();
		a.setNome("Construcao");
		a.setCategoria(48);
		
		aBO.inserir(a);
		System.out.println("/n *** Atividade Cadastrada *** /n");
	}
	
	private static void cadastrarEspecialidade() {
		e = new Especialidade();
		e.setAtividade(a);
		e.setNome("Marcenaria");
		
		eBO.incluir(e);
		System.out.println("/n *** Especialidade Cadastrada *** /n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		cadastarAtividade();
		cadastrarEspecialidade();
		
	}

}
