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
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;
import br.com.facility.to.Usuario;

/**
 * @author Andersson
 * 
 * Data: 20/07/2014
 *
 */
public class ResponsavelTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static ResponsavelBO rBO = new ResponsavelBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static Usuario u1;
	private static ClienteJuridico cj;
	private static Responsavel r;
	private static List<Responsavel> lista;
	
	public static void main(String[] args) {
		
		// USUARIO
		cadastraUsuario();

		// CLIENTE JURIDICO
		cadastraClienteJuridico();
		
		// RESPONSAVEL
		cadastraResponsavel();
		consultaResponsavel();
		
		//alteraResponsavel();
		//deletaResponsavel();
		
	}
	
	public static void cadastraUsuario() {

		u1 = new Usuario();
		u1.setUsername("kiko");
		u1.setEmail("kiko@gmail.com");
		u1.setSenha("9999");
		u1.setTokenApi("i8zIUe9YdeS35T5y2WtgeT9");
	
		uBO.cadastrar(u1);
	}
	
	public static void cadastraClienteJuridico() {
		
		cj = new ClienteJuridico();

		cj.setNomeFantasia("TesteResponsavel");
		cj.setRazaoSocial("TesteResponsavel S/A");
		cj.setCnpj("245678989063");
		
		uBO.cadastrarClienteJuridico(u1, cj);
		
		System.out.println("**Cliente Juridico cadastrado**");
		
	}
	
	public static void cadastraResponsavel(){
		
		
		
		r = new Responsavel();
		r.setCpf("123456789");
		r.setNome("Ronaldo");
		r.setSobrenome("dos Santos");
		r.setEmail("ronaldo@uol.com.br");
		r.setDataCadastro(Calendar.getInstance());
		r.setHierarquia(HierarquiaResponsavel.PRINCIPAL);
		
		
		rBO.cadastrar(r, cj);
		System.out.println("**Responsavel cadastrado**");
		
	}
	
	public static void consultaResponsavel(){
		Responsavel r = rBO.consultar(1);
		
		if (r != null) {
			System.out.println(r.getClienteJuridico().getUsuario().getId());
			System.out.println(r.getClienteJuridico().getUsuario().getEmail());
			System.out.println(r.getClienteJuridico().getUsuario().getUsername());
			System.out.println(r.getClienteJuridico().getId());
			System.out.println(r.getClienteJuridico().getCnpj());
			System.out.println(r.getClienteJuridico().getNomeFantasia());
			System.out.println(r.getClienteJuridico().getRazaoSocial());
			System.out.println(r.getId());
			System.out.println(r.getCpf());
			System.out.println(r.getNome());
			System.out.println(r.getSobrenome());
			System.out.println(r.getEmail());
			System.out.println(r.getHierarquia());
		} else {
			System.out.println("**Responsavel não existe**");
		}
	}
	
	public static void alteraResponsavel(){
		r.setNome("Adriano");
		rBO.alterar(r);
		
		System.out.println("**Responsavel alterado**");
	}
	
	public static void deletaResponsavel(){
		rBO.excluir(r);
		System.out.println("**Responsavel deletado**");
	}
	
	public static void listaResponsavel(){
		lista = rBO.listarPorCliente(cj);
		
		for (Responsavel r : lista) {
			System.out.println(r.getId());
			System.out.println(r.getClienteJuridico());
			System.out.println(r.getCpf());
			System.out.println(r.getNome());
			System.out.println(r.getSobrenome());
			System.out.println(r.getEmail());
			System.out.println(r.getHierarquia());
			
		}
	}

}
