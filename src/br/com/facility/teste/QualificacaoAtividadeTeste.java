package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.QualificacaoAtividadeBO;
import br.com.facility.bo.ServicoConcluidoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.QualificacaoAtividade;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoAtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static ServicoConcluidoBO scBO = new ServicoConcluidoBO(em);
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static QualificacaoAtividadeBO qaBO = new QualificacaoAtividadeBO(em);

	private static ServicoConcluido sc;
	private static Negociacao n;
	private static NegociacaoAtividade na;
	private static QualificacaoAtividade qa;
	private static List<QualificacaoAtividade> lista;
	
	public static void main(String[] args) {
		
		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();

		// SERVICO CONCLUIDO
		ServicoConcluidoTeste.cadastraServicoConcluido();
		
		// cadastra atividade e especialidade
		AtividadeTeste.cadastrar();
		EspecialidadeTeste.cadastrar();
		
		//Cadastrar Negociação atividade
		NegociacaoAtividadeTeste.cadastrarNegociacaoAtividade();
		
		cadastraQualificacaoAtividade();
		consultaQualificacaoAtividade();
		alteraQualificacaoAtividade();
		listaQualificacaoAtividade();
		
	}

	public static void cadastraQualificacaoAtividade(){

		qa = new QualificacaoAtividade();
		
		n = nBO.buscar(1);
		sc = scBO.buscar(n);
		
		na = nBO.buscarPorNegociacao(1);
		
		qa.setServicoConcluido(sc);
		qa.setAtividadeNegociada(na);
		qa.setComentarios("Nois");
		qa.setDataQuaificacao(Calendar.getInstance());
		qa.setEstrelas(3);
		qa.setPositivo("Sim");
		qa.setNegativo("Não");
		
		qaBO.cadastrar(qa, scBO.buscar(nBO.buscar(1)));
		
		System.out.println("Qualificação atividade efetuada com Sucesso!");
		
	}
	
	public static void consultaQualificacaoAtividade(){
		
		try {
			
			QualificacaoAtividade qa = qaBO.buscar(1, sc);
			
			if(qa != null){
				
				System.out.println(qa.getCodigo());
				System.out.println(qa.getServicoConcluido().getId());
				System.out.println(qa.getAtividadeNegociada().getId());
				System.out.println(qa.getServicoConcluido().getNegociacao().getProtocolo());
				System.out.println(qa.getComentarios());
				System.out.println(qa.getEstrelas());
				System.out.println(qa.getDataQuaificacao());
				System.out.println(qa.getPositivo());
				System.out.println(qa.getNegativo());
				
			}else {
				System.out.println("Qualificação Atividade inexistente");
			}
			
		} catch (Exception e) {
			System.out.println("Não encontrou qualificação atividade!!! ");
			e.printStackTrace();
		}
		
	}
	
	public static void alteraQualificacaoAtividade(){
		
		qa.setComentarios("Vamooooooooos");
		qaBO.alterar(qa);
		
		System.out.println("Qualificação Atividade alterada!");
		
	}
	
	public static void listaQualificacaoAtividade(){
		
		lista = qaBO.listarPorServicoConcluido(sc);
		
		for (QualificacaoAtividade qa : lista) {
			
			System.out.println(qa.getCodigo());
			System.out.println(qa.getServicoConcluido());
			System.out.println(qa.getAtividadeNegociada());
			System.out.println(qa.getComentarios());
			System.out.println(qa.getEstrelas());
			System.out.println(qa.getDataQuaificacao());
			System.out.println(qa.getPositivo());
			System.out.println(qa.getNegativo());
			
		}
		
	}
	
}
