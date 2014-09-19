package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.CategoriaBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;

public class EspecialidadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();

	private static Especialidade e1;
	private static Especialidade e2;
	private static Especialidade e3;
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);

	private static Atividade a1;
	private static Atividade a2;
	private static AtividadeBO aBO = new AtividadeBO(em);

	private static CategoriaBO cBO = new CategoriaBO(em);

	private static Categoria c1 = new Categoria();
	private static Categoria c2 = new Categoria();
	private static Categoria c3 = new Categoria();

	// LISTA ESPECIALIDADE
	public static void listar() {
		System.out.println("\n *** LISTAR ESPECIALIDADE *** \n");
		List<Especialidade> lista = eBO.listar();
		for (Especialidade especialidade : lista) {
			System.out.println("\nID: .................. "
					+ especialidade.getId() + "\nNome: ................ "
					+ especialidade.getNome() + "\nCï¿½digo Atividade: .... "
					+ especialidade.getAtividade().getId()
					+ "\n------------------------------------");
		}
	}

	// CADASTRA ATIVIDADE
	public static void cadastarAtividade() {
		a1 = new Atividade();
		a1.setNome("Construcao");
		a1.setCategoria(c3);

		aBO.cadastrar(a1);
		System.out.println("\n *** Atividade Cadastrada *** \n");

		a2 = new Atividade();
		a2.setNome("Desenvolvedor de software");
		a2.setCategoria(c1);

		aBO.cadastrar(a2);
		System.out.println("\n *** Atividade Cadastrada *** \n");

	}

	// CADASTRA ESPECIALIDADE
	public static void cadastrar() {

		e1 = new Especialidade();
		e1.setAtividade(aBO.buscarAtividade(1));
		e1.setNome("Marcenaria");
		eBO.cadastrar(e1);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		e2 = new Especialidade();
		e2.setAtividade(aBO.buscarAtividade(4));
		e2.setNome("Desenvolvedor Android");
		eBO.cadastrar(e2);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		e3 = new Especialidade();
		e3.setAtividade(aBO.buscarAtividade(4));
		e3.setNome("Desenvolvedor iOS");
		eBO.cadastrar(e3);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
	}

	// CONSULTA ESPECIALIDADE POR ID
	public static void buscar() {
		System.out.println("\n *** CONSULTA ESPECIALIDADE POR ID *** \n");
		Especialidade e10 = new Especialidade();
		try {
			e10 = eBO.buscar(e1.getId());
			System.out.println("\nID: .................. " + e10.getId()
					+ "\nNome: ................ " + e10.getNome()
					+ "\nCï¿½digo Atividade: .... "
					+ e10.getAtividade().getId());
		} catch (Exception e) {
			System.out.println("\nEspecialidade nï¿½o encontrada!");
		}
	}

	// ALTERA ESPECIALIDADE
	public static void alterar() {
		System.out.println("\n *** ALTERA ESPECALIDADE *** \n");
		Especialidade eSearch = new Especialidade();
		try {
			eSearch = eBO.buscar(e1.getId());
			eSearch.setNome("Desenvolvedor Java");
			eSearch.setAtividade(a2);
			System.out.println("\nID: .................. " + eSearch.getId()
					+ "\nNome: ................ " + eSearch.getNome()
					+ "\nCï¿½digo Atividade: .... "
					+ eSearch.getAtividade().getId());
			System.out.println("\nEspecialidade foi Alterada com Sucesso!");

		} catch (Exception e) {
			System.out
					.println("\nNï¿½o ï¿½ possï¿½vel alterar essa Especialidade!");
		}
	}

	// EXCLUIR ESPECIALIDADE
	public static void remover() {
		System.out.println("\n *** EXCLUIR ESPECIALIDADE *** \n");
		Especialidade eSearch = new Especialidade();
		try {
			eSearch = eBO.buscar(e1.getId());
			eBO.remover(eSearch);
			System.out.println("\nEspecialidade foi excluida com Sucesso!");
		} catch (Exception e) {
			System.out
					.println("\nNï¿½o ï¿½ possï¿½vel excluir essa Especialidade!");
		}
	}

	public static void cadastraCategoria() {

		c1.setNome("Informática");
		c2.setNome("Transporte");
		c3.setNome("Doméstico");

		cBO.cadastrar(c1);
		cBO.cadastrar(c2);
		cBO.cadastrar(c3);
	}

	public static void main(String[] args) {

		AtividadeTeste.cadastrar();
		cadastrar();
		listar();
		buscar();
		alterar();
		remover();
		listar();

	}

}
