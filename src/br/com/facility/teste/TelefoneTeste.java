package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.TelefoneBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoTelefone;
import br.com.facility.to.Telefone;

public class TelefoneTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static TelefoneBO tBo = new TelefoneBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static Telefone t;
	
	
	public static void main(String[] args) {
	
		UsuarioTeste.cadastraUsuario();
		
		cadastraTelefone();
		consultaTelefone();
		listaTelefones();
		
		alteraTelefone();
		listaTelefones();
		
		deletaTelefone();
		listaTelefones();
		
	}
	
	private static void cadastraTelefone(){
		
		t = new Telefone();
		t.setCodigoPais(1);
		t.setDdd(11);
		t.setNumero(98765432);
		t.setOperadora("TIM");
		t.setTipo(TipoTelefone.CELULAR);
		t.setUsuario(uBO.buscar(1));
		
		tBo.cadastrar(t);
		
		System.out.println("**Telefone cadastrado**");
	}
	
	private static void consultaTelefone(){
		
		Telefone telefone = tBo.buscar(1, uBO.buscar(1));
		
		if (telefone != null) {
			System.out.println(telefone.getDdd());
			System.out.println(telefone.getNumero());
			System.out.println(telefone.getTipo());
			System.out.println(telefone.getUsuario().getUsername());
		}
		
	}
	
	private static void listaTelefones() {
		
		List<Telefone> lstTelefone = tBo.listarPorUsuario(uBO.buscar(1));
		
		if(lstTelefone != null){
			
			for (Telefone telefone : lstTelefone) {
				System.out.println(telefone.getDdd());
				System.out.println(telefone.getNumero());
				System.out.println(telefone.getTipo());
				System.out.println(telefone.getUsuario().getUsername());
			}
		}else{
			System.out.println("**Usuário não tem telefone cadastrado**");
		}
		
	}
	
	private static void deletaTelefone(){
		
		tBo.remover(t);
		System.out.println("**Telefone deletado**");
		
	}
	
	private static void alteraTelefone(){
		t.setNumero(98761234);
		tBo.alterar(t);
		
		System.out.println("**Telefone alterado**");
	}
}
