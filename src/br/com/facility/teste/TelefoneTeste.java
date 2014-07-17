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
	
		cadastraTelefone();
		listaTelefones();
		
		alteraTelefone();
		listaTelefones();
		
		deletaTelefone();
		listaTelefones();
		
	}
	
	public static void cadastraTelefone(){
		
		t = new Telefone();
		t.setCodigoPais(1);
		t.setDdd(11);
		t.setNumero(98765432);
		t.setOperadora("TIM");
		t.setTipo(TipoTelefone.CELULAR);
		t.setUsuario(uBO.consultar(1));
		
		tBo.inserir(t);
		
		System.out.println("**Telefone cadastrado**");
	}
	
	//Lista Por Usu�rios
	public static void listaTelefones() {
		
		List<Telefone> lstTelefone = tBo.listarTodos(uBO.consultar(1));
		
		if(lstTelefone != null){
			
			for (Telefone telefone : lstTelefone) {
				System.out.println(telefone.getDdd());
				System.out.println(telefone.getNumero());
				System.out.println(telefone.getTipo());
				System.out.println(telefone.getUsuario().getUsername());
			}
		}else{
			System.out.println("**Usu�rio n�o tem telefone cadastrado**");
		}
		
	}
	
	public static void deletaTelefone(){
		
		tBo.remover(t);
		System.out.println("**Telefone deletado**");
		
	}
	
	public static void alteraTelefone(){
		t.setNumero(98761234);
		tBo.alterar(t);
		
		System.out.println("**Telefone alterado**");
	}
}
