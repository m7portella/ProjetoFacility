package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AmigoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusAmigo;
import br.com.facility.enums.TipoAmigo;
import br.com.facility.to.Amigo;
import br.com.facility.to.Usuario;

public class AmigoTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static AmigoBO aBO = new AmigoBO(em);
	private static Usuario u1;
	private static Usuario u2;
	private static Usuario u3;
	private static Amigo a;
	private static Amigo a2;
	private static List<Amigo> lista;
	
	public static void main(String[] args) {
		
		adicionaUsuarios();
		consultaUsuarios();
		adicionaAmigos();
		consultaAmigo();
		
		alteraAmigo();
		consultaAmigo();
		
		deletaAmigo();
		consultaAmigo();
		
		listaAmigos();
		
	}
	
	private static void listaAmigos(){
		
		lista = aBO.listarAmigos(u1);
		
		if (lista != null) {
			System.out.println("**Lista de amigos**");
			for (Amigo a : lista) {
				System.out.println(a.getAmigo().getUsername());
			}
		} else {
			System.out.println("**Lista de amigos vazia**");
		}
		
	}
	
	private static void alteraAmigo(){
		aBO.alterarStatus(a, StatusAmigo.ATIVO);
		aBO.alterarTipo(a, TipoAmigo.PROFISSIONAL);
		aBO.favoritar(a2, true);
		
		System.out.println("**Amigo alterado**");
	}
	
	private static void deletaAmigo(){
		aBO.excluir(a);
	}
	
	public static void consultaAmigo(){
		
		a = aBO.consultar(u1, u2);
		
		if (a != null) {
			System.out.println(a.getUsuario().getUsername());
			System.out.println(a.getAmigo().getUsername());
			System.out.println(a.getTipo());
			System.out.println(a.isFavorito());
			System.out.println(a.getDataAdicionado().getTime());
			System.out.println(a.getStatus());
			System.out.println(a.getDataStatus().getTime());
		} else {
			System.out.println("**Amigo não encotrado**");
		}
		
		
		a2 = aBO.consultar(u2, u1);
		
		if (a != null) {
			System.out.println(a2.getUsuario().getUsername());
			System.out.println(a2.getAmigo().getUsername());
			System.out.println(a2.getTipo());
			System.out.println(a2.isFavorito());
			System.out.println(a2.getDataAdicionado());
			System.out.println(a2.getStatus());
			System.out.println(a2.getDataStatus());
		} else {
			System.out.println("**Amigo não encotrado**");
		}
		
	}
	
	public static void adicionaAmigos(){
		
		aBO.adicionar(u1, u2, TipoAmigo.AMIGO);
		System.out.println("**Amigo adicionado**");
		
		aBO.adicionar(u1, u3, TipoAmigo.AMIGO);
		System.out.println("**Amigo adicionado**");
		
	}
	
	public static void consultaUsuarios(){
		u1 = uBO.consultar(1);
		u2 = uBO.consultar(2);
		u3 = uBO.consultar(3);
	}
	
	public static void adicionaUsuarios(){
		
		u1 = new Usuario();
		u1.setUsername("m7portella");
		u1.setEmail("m7portella@gmail.com");
		u1.setSenha("123456");
		uBO.inserir(u1);
		System.out.println("**Usuário cadastrado**");
		
		u2 = new Usuario();
		u2.setUsername("amandayuri");
		u2.setEmail("amandayurike@gmail.com");
		u2.setSenha("123456");
		uBO.inserir(u2);
		System.out.println("**Usuário cadastrado**");
		
		u3 = new Usuario();
		u3.setUsername("anderssongalves");
		u3.setEmail("anderssongalves@gmail.com");
		u3.setSenha("123456");
		uBO.inserir(u3);
		System.out.println("**Usuário cadastrado**");
		
	}

}
