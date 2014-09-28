package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Projeto;

public class NegociacaoTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static ProjetoBO pBO = new ProjetoBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static Projeto pj;
	private static Profissional pf;
	private static Negociacao n;
	private static List<Negociacao> lista;
	
	public static void main(String[] args) {
		
		// chama estaticamente os métodos do teste de Usuario e Projeto
//		UsuarioTeste.cadastraUsuario();
//		UsuarioTeste.cadastraClienteFisico();
//		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		
		// NEGOCIACAO
//		consultaNegociacao();
		
		cadastraNegociacao();
		consultaNegociacao();
		
//		alteraNegociacao();
//		consultaNegociacao();
//		
//		deletaNegociacao();
//		consultaNegociacao();
//		
//		listaNegociacoes();
		
	}
	
	public static void cadastraNegociacao(){
		
		// busca Projeto e Profissional no BD
		pj = pBO.buscar(1);
		pf = uBO.buscarProfissional(1);
		
		n = new Negociacao();
		
		nBO.cadastrar(n, pj, pf);
		System.out.println("**Negociacao cadastrada**");
	}
	
	public static void consultaNegociacao(){
		Negociacao n = nBO.buscar(1);
		
		if (n != null) {
			
			System.out.println(n.getProtocolo());
			System.out.println(n.getProjeto().getTitulo());
			
			// precisamos arrumar um jeito de evitar isso!!
			TipoPessoa t = n.getProfissional().getTipo();
			if (t == TipoPessoa.FISICA) {
				System.out.println(n.getProfissional().getClienteFisico().getNome());
			} else {
				System.out.println(n.getProfissional().getClienteJuridico().getNomeFantasia());
			}
			
			// e de pegar mais facilmente o nome o usuÃ¡rio tbm
			System.out.println(n.getUsuario().getUsername());
			
			System.out.println(n.getDataSolicitacao().getTime());
			System.out.println(n.getStatus());
			System.out.println(n.getDataStatus().getTime());
			
		} else {
			System.out.println("**Negociacao não existe**");
		}
		
	}
	
	public static void alteraNegociacao(){
		n.setStatus(StatusNegociacao.CONCLUIDO);
		nBO.alterar(n);
		System.out.println("**Negociacao alterada**");
	}
	
	public static void deletaNegociacao(){
		nBO.deletar(n);
		System.out.println("**Negociacao deletada**");
	}
	
	public static void listaNegociacoes(){
		lista = nBO.listarPorUsuario(pj.getUsuario());
		
		for (Negociacao n : lista) {
			
			System.out.println(n.getProtocolo());
			System.out.println(n.getProjeto().getTitulo());
			
			TipoPessoa t = n.getProfissional().getTipo();
			if (t == TipoPessoa.FISICA) {
				System.out.println(n.getProfissional().getClienteFisico().getNome());
			} else {
				System.out.println(n.getProfissional().getClienteJuridico().getNomeFantasia());
			}

			System.out.println(n.getUsuario().getUsername());
			System.out.println(n.getDataSolicitacao().getTime());
			System.out.println(n.getStatus());
			System.out.println(n.getDataStatus().getTime());
			
		}
	}

}
