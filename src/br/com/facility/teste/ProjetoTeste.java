package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class ProjetoTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static ProjetoBO pBO = new ProjetoBO(em);
	private static Usuario u;
	private static Projeto p1;
	private static Projeto p2;
	private static List<Projeto> lista;
	
	public static void main(String[] args) {
		
		// chama estaticamente os métodos do teste de Usuario
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		
		// PROJETO
		cadastraProjeto();
		consultaProjeto();
		
		alteraProjeto();
		consultaProjeto();
		
		deletaProjeto();
		consultaProjeto();
		
		listaProjetos();
		
	}

	public static void cadastraProjeto(){
		u = uBO.buscar(2);
		
		p1 = new Projeto();
		p1.setTitulo("Reforma do piso da sala");
		p1.setDescricao("Troca do piso da sala por porcelanato");
		pBO.cadastrar(p1, u);
		System.out.println("**Projeto cadastrado**");
		
		p2 = new Projeto();
		p2.setTitulo("Festa de aniversário");
		p2.setDescricao("Festa XPTO de aniversário");
		pBO.cadastrar(p2, u);
		System.out.println("**Projeto cadastrado**");
	}
	
	public static void consultaProjeto(){
		Projeto p = pBO.buscar(1);
		
		if (p != null) {
			System.out.println(p.getId());
			System.out.println(p.getUsuario().getUsername());
			System.out.println(p.getTitulo());
			System.out.println(p.getDescricao());
			System.out.println(p.getDataAbertura().getTime());
			System.out.println(p.getStatus());
			System.out.println(p.getDataStatus().getTime());
		} else {
			System.out.println("**Projeto não existe**");
		}
	}
	
	public static void alteraProjeto(){
		p1.setDescricao("Colocar porcelanato na sala");
		pBO.alterar(p1);
		
		System.out.println("**Projeto alterado**");
	}
	
	public static void deletaProjeto(){
		pBO.deletar(p1);
		System.out.println("**Projeto deletado**");
	}
	
	public static void listaProjetos(){
		lista = pBO.listarPorUsuario(u);
		
		for (Projeto p : lista) {
			System.out.println(p.getId());
			System.out.println(p.getUsuario().getUsername());
			System.out.println(p.getTitulo());
			System.out.println(p.getDescricao());
			System.out.println(p.getDataAbertura().getTime());
			System.out.println(p.getStatus());
			System.out.println(p.getDataStatus().getTime());
		}
	}
	
}
