package br.com.facility.teste;

import java.util.Calendar;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.enums.StatusUsuario;
import br.com.facility.to.Usuario;

public class UsuarioTeste {
	
	private static UsuarioBO uBO = new UsuarioBO();
	private static Usuario u;
	
	public static void main(String[] args) {
		
		cadastraUsuario();
		recuperaUsuario();
		
		alteraUsuario();
		recuperaUsuario();
		
		deletaUsuario();
		recuperaUsuario();
		
		removeUsuario();
		recuperaUsuario();
		
	}
	
	public static void cadastraUsuario(){
		
		u = new Usuario();
		u.setUsername("m7portella");
		u.setEmail("m7portella@gmail.com");
		u.setSenha("123456");
		u.setDataCadastro(Calendar.getInstance());
		u.setStatus(StatusUsuario.ATIVO);
		u.setDataStatus(Calendar.getInstance());
		u.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
		
		uBO.inserir(u);
		
		System.out.println("**Usuário cadastrado**");
		
	}
	
	public static void recuperaUsuario(){
		
		u = uBO.recuperar(1);
		
		if (u != null) {
			
			System.out.println(u.getId());
			System.out.println(u.getUsername());
			System.out.println(u.getEmail());
			System.out.println(u.getSenha());
			System.out.println(u.getDataCadastro().getTime());
			System.out.println(u.getStatus());
			System.out.println(u.getDataStatus().getTime());
			System.out.println(u.getTokenApi());
			
		} else {

			System.out.println("**Usuário não existe**");
			
		}
		
	}
	
	public static void alteraUsuario(){
		
		u.setEmail("marcelo@facility.com.br");
		System.out.println("**Usuário alterado**");
		
	}
	
	public static void deletaUsuario(){
		
		uBO.deletar(u);
		System.out.println("**Usuário deletado**");
		
	}
	
	public static void removeUsuario(){
		
		uBO.remover(u);
		
	}

}
