package br.com.facility.teste;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.to.Usuario;

public class UsuarioTeste {
	
	private static UsuarioBO uBO = new UsuarioBO();
	private static Usuario u;
	
	public static void main(String[] args) {
		
		cadastraUsuario();
		consultaUsuario();
		
		ativarUsuario();
		consultaUsuario();
		
		alteraUsuario();
		consultaUsuario();
		
		deletaUsuario();
		consultaUsuario();
		
		removeUsuario();
		consultaUsuario();
		
	}
	
	public static void cadastraUsuario(){
		
		u = new Usuario();
		u.setUsername("m7portella");
		u.setEmail("m7portella@gmail.com");
		u.setSenha("123456");
		u.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
		
		uBO.inserir(u);
		
		System.out.println("**Usuário cadastrado**");
		
	}
	
	public static void consultaUsuario(){
		
		u = uBO.consultar(1);
		
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
		System.out.println("**Usuário removido**");
		
	}
	
	public static void ativarUsuario(){
		
		uBO.ativar(u);
		System.out.println("**Usuário ativado**");
		
	}

}
