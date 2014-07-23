package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Especialidade;

public class EspecialidadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	private static Especialidade e1;
	private static Especialidade e2;
	private static Especialidade e3;
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	
	private static Atividade a1;
	private static Atividade a2;
	private static AtividadeBO aBO = new AtividadeBO(em);
	
	public static void main(String[] args) {
		
		//cadastra atividades
		AtividadeTeste.cadastarAtividade();
		
		//cadastarAtividade();
		cadastrarEspecialidade();
		listaEspecialidades();
		
	}
	
	public static void listaEspecialidades(){
		List<Especialidade> lista = eBO.listarTodos(a2);
		for (Especialidade especialidade : lista) {
			System.out.println(especialidade.getNome());
		}
	}
	
	public static void cadastarAtividade() {
		a1 = new Atividade();
		a1.setNome("Construcao");
		a1.setCategoria(48);
		
		aBO.inserir(a1);
		System.out.println("/n *** Atividade Cadastrada *** /n");
		
		a2 = new Atividade();
		a2.setNome("Desenvolvedor de software");
		a2.setCategoria(48);
		
		aBO.inserir(a2);
		System.out.println("/n *** Atividade Cadastrada *** /n");
		
	}
	
	public static void cadastrarEspecialidade() {
		
		// busca as atividades
		a1 = aBO.consultar(1);
		a2 = aBO.consultar(4);
		
		e1 = new Especialidade();
		e1.setAtividade(a1);
		e1.setNome("Marcenaria");
		eBO.incluir(e1);
		System.out.println("/n *** Especialidade Cadastrada *** /n");
		
		e2 = new Especialidade();
		e2.setAtividade(a2);
		e2.setNome("Desenvolvedor Android");
		eBO.incluir(e2);
		System.out.println("/n *** Especialidade Cadastrada *** /n");
		
		e3 = new Especialidade();
		e3.setAtividade(a2);
		e3.setNome("Desenvolvedor iOS");
		eBO.incluir(e3);
		System.out.println("/n *** Especialidade Cadastrada *** /n");
	}
	
	

}
