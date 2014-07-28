package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.LocalAtendimentoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.Sexo;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.LocalAtendimento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class UsuarioTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static UsuarioBO uBO = new UsuarioBO(em);
	//private static ProfissionalBO pBO = new ProfissionalBO(em);
	private static LocalAtendimentoBO lBO = new LocalAtendimentoBO(em);
	private static Usuario u1;
	private static Usuario u2;
	private static Usuario u3;
	private static ClienteFisico cf;
	private static ClienteJuridico cj;
	private static Profissional p;
	
	public static void main(String[] args) {

		LocalAtendimentoTeste.adicionaLocalAtend();
		
		// USUARIO
		cadastraUsuario();
		consultaUsuario();

		ativarUsuario();
		consultaUsuario();

		alteraUsuario();
		consultaUsuario();

//		removeUsuario();
//		consultaUsuario();
		
		// CLIENTE FISICO
		consultaClienteFisico();
		
		cadastraClienteFisico();
		consultaClienteFisico();
		
		alteraClienteFisico();
		consultaClienteFisico();
		
		//deletaClienteFisico();
		consultaClienteFisico();
		
		// CLIENTE JURIDICO
		consultaClienteJuridico();
		
		cadastraClienteJuridico();
		consultaClienteJuridico();
//		
//		alteraClienteJuridico();
//		consultaClienteJuridico();
//		
//		//deletaClienteJuridico();
//		consultaClienteJuridico();
		
		// PROFISSIONAL
		consultaProfissional();
		
		cadastraProfissional();
		consultaProfissional();
		
//		alteraProfissional();
//		consultaProfissional();
//		
//		deletaProfissional();
//		consultaProfissional();

		
		//Local Atendimento Profissional
	
		adicionaLocalAtend();
		listaLocalAtendimento();

		removeLocalAtendimento();
		listaLocalAtendimento();
		
	}
	
	public static void cadastraProfissional(){
		
		p = new Profissional();
		p.setLocalizavel(true);
		
		uBO.cadastrarProfissional(u1, p);
		
		System.out.println("**Profissional cadastrado**");
	}
	
	public static void consultaProfissional(){
		p = uBO.buscarProfissional(1);
		
		if (p != null) {
			
			System.out.println(p.getId());
			System.out.println(p.getTipo());
			if (p.getTipo() == TipoPessoa.FISICA) {
				System.out.println(p.getClienteFisico().getNome());
				System.out.println(p.getClienteFisico().getSobrenome());
			} else if (p.getTipo() == TipoPessoa.JURIDICA){
				System.out.println(p.getClienteJuridico().getNomeFantasia());
				System.out.println(p.getClienteJuridico().getRazaoSocial());
			}
			System.out.println(p.getStatus());
			System.out.println(p.getStatusValidacao());
			System.out.println(p.getRank());
			System.out.println(p.getDataCadastro().getTime());
			System.out.println(p.getDataStatus().getTime());
			System.out.println(p.isLocalizavel());
			
		} else {
			System.out.println("**Profissional não existe**");
		}
		
	}
	
	public static void deletaProfissional(){
		uBO.deletar(p);
		System.out.println("**Profissional deletado**");
	}
	
	public static void alteraProfissional(){
		//valida e altera
		uBO.validar(p);
		p.setLocalizavel(false);
		uBO.alterar(p);
		System.out.println("**Profissional alterado**");
	}

	public static void cadastraUsuario() {

		u1 = new Usuario();
		u1.setUsername("m7portella");
		u1.setEmail("m7portella@gmail.com");
		u1.setSenha("123456");
		u1.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
		
		u2 = new Usuario();
		u2.setUsername("amandayuri");
		u2.setEmail("amandayurike@gmail.com");
		u2.setSenha("123456");
		u2.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
		
		u3 = new Usuario();
		u3.setUsername("anderssongalves");
		u3.setEmail("anderssongalves@gmail.com");
		u3.setSenha("123456");
		u3.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");
		
		uBO.cadastrar(u1);
		//System.out.println("**Usuário cadastrado**")
		
		uBO.cadastrar(u2);
		//System.out.println("**Usuário cadastrado**");;

		uBO.cadastrar(u3);
		//System.out.println("**Usuário cadastrado**");

	}
	
	public static void consultaClienteJuridico() {

		cj = uBO.buscarClienteJuridico(3);

		if (cj != null) {

			System.out.println(cj.getUsuario().getId());
			System.out.println(cj.getUsuario().getUsername());
			System.out.println(cj.getUsuario().getEmail());
			System.out.println(cj.getUsuario().getSenha());
			System.out.println(cj.getUsuario().getDataCadastro().getTime());
			System.out.println(cj.getUsuario().getStatus());
			System.out.println(cj.getUsuario().getTipo());
			System.out.println(cj.getUsuario().getTipoPessoa());
			System.out.println(cj.getUsuario().getDataStatus().getTime());
			System.out.println(cj.getUsuario().getTokenApi());
			System.out.println(cj.getRazaoSocial());
			System.out.println(cj.getNomeFantasia());
			System.out.println(cj.getCnpj());

		} else {

			System.out.println("**Cliente Juridico não existe**");

		}

	}
	
	public static void deletaClienteJuridico(){
		uBO.deletar(cj);
		System.out.println("**Cliente Juridico deletado**");
	}
	
	public static void alteraClienteJuridico(){
		
		cj.setNomeFantasia("Facilit");
		Usuario u = cf.getUsuario();
		u.setSenha("9090909090");
		uBO.alterar(cf);
		
		System.out.println("**Cliente Juridico alterado**");
	}

	public static void cadastraClienteJuridico() {
		
		cj = new ClienteJuridico();

		cj.setNomeFantasia("Facility");
		cj.setRazaoSocial("Facility S/A");
		cj.setCnpj("2340978674534");
		
		uBO.cadastrarClienteJuridico(u3, cj);
		
		System.out.println("**Cliente Juridico cadastrado**");
		
	}
	
	public static void consultaClienteFisico() {

		cf = uBO.buscarClienteFisico(1);

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
	
	public static void deletaClienteFisico(){
		uBO.deletar(cf);
		System.out.println("**Cliente Físico deletado**");
	}
	
	public static void alteraClienteFisico(){
		
		cf.setDataNascimento(Calendar.getInstance());
		Usuario u = cf.getUsuario();
		u.setSenha("987654");
		uBO.alterar(cf);
		
		System.out.println("**Cliente Físico alterado**");
	}

	public static void cadastraClienteFisico() {
		
		cf = new ClienteFisico();

		cf.setNome("Marcelo");
		cf.setSobrenome("Portella");
		cf.setCpf("12345678900");
		cf.setSexo(Sexo.MASCULINO);
		
		uBO.cadastrarClienteFisico(u1, cf);
		
		System.out.println("**Cliente Físico cadastrado**");
		
	}

	public static void consultaUsuario() {

		Usuario u = uBO.buscar(1);

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

		u1.setEmail("marcelo@facility.com.br");
		System.out.println("**Usuário alterado**");

	}

	public static void deletaUsuario() {

		uBO.deletar(u1);
		System.out.println("**Usuário deletado**");

	}

	public static void removeUsuario() {

		// uBO.remover(u);
		// System.out.println("**Usuário removido**");

	}

	public static void ativarUsuario() {

		uBO.ativar(u1);
		System.out.println("**Usuário ativado**");

	}
	
	// --------  LOCAL ATENDIMENTO PROFISSIONAL -------- //
	
	public static void adicionaLocalAtend(){
		Profissional prof = uBO.buscarProfissional(1);
		
		List<LocalAtendimento> lstLocal = prof.getLocaisAtendimento();
				lstLocal.add(lBO.buscar(1));
//				lstLocal.add(lBO.buscar(2));
			uBO.inserirLocaisAtendimento(prof, lstLocal);
		
		System.out.println("**Locais de Atendimento Incluido**");
		
	}
	
	public static void removeLocalAtendimento(){
		Profissional prof = uBO.buscarProfissional(1);
		int indice = 0; // indice da Lista LocalAtendimento do Profissional
		uBO.removerLocalAtendimento(prof, indice);

	}
	
	public static void listaLocalAtendimento(){
		Profissional prof = uBO.buscarProfissional(1);
		
		if(!prof.getLocaisAtendimento().isEmpty()){
			List<LocalAtendimento> lst = prof.getLocaisAtendimento();
			for (LocalAtendimento local : lst) {
				System.out.println("\nBairro: " + local.getBairro() + ", " + local.getCidade() + " - " + local.getEstado());
			}
		}else{
			System.out.println("**Não há Locais de Atendimento cadastrado**");
		}
	}

}
