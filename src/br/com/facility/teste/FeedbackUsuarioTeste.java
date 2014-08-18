package br.com.facility.teste;

import javax.persistence.EntityManager;

import br.com.facility.bo.FeedbackUsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.FeedbackUsuario;
import br.com.facility.to.Usuario;

public class FeedbackUsuarioTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	
	private static Usuario u1 = new Usuario();
	
	private static FeedbackUsuario f1 = new FeedbackUsuario();
	private static FeedbackUsuario f2 = new FeedbackUsuario();
	
	private static FeedbackUsuarioBO fBO = new FeedbackUsuarioBO(em);
	
	public static void cadastrarUsuario() {
		u1 = new Usuario();
		u1.setUsername("m7portella");
		u1.setEmail("m7portella@gmail.com");
		u1.setSenha("123456");
		u1.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
	}
	
	public static void cadastrar() {
		f1.setRecomendacao(123);
		//TIPO RESOLUÇÃO É UM ENUM (CORRIGIR O MAIS BREVE POSSÍVEL)
		f1.setResolucao("Resolução");
		f1.setUsuario(u1);
		f1.setDepoimento("Depoimento Aqui!");
		
		fBO.cadastrar(f1);
		System.out.println("\n*** FEEDBACK CADASTRADO ***\n");
	}
	
	public static void consultar() {
		f2 = fBO.consultar(f1.getId());
		System.out.println(
				"\nID: ................ " + f2.getId() +
				"\nRecomendacao: ...... " + f2.getRecomendacao() +
				"\nResolucao: ......... " + f2.getResolucao() +
				"\nDepoimento: ........ " + f2.getDepoimento() +
				"\nUsuario: ........... " + f2.getUsuario()
				);
	}
	
	public static void remover() {
		fBO.remover(f1.getId());
		System.out.println("\n*** FEEDBACK REMOVIDO ***\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
