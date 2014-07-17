package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.PagamentoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoPagamento;
import br.com.facility.to.Mensagem;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Pagamento;

public class PagamentoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static PagamentoBO pBO = new PagamentoBO(em);
	private static Negociacao n;
	private static Pagamento p1;
	private static Pagamento p2;
	private static List<Pagamento> lista;
	
	public static void main(String[] args) {
		
		// chama estaticamente os métodos do teste de Usuario e Projeto
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		// PAGAMENTO
		registaPagamento();
		recupoeraPagamento();
		
		alteraPagamento();
		recupoeraPagamento();
		
		listaPagamentos();
		
	}
	
	public static void registaPagamento(){
		
		n = nBO.consultar(1);
		
		p1 = new Pagamento();
		p1.setTipo(TipoPagamento.INTERMEDIADO);
		p1.setMeioPagamento("PagSeguro");
		p1.setCodigoProcessamento(1234567890);
		p1.setValorTotal(119.9);
		
		p2 = new Pagamento();
		p2.setTipo(TipoPagamento.PARTICULAR);
		p2.setMeioPagamento("x");
		
		pBO.registrar(p1, n);
		System.out.println("**Pagamento registrado**");
		
		pBO.registrar(p2, n);
		System.out.println("**Pagamento registrado**");
		
	}
	
	public static void recupoeraPagamento(){
		 Pagamento p = pBO.consultar(1);
		 
		 if (p != null) {
			
			 System.out.println(p.getId());
			 System.out.println(p.getNegociacao().getProtocolo());
			 System.out.println(p.getUsuario().getUsername());
			 System.out.println(p.getTipo());
			 System.out.println(p.getMeioPagamento());
			 System.out.println(p.getCodigoProcessamento());
			 System.out.println(p.getValorTotal());
			 System.out.println(p.getData().getTime());
			 System.out.println(p.getStatus());
			 System.out.println(p.getDataStatus().getTime());
			 
		}
	}
	
	public static void alteraPagamento(){
		p1.setValorTotal(200);
		pBO.alterar(p1);
		System.out.println("**Pagamento alterado**");
	}
	
	public static void listaPagamentos(){
		
		lista = pBO.listarPorNegociacao(n);
		lista = pBO.listarPorUsuario(n.getUsuario());
		lista = pBO.listarPorProfissional(n.getProfissional());
		
		for (Pagamento p : lista) {
			System.out.println(p.getId());
			 System.out.println(p.getNegociacao().getProtocolo());
			 System.out.println(p.getUsuario().getUsername());
			 System.out.println(p.getTipo());
			 System.out.println(p.getMeioPagamento());
			 System.out.println(p.getCodigoProcessamento());
			 System.out.println(p.getValorTotal());
			 System.out.println(p.getData().getTime());
			 System.out.println(p.getStatus());
			 System.out.println(p.getDataStatus().getTime());
		}
		
	}
	
}
