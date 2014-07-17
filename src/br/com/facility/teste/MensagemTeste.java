package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.MensagemBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Mensagem;
import br.com.facility.to.Negociacao;

public class MensagemTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static MensagemBO mBO = new MensagemBO(em);
	private static Negociacao n;
	private static Mensagem m1;
	private static Mensagem m2;
	private static List<Mensagem> lista;
	
	public static void main(String[] args) {
		
		// chama estaticamente os métodos do teste de Usuario e Projeto
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		// MENSAGEM
		registaMensagem();
		recuperaMensagem();
		
		listaMensagens();
		
	}
	
	public static void registaMensagem(){
		
		n = nBO.consultar(1);
		
		m1 = new Mensagem();
		m1.setTexto("Mensagem teste 1");
		
		m2 = new Mensagem();
		m2.setTexto("Mensagem teste 2");
		
		mBO.registrar(m1, n);
		System.out.println("**Mensagem registrada**");
		
		mBO.registrar(m2, n);
		System.out.println("**Mensagem registrada**");
		
	}
	
	public static void recuperaMensagem(){
		
		Mensagem m = mBO.consultar(1, n);
		
		if (m != null) {
			System.out.println(m.getCodigo());
			System.out.println(m.getTexto());
			System.out.println(m.getNegociacao().getProtocolo());
			
			// TODO buscar melhor forma de buscar nomes do Usuario e Profissional
			System.out.println(m.getNegociacao().getUsuario().getUsername());
			//System.out.println(m.getNegociacao().getProfissional().get);
			
			System.out.println(m.getDataEnvio().getTime());
		}
		
	}
	
	public static void listaMensagens(){
		
		lista = mBO.listarPorNegociacao(n);
		
		for (Mensagem m : lista) {
			System.out.println(m.getCodigo());
			System.out.println(m.getTexto());
			System.out.println(m.getNegociacao().getProtocolo());
			System.out.println(m.getNegociacao().getUsuario().getUsername());
			//System.out.println(m.getNegociacao().getProfissional().get);
			System.out.println(m.getDataEnvio().getTime());
		}
		
	}
	
}
