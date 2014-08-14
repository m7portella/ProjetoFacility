package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.QualificacaoBO;
import br.com.facility.bo.ServicoConcluidoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoQualificacao;
import br.com.facility.to.Qualificacao;

public class QualificacaoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static QualificacaoBO qBO = new QualificacaoBO(em);
	private static ServicoConcluidoBO scBO = new ServicoConcluidoBO(em);
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	//private static ServicoConcluido sc;
	private static Qualificacao q;
	private static List<Qualificacao> lista;
	
	
	public static void main(String[] args) {
		
		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
			
		// SERVICO CONCLUIDO
		ServicoConcluidoTeste.cadastraServicoConcluido();
		
		//Cadastrar Qualificação
		cadastraQualificacao();
		
		consultaQualificacao();
		
		alteraQualificacao();
		
		listaQualificacao();
		
	}
	
	public static void cadastraQualificacao(){

		q = new Qualificacao();
		
		q.setServicoConcluido(scBO.buscar(nBO.buscar(1)));
		q.setTipo(TipoQualificacao.PRECO);
		q.setEstrelas(3);
		q.setDescricao("Ótimo preço garotinhos!");
		q.setDataQualificacao(Calendar.getInstance());
		
		qBO.cadastrar(q, scBO.buscar(nBO.buscar(1)));
		
		System.out.println("Qualificação efetuada com Sucesso!");
		
	}
	
	public static void consultaQualificacao(){
		
		try {
			
			Qualificacao q = qBO.buscar(1, scBO.buscar(nBO.buscar(1)));
			
			if(q != null){
				
				System.out.println(q.getCodigo());
				System.out.println(q.getServicoConcluido().getId());
				System.out.println(q.getServicoConcluido().getNegociacao().getProtocolo());
				System.out.println(q.getDescricao());
				System.out.println(q.getEstrelas());
				System.out.println(q.getDataQualificacao());
				System.out.println(q.getTipo());
				
			}else {
				System.out.println("Qualificação inexistente");
			}
			
		} catch (Exception e) {
			System.out.println("Não encontrou qualificação!!! ");
			e.printStackTrace();
		}
		
	}
	
	public static void alteraQualificacao(){
		
		q.setDescricao("Ossooooo no caroçoo!!!");
		qBO.alterar(q);
		
		System.out.println("Qualificação alterada!");
		
	}
	
	public static void listaQualificacao(){
		
		lista = qBO.listarPorServicoConcluido(scBO.buscar(nBO.buscar(1)));
		
		for (Qualificacao q : lista) {
			
			System.out.println(q.getCodigo());
			System.out.println(q.getServicoConcluido());
			System.out.println(q.getDescricao());
			System.out.println(q.getEstrelas());
			System.out.println(q.getDataQualificacao());
			System.out.println(q.getTipo());
			
		}
		
	}
	
}
