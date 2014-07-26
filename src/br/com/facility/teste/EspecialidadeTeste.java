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
	
	// LISTA ESPECIALIDADE
	public static void listaEspecialidades(){
		System.out.println("\n *** LISTAR ESPECIALIDADE *** \n");
		List<Especialidade> lista = eBO.listar();
		for (Especialidade especialidade : lista) {
			System.out.println(
					"\nID: .................. " + especialidade.getId() +
					"\nNome: ................ " + especialidade.getNome() +
					"\nC�digo Atividade: .... " + especialidade.getAtividade().getId() +
					"\n------------------------------------"
					);
		}
	}
	
	// CADASTRA ATIVIDADE
	public static void cadastarAtividade() {
		a1 = new Atividade();
		a1.setNome("Construcao");
		a1.setCategoria(33);
		
		aBO.cadastrar(a1);
		System.out.println("\n *** Atividade Cadastrada *** \n");
		
		a2 = new Atividade();
		a2.setNome("Desenvolvedor de software");
		a2.setCategoria(48);
		
		aBO.cadastrar(a2);
		System.out.println("\n *** Atividade Cadastrada *** \n");
		
	}
	
	// CADASTRA ESPECIALIDADE
	public static void cadastrarEspecialidade() {
		
		e1 = new Especialidade();
		e1.setAtividade(aBO.buscar(1));
		e1.setNome("Marcenaria");
		eBO.cadastrar(e1);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		e2 = new Especialidade();
		e2.setAtividade(aBO.buscar(4));
		e2.setNome("Desenvolvedor Android");
		eBO.cadastrar(e2);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		e3 = new Especialidade();
		e3.setAtividade(aBO.buscar(4));
		e3.setNome("Desenvolvedor iOS");
		eBO.cadastrar(e3);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
	}
	
	// CONSULTA ESPECIALIDADE POR ID
	public static void consultaEspecialidadesPorId() {
		System.out.println("\n *** CONSULTA ESPECIALIDADE POR ID *** \n");
		Especialidade e10 = new Especialidade();
		try {
			e10 = eBO.buscar(e1.getId());
			System.out.println(
					"\nID: .................. " + e10.getId() +
					"\nNome: ................ " + e10.getNome() +
					"\nC�digo Atividade: .... " + e10.getAtividade().getId()
					);
		}
		catch(Exception e) {
			System.out.println("\nEspecialidade n�o encontrada!");
		}
	}
	
	// ALTERA ESPECIALIDADE
	public static void alteraEspecialidade() {
		System.out.println("\n *** ALTERA ESPECALIDADE *** \n");
		Especialidade eSearch = new Especialidade();
		try {
			eSearch = eBO.buscar(e1.getId());
			eSearch.setNome("Desenvolvedor Java");
			eSearch.setAtividade(a2);
			System.out.println(
					"\nID: .................. " + eSearch.getId() +
					"\nNome: ................ " + eSearch.getNome() +
					"\nC�digo Atividade: .... " + eSearch.getAtividade().getId()
					);
			System.out.println("\nEspecialidade foi Alterada com Sucesso!");
			
		} catch (Exception e) {
			System.out.println("\nN�o � poss�vel alterar essa Especialidade!");
		}
	}
	
	// EXCLUIR ESPECIALIDADE
	public static void excluirEspecialidade() {
		System.out.println("\n *** EXCLUIR ESPECIALIDADE *** \n");
		Especialidade eSearch = new Especialidade();
		try {
			eSearch = eBO.buscar(e1.getId());
			eBO.remover(eSearch);
			System.out.println("\nEspecialidade foi excluida com Sucesso!");
		} catch (Exception e) {
			System.out.println("\nN�o � poss�vel excluir essa Especialidade!");
		}
	}
	
	public static void main(String[] args) {
		
		AtividadeTeste.cadastarAtividade();
		cadastrarEspecialidade();
		listaEspecialidades();
		consultaEspecialidadesPorId();
		alteraEspecialidade();
		excluirEspecialidade();
		listaEspecialidades();
		
	}

}
