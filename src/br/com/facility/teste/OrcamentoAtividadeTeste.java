package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.OrcamentoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoAtividadeEspecialidade;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoAtividade;
import br.com.facility.to.OrcamentoAtividadePK;

public class OrcamentoAtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static OrcamentoBO oBO = new OrcamentoBO(em);
	private static OrcamentoAtividade oa;

	public static void main(String[] args) {

		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		//CADASTRA ATIVIDADE E ESPECIALIDADE
		AtividadeTeste.cadastrar();
		EspecialidadeTeste.cadastrar();

		// ORCAMENTO
		OrcamentoTeste.cadastraOrcamento();
		OrcamentoTeste.listaOrcamentos();

		// ORCAMENTO ATIVIDADE

			// negociacao atividade
			NegociacaoAtividadeTeste.cadastrarNegociacaoAtividade();

		cadastrarOrcamentoAtividade();
		listarAtividadesPorOrcamento();

		alterarOrcamentoAtividade();
		listarAtividadesPorOrcamento();

		removerOrcamentoAtividade();
		listarAtividadesPorOrcamento();

	}
	
	public static void cadastrarOrcamentoAtividade(){
		oa = new OrcamentoAtividade();
			oa.setOrcamento(oBO.buscar(1,nBO.buscar(1)));
			oa.setNegociacaoAtividade(nBO.buscarPorNegociacao(1));
			oa.setItem(1);
			oa.setDescricao("blá blá blá");
			oa.setQtdeHoras(30);
			oa.setValor(1200);
		oBO.cadastrarOrcamentoAtividade(oa);
		System.out.println("**Orcamento Atividade registrado**");
	}
	
	public static void alterarOrcamentoAtividade(){
		oa.setItem(2);
		oBO.alterarOrcamentoAtividade(oa);
		System.out.println("**Orcamento Atividade alterado**");
		
	}
	
	public static void removerOrcamentoAtividade(){
		oBO.removerOrcamentoAtividade(oa);
		System.out.println("**Orcamento Atividade excluído**");
	}
	
	public static void listarAtividadesPorOrcamento(){
		Orcamento orcamento = oBO.buscar(1, nBO.buscar(1));
		List<OrcamentoAtividade> lista = oBO.listarPorOrcamento(orcamento);
		
		if(!lista.isEmpty()){
			System.out.println("Orçamento " + orcamento.getCodigo());
			for (OrcamentoAtividade oa : lista) {
				System.out.println("Negociacao Atividade Cód.: " + oa.getNegociacaoAtividade().getId());
				if(oa.getNegociacaoAtividade().getTipo() == TipoAtividadeEspecialidade.ESPECIALIDADE){
					System.out.println("	Atividade: " + oa.getNegociacaoAtividade().getAtividade().getNome() + " - Especialidade: " + oa.getNegociacaoAtividade().getEspecialidade().getNome());
				}else{
					System.out.println("	Atividade: " + oa.getNegociacaoAtividade().getAtividade().getNome() + " - Especialidade: " + oa.getNegociacaoAtividade().getEspecialidade().getNome());

				}
				System.out.println("Descrição: " + oa.getDescricao());
				System.out.println("Item: " + oa.getItem());
				System.out.println("Qtde Horas: " + oa.getQtdeHoras());
				System.out.println("Valor: " + oa.getValor());
			}
		}else{
			System.out.println("**Não há atividades cadastradas nesse Orcamento**");
		}
	}

}
