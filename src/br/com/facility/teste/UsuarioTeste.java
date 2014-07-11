package br.com.facility.teste;

import javax.persistence.EntityManager;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.Sexo;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.Usuario;

public class UsuarioTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static Usuario u;
	private static ClienteFisico cf;

	
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
		
		consultaClienteFisicoPorUsuario();
		
		cadastraClienteFisico();
		consultaClienteFisicoPorId();

	}

	public static void cadastraUsuario() {

		u = new Usuario();
		u.setUsername("m7portella");
		u.setEmail("m7portella@gmail.com");
		u.setSenha("123456");
		u.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		uBO.inserir(u);

		System.out.println("**Usuário cadastrado**");

	}

	public static void consultaClienteFisicoPorUsuario() {

		cf = uBO.consultarClienteFisico(u);

		if (cf != null) {

			System.out.println(cf.getUsuario().getId());
			System.out.println(cf.getUsuario().getUsername());
			System.out.println(cf.getUsuario().getEmail());
			System.out.println(cf.getUsuario().getSenha());
			System.out.println(cf.getUsuario().getDataCadastro().getTime());
			System.out.println(cf.getUsuario().getStatus());
			System.out.println(cf.getUsuario().getTipo());
			System.out.println(cf.getUsuario().getTipoPessoa());
			System.out.println(cf.getUsuario().getDataStatus().getTime());
			System.out.println(cf.getUsuario().getTokenApi());
			System.out.println(cf.getNome());
			System.out.println(cf.getSobrenome());
			System.out.println(cf.getSexo());
			System.out.println(cf.getCpf());

		} else {

			System.out.println("**Cliente Físico não existe**");

		}

	}
	
	public static void consultaClienteFisicoPorId() {

		cf = uBO.consultarClienteFisico(1);

		if (cf != null) {

			System.out.println(cf.getUsuario().getId());
			System.out.println(cf.getUsuario().getUsername());
			System.out.println(cf.getUsuario().getEmail());
			System.out.println(cf.getUsuario().getSenha());
			System.out.println(cf.getUsuario().getDataCadastro().getTime());
			System.out.println(cf.getUsuario().getStatus());
			System.out.println(cf.getUsuario().getTipo());
			System.out.println(cf.getUsuario().getTipoPessoa());
			System.out.println(cf.getUsuario().getDataStatus().getTime());
			System.out.println(cf.getUsuario().getTokenApi());
			System.out.println(cf.getNome());
			System.out.println(cf.getSobrenome());
			System.out.println(cf.getSexo());
			System.out.println(cf.getCpf());

		} else {

			System.out.println("**Cliente Físico não existe**");

		}

	}

	public static void cadastraClienteFisico() {
		
		cf = new ClienteFisico();

		cf.setNome("Marcelo");
		cf.setSobrenome("Portella");
		cf.setCpf("12345678900");
		cf.setSexo(Sexo.MASCULINO);
		
		uBO.cadastrarClienteFisico(u, cf);
		
		System.out.println("**Cliente Físico cadastrado**");
		
	}

	public static void consultaUsuario() {

		u = uBO.consultar(1);

		if (u != null) {

			System.out.println(u.getId());
			System.out.println(u.getUsername());
			System.out.println(u.getEmail());
			System.out.println(u.getSenha());
			System.out.println(u.getDataCadastro().getTime());
			System.out.println(u.getStatus());
			System.out.println(u.getTipo());
			System.out.println(u.getTipoPessoa());
			System.out.println(u.getDataStatus().getTime());
			System.out.println(u.getTokenApi());

		} else {

			System.out.println("**Usuário não existe**");

		}

	}

	public static void alteraUsuario() {

		u.setEmail("marcelo@facility.com.br");
		System.out.println("**Usuário alterado**");

	}

	public static void deletaUsuario() {

		uBO.deletar(u);
		System.out.println("**Usuário deletado**");

	}

	public static void removeUsuario() {

		// uBO.remover(u);
		// System.out.println("**Usuário removido**");

	}

	public static void ativarUsuario() {

		uBO.ativar(u);
		System.out.println("**Usuário ativado**");

	}

}
