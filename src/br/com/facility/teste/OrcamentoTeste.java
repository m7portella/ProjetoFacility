package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.OrcamentoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoPreco;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Orcamento;

public class OrcamentoTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static OrcamentoBO oBO = new OrcamentoBO(em);
	private static Negociacao n;
	private static Orcamento o1, o2;
	private static List<Orcamento> lista;

	public static void main(String[] args) {
		
		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		// ORCAMENTO
		cadastraOrcamento();
		listaOrcamentos();
		
		alteraOrcamento();
		recuperaOrcamento();
		
	}
	
	public static void cadastraOrcamento(){
		
		n = nBO.consultar(1);
		
		o1 = new Orcamento();
		o1.setValorTotal(1234.5);
		o1.setTipoDuracao(TipoPreco.HORA);
		o1.setDuracao(15);
		
		o2 = new Orcamento();
		o2.setValorTotal(300);
		o2.setTipoDuracao(TipoPreco.DIA);
		o2.setDuracao(1);
		o2.setObservacao("bla bla bla");
		
		oBO.registrar(o1, n);
		System.out.println("**Orcamento registrado**");
		
		oBO.registrar(o2, n);
		System.out.println("**Orcamento registrado**");
		
	}
	
	public static void recuperaOrcamento(){
		
		Orcamento o = oBO.consultar(1, n);
		
		System.out.println(o.getCodigo());
		System.out.println(o.getNegociacao().getProtocolo());
		System.out.println(o.getUsuario().getUsername());
		System.out.println(o.getValorTotal());
		System.out.println(o.getTipoDuracao());
		System.out.println(o.getDuracao());
		System.out.println(o.getStatus());
		System.out.println(o.getDataStatus().getTime());
		System.out.println(o.getObservacao());
		
	}
	
	public static void alteraOrcamento(){
		o1.setValorTotal(666);
		oBO.alterar(o1);
		System.out.println("**Orcamento alterado**");
	}
	
	public static void listaOrcamentos(){
		
		lista = oBO.listarPorNegociacao(n);
		//lista = oBO.listarPorUsuario(n.getUsuario());
		//lista = oBO.listarPorProfissional(n.getProfissional());
		
		for (Orcamento o : lista) {
			System.out.println(o.getCodigo());
			System.out.println(o.getNegociacao().getProtocolo());
			System.out.println(o.getUsuario().getUsername());
			System.out.println(o.getValorTotal());
			System.out.println(o.getTipoDuracao());
			System.out.println(o.getDuracao());
			System.out.println(o.getStatus());
			System.out.println(o.getDataStatus().getTime());
			System.out.println(o.getObservacao());
		}
		
	}
	
}
