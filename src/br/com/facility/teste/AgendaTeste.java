package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AgendaBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusAgenda;
import br.com.facility.enums.TipoAgenda;
import br.com.facility.to.Agenda;
import br.com.facility.to.Negociacao;

public class AgendaTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static AgendaBO aBO = new AgendaBO(em);
	private static Negociacao n;
	private static Agenda a1;
	private static Agenda a2;
	private static List<Agenda> lista;
	
	public static void main(String[] args) {
		
		// chama estaticamente os métodos do teste de Usuario e Projeto
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		// AGENDA
		registraAgenda();
		consultaAgenda();
		
		alteraAgenda();
		listaAgendas();
		
	}
	
	public static void registraAgenda(){
		
		n = nBO.buscar(1);
		
		a1 = new Agenda();
		a1.setTipo(TipoAgenda.SERVICO);
		a1.setData(Calendar.getInstance());
		a1.setDataTermino(Calendar.getInstance());
		
		a2 = new Agenda();
		a2.setTipo(TipoAgenda.ORCAMENTO);
		a2.setData(Calendar.getInstance());
		a2.setHorasPrevistas(2);
		
		aBO.cadastrar(a1, n);
		System.out.println("**Agenda registrada**");
		
		aBO.cadastrar(a2, n);
		System.out.println("**Agenda registrada**");
	}
	
	public static void consultaAgenda(){
		
		Agenda a = aBO.buscar(1, n);
		
		if (a != null) {
			System.out.println(a.getCodigo());
			System.out.println(a.getTipo());
			System.out.println(a.getNegociacao().getProtocolo());
			System.out.println(a.getUsuario().getUsername());
			System.out.println(a.getData().getTime());
			if (a.getTipo() == TipoAgenda.SERVICO) {
				System.out.println(a.getDataTermino().getTime());
			} else {
				System.out.println(a.getHorasPrevistas());
			}
			System.out.println(a.getStatus());
			System.out.println(a.getDataStatus().getTime());
		}
		
	}
	
	public static void alteraAgenda(){
		
		aBO.alterarStatus(a1, StatusAgenda.APROVADO);
		
		a2.setHorasPrevistas(3);
		aBO.alterar(a2);
		
	}
	
	public static void listaAgendas(){
		
		lista = aBO.listarPorNegociacao(n);
		//lista = aBO.listarPorUsuario(n.getUsuario());
		//lista = aBO.listarPorProfissional(n.getProfissional());
		
		for (Agenda a : lista) {
			System.out.println(a.getCodigo());
			System.out.println(a.getTipo());
			System.out.println(a.getNegociacao().getProtocolo());
			System.out.println(a.getUsuario().getUsername());
			System.out.println(a.getData().getTime());
			if (a.getTipo() == TipoAgenda.SERVICO) {
				System.out.println(a.getDataTermino().getTime());
			} else {
				System.out.println(a.getHorasPrevistas());
			}
			System.out.println(a.getStatus());
			System.out.println(a.getDataStatus().getTime());
		}
		
	}

}
