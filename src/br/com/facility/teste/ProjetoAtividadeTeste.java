package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoAtividadeEspecialidade;
import br.com.facility.to.Atividade;
import br.com.facility.to.Projeto;
import br.com.facility.to.ProjetoAtividade;

public class ProjetoAtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static ProjetoBO pBO = new ProjetoBO(em);
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	private static ProjetoAtividade pa;
	private static List<Projeto> lista;

	public static void main(String[] args) {

		// chama estaticamente os métodos do teste de Usuario
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();

		// chama estaticamente os métodos do teste de Atividade e Especialidade
		AtividadeTeste.cadastrar();
		EspecialidadeTeste.cadastrar();

		// PROJETO
		ProjetoTeste.cadastraProjeto();
		ProjetoTeste.consultaProjeto();

		ProjetoTeste.listaProjetos();

		// PROJETO ATIVIDADE
		cadastraAtividade();
		listarAtividadePorProjeto();

		alterarAtividade();
		listarAtividadePorProjeto();

		removerAtividade();
		listarAtividadePorProjeto();

	}

	public static void cadastraAtividade() {
		pa = new ProjetoAtividade();
		Projeto projeto = pBO.buscar(1);
		Atividade ativ = aBO.buscarAtividade(1);
		pa.setProjeto(projeto);
		pa.setAtividade(ativ);
		pa.setEspecialidade(eBO.buscar(5));
		if (pa.getEspecialidade() != null) {
			pa.setTipo(TipoAtividadeEspecialidade.ESPECIALIDADE);
		} else {
			pa.setTipo(TipoAtividadeEspecialidade.ATIVIDADE);
		}
		pa.setDescricao("Manjo muito");

		pBO.cadastrarAtividade(pa);
		System.out.println("**Atividade no Projeto cadastrado**");

		pa = new ProjetoAtividade();
		projeto = pBO.buscar(2);
		ativ = aBO.buscarAtividade(2);
		pa.setProjeto(projeto);
		pa.setAtividade(ativ);
		pa.setEspecialidade(eBO.buscar(6));
		if (pa.getEspecialidade() != null) {
			pa.setTipo(TipoAtividadeEspecialidade.ESPECIALIDADE);
		} else {
			pa.setTipo(TipoAtividadeEspecialidade.ATIVIDADE);
		}
		pa.setDescricao("Pódi Confiáh que rola");

		pBO.cadastrarAtividade(pa);
		System.out.println("**Atividade no Projeto cadastrado**");
	}

	public static void alterarAtividade() {
		pa.setEspecialidade(eBO.buscar(6));
		pBO.alterarAtividade(pa);

		System.out.println("**Atividade do Projeto alterado**");
	}

	public static void removerAtividade() {
		pBO.removerAtividade(pa);
		System.out.println("**Atividade do Projeto excluída**");
	}

	public static void listarAtividadePorProjeto() {

		System.out.println("\nCONSULTA DE ATIVIDADES DE PROJETO");

		Projeto projeto = pBO.buscar(1);
		List<ProjetoAtividade> lista = pBO.listarAtividadePorProjeto(projeto);

		if (!lista.isEmpty()) {
			System.out.println("\nPROJETO " + projeto.getId());
			for (ProjetoAtividade pa : lista) {
				System.out.println("\nCOD: " + pa.getProjeto().getDescricao()
						+ pa.getItem());
				System.out.println("Atividade: " + pa.getAtividade().getNome());
				if (pa.getTipo() == TipoAtividadeEspecialidade.ESPECIALIDADE) {
					System.out.println("Especialidade: "
							+ pa.getEspecialidade().getNome());
				}
				System.out.println("Tipo: " + pa.getTipo());
				System.out.println("Descrição: " + pa.getDescricao());
			}
		} else {
			System.out
					.println("**Não há Atividades cadastradas nesse Projeto**");
		}
	}

}
