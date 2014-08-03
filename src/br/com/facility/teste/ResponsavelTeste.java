/**
 * 
 */
package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.ResponsavelBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.HierarquiaResponsavel;
import br.com.facility.to.Responsavel;


public class ResponsavelTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static ResponsavelBO rBO = new ResponsavelBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static Responsavel r;
	private static List<Responsavel> lista;
	
	public static void main(String[] args) {
		
		// Usuï¿½rio e Cliente Juridico
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteJuridico();
		
		// RESPONSAVEL
		cadastraResponsavel();
		
		consultaResponsavel();
		
		listaResponsavel();
		
		//alteraResponsavel();
		//deletaResponsavel();
		
	}
	
	public static void cadastraResponsavel(){

		r = new Responsavel();
		
		r.setClienteJuridico(uBO.buscarClienteJuridico(3));
		
		r.setCpf("37794014875");
		r.setNome("Ronaldo");
		r.setSobrenome("dos Santos");
		r.setEmail("ronaldo@uol.com.br");
		r.setDataCadastro(Calendar.getInstance());
		r.setHierarquia(HierarquiaResponsavel.PRINCIPAL);
		
		
		rBO.cadastrar(r, uBO.buscarClienteJuridico(3));
		System.out.println("**Responsavel cadastrado**");
		
	}
	
	public static void consultaResponsavel(){
		
		try {
			
			Responsavel r = rBO.buscar(1,uBO.buscarClienteJuridico(3));
			
			if (r != null) {
				System.out.println(r.getClienteJuridico().getUsuario().getId());
				System.out.println(r.getClienteJuridico().getUsuario().getEmail());
				System.out.println(r.getClienteJuridico().getUsuario().getUsername());
				System.out.println(r.getClienteJuridico().getId());
				System.out.println(r.getClienteJuridico().getCnpj());
				System.out.println(r.getClienteJuridico().getNomeFantasia());
				System.out.println(r.getCodigo());
				System.out.println(r.getCpf());
				System.out.println(r.getNome());
				System.out.println(r.getSobrenome());
				System.out.println(r.getEmail());
				System.out.println(r.getHierarquia());
			} else {
				System.out.println("**Responsavel nãoo existe**");
			}
			
		} catch (Exception e) {
			System.out.println("Não encontrou cliente juridico!!! ");
			e.printStackTrace();
		}
		
	}
	
	public static void alteraResponsavel(){
		r.setNome("Adriano");
		rBO.alterar(r);
		
		System.out.println("**Responsavel alterado**");
	}
	
	public static void deletaResponsavel(){
		rBO.deletar(r);
		System.out.println("**Responsavel deletado**");
	}
	
	public static void listaResponsavel(){
		lista = rBO.listarPorCliente(uBO.buscarClienteJuridico(3));
		
		for (Responsavel r : lista) {
			System.out.println(r.getCodigo());
			System.out.println(r.getClienteJuridico());
			System.out.println(r.getCpf());
			System.out.println(r.getNome());
			System.out.println(r.getSobrenome());
			System.out.println(r.getEmail());
			System.out.println(r.getHierarquia());
			
		}
	}

}
