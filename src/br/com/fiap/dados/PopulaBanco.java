package br.com.fiap.dados;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.CategoriaBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.Sexo;
import br.com.facility.enums.TipoPreco;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.Categoria;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class PopulaBanco {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static ProjetoBO pBO = new ProjetoBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static CategoriaBO cBO = new CategoriaBO(em);
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	private static AtividadeProfissionalBO apBO = new AtividadeProfissionalBO(em);

	public static void main(String[] args) {

		// Usuários
		cadastraUsuario();
		cadastraClienteFisico();
		cadastraClienteJuridico();
		cadastraProfissional();

		// Atividades
		cadastrarCategorias();
		cadastrarAtividades();
		cadastrarEspecialidades();

		// Negociações
		cadastraProjeto();
		cadastraNegociacao();
		
		// Atividades profissionais
		cadastraAtividadeProfissional();
	}
	
	public static void cadastraAtividadeProfissional(){
		Atividade a10 = aBO.buscarAtividade(11);
		Atividade a11 = aBO.buscarAtividade(12);
		Profissional p1 = uBO.buscarProfissional(1);
		Profissional p3 = uBO.buscarProfissional(3);
		
		AtividadeProfissional ap1 = new AtividadeProfissional();
		ap1.setTipoPreco(TipoPreco.HORA);
		ap1.setEstrelas(4);
		apBO.cadastrar(ap1, a10, p1);
		System.out.println("\n *** Atividade Profissional Cadastrada *** \n");
		
		AtividadeProfissional ap2 = new AtividadeProfissional();
		ap2.setTipoPreco(TipoPreco.HORA);
		ap2.setEstrelas(4);
		apBO.cadastrar(ap2, a11, p1);
		System.out.println("\n *** Atividade Profissional Cadastrada *** \n");
		
		AtividadeProfissional ap3 = new AtividadeProfissional();
		ap3.setTipoPreco(TipoPreco.SERVICO);
		ap3.setEstrelas(4);
		apBO.cadastrar(ap3, a10, p3);
		System.out.println("\n *** Atividade Profissional Cadastrada *** \n");
		
		AtividadeProfissional ap4 = new AtividadeProfissional();
		ap4.setTipoPreco(TipoPreco.SERVICO);
		ap4.setEstrelas(4);
		apBO.cadastrar(ap4, a11, p3);
		System.out.println("\n *** Atividade Profissional Cadastrada *** \n");
		
	}
	
	public static void cadastrarEspecialidades() {

		//limpeza
		Atividade a5 = aBO.buscarAtividade(5);
		
		Especialidade e1 = new Especialidade();
		e1.setAtividade(a5);
		e1.setNome("Empregada doméstica");
		eBO.cadastrar(e1);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e2 = new Especialidade();
		e2.setAtividade(a5);
		e2.setNome("Diarista");
		eBO.cadastrar(e2);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e3 = new Especialidade();
		e3.setAtividade(a5);
		e3.setNome("Copeira");
		eBO.cadastrar(e3);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e4 = new Especialidade();
		e4.setAtividade(a5);
		e4.setNome("Faxineiro");
		eBO.cadastrar(e4);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e5 = new Especialidade();
		e5.setAtividade(a5);
		e5.setNome("Auxiliar de cozinha");
		eBO.cadastrar(e5);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e6 = new Especialidade();
		e6.setAtividade(a5);
		e6.setNome("Limpeza de prédio");
		eBO.cadastrar(e6);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e7 = new Especialidade();
		e7.setAtividade(a5);
		e7.setNome("Controle de pragas");
		eBO.cadastrar(e7);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e8 = new Especialidade();
		e8.setAtividade(a5);
		e8.setNome("Higienização");
		eBO.cadastrar(e8);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		//segurança
		Atividade a7 = aBO.buscarAtividade(7);
		
		Especialidade e9 = new Especialidade();
		e9.setAtividade(a7);
		e9.setNome("Porteiro");
		eBO.cadastrar(e9);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e10 = new Especialidade();
		e10.setAtividade(a7);
		e10.setNome("Vigia");
		eBO.cadastrar(e10);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e11 = new Especialidade();
		e11.setAtividade(a7);
		e11.setNome("Ronda noturna");
		eBO.cadastrar(e11);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e12 = new Especialidade();
		e12.setAtividade(a7);
		e12.setNome("Segurança para condomínios");
		eBO.cadastrar(e12);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

	}

	public static void cadastrarAtividades() {

		//eventos
		Categoria c6 = cBO.buscar(55);

		Atividade a1 = new Atividade();
		a1.setNome("Festas");
		a1.setCategoria(c6);
		aBO.cadastrar(a1);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a2 = new Atividade();
		a2.setNome("Festa infantil");
		a2.setCategoria(c6);
		aBO.cadastrar(a2);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a3 = new Atividade();
		a3.setNome("Eventos");
		a3.setCategoria(c6);
		aBO.cadastrar(a3);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a4 = new Atividade();
		a4.setNome("Formaturas");
		a4.setCategoria(c6);
		aBO.cadastrar(a4);
		System.out.println("*** Atividade Cadastrada ***");

		//serviços gerais
		Categoria c11 = cBO.buscar(60);

		Atividade a5 = new Atividade();
		a5.setNome("Limpeza");
		a5.setCategoria(c11);
		aBO.cadastrar(a5);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a6 = new Atividade();
		a6.setNome("Manutenção");
		a6.setCategoria(c11);
		aBO.cadastrar(a6);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a7 = new Atividade();
		a7.setNome("Segurança");
		a7.setCategoria(c11);
		aBO.cadastrar(a7);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a8 = new Atividade();
		a8.setNome("Cozinha");
		a8.setCategoria(c11);
		aBO.cadastrar(a8);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a9 = new Atividade();
		a9.setNome("Outros");
		a9.setCategoria(c11);
		aBO.cadastrar(a9);
		System.out.println("*** Atividade Cadastrada ***");
		
		//TI
		Categoria c14 = cBO.buscar(63);
		
		Atividade a10 = new Atividade();
		a10.setNome("Desenvolvimento Mobile");
		a10.setCategoria(c14);
		aBO.cadastrar(a10);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a11 = new Atividade();
		a11.setNome("Desenvolvimento de software");
		a11.setCategoria(c14);
		aBO.cadastrar(a11);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a12 = new Atividade();
		a12.setNome("Suporte técnico");
		a12.setCategoria(c14);
		aBO.cadastrar(a12);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a13 = new Atividade();
		a13.setNome("WebDesigner");
		a13.setCategoria(c14);
		aBO.cadastrar(a13);
		System.out.println("*** Atividade Cadastrada ***");
		

	}

	private static void cadastrarCategorias() {
		Categoria c1 = new Categoria();
		c1.setNome("Animais");
		cBO.cadastrar(c1);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c2 = new Categoria();
		c2.setNome("Noiva e Casamento");
		cBO.cadastrar(c2);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c3 = new Categoria();
		c3.setNome("Arquitetura e decoração");
		cBO.cadastrar(c3);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c4 = new Categoria();
		c4.setNome("Construção");
		cBO.cadastrar(c4);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c5 = new Categoria();
		c5.setNome("Arquitetura e decoração");
		cBO.cadastrar(c5);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c6 = new Categoria();
		c6.setNome("Festas e eventos");
		cBO.cadastrar(c6);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c7 = new Categoria();
		c7.setNome("Locação");
		cBO.cadastrar(c7);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c8 = new Categoria();
		c8.setNome("Segurança");
		cBO.cadastrar(c8);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c9 = new Categoria();
		c9.setNome("Transporte e mudança");
		cBO.cadastrar(c9);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c10 = new Categoria();
		c10.setNome("Viagem e turismo");
		cBO.cadastrar(c10);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c11 = new Categoria();
		c11.setNome("Serviços gerais");
		cBO.cadastrar(c11);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c12 = new Categoria();
		c12.setNome("Saúde e beleza");
		cBO.cadastrar(c12);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c13 = new Categoria();
		c13.setNome("Serviços gráficos");
		cBO.cadastrar(c13);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c14 = new Categoria();
		c14.setNome("Informática");
		cBO.cadastrar(c14);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c15 = new Categoria();
		c15.setNome("Consultoria");
		cBO.cadastrar(c15);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c16 = new Categoria();
		c16.setNome("Publicidade e marketing");
		cBO.cadastrar(c16);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c17 = new Categoria();
		c17.setNome("Aulas");
		cBO.cadastrar(c17);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c18 = new Categoria();
		c18.setNome("Automóvel");
		cBO.cadastrar(c18);
		System.out.println("*** CATEGORIA CADASTRADA ***");
	}

	public static void cadastraNegociacao() {

		// 1
		Projeto pj = pBO.buscar(3);
		Profissional pf = uBO.buscarProfissional(1);
		Negociacao n = new Negociacao();

		nBO.cadastrar(n, pj, pf);
		System.out.println("**Negociacao cadastrada**");

		// 2
		Projeto pj2 = pBO.buscar(4);
		Negociacao n2 = new Negociacao();

		nBO.cadastrar(n2, pj2, pf);
		System.out.println("**Negociacao cadastrada**");

		// 3
		Profissional pf2 = uBO.buscarProfissional(3);
		Negociacao n3 = new Negociacao();

		nBO.cadastrar(n3, pj, pf2);
		System.out.println("**Negociacao cadastrada**");

		// 4
		Negociacao n4 = new Negociacao();

		nBO.cadastrar(n4, pj2, pf2);
		System.out.println("**Negociacao cadastrada**");

		// 5
		Projeto pj3 = pBO.buscar(1);
		Negociacao n5 = new Negociacao();

		nBO.cadastrar(n5, pj3, pf2);
		System.out.println("**Negociacao cadastrada**");

		// 6
		Projeto pj4 = pBO.buscar(2);
		Negociacao n6 = new Negociacao();

		nBO.cadastrar(n6, pj4, pf2);
		System.out.println("**Negociacao cadastrada**");
	}

	public static void cadastraProjeto() {
		Usuario u = uBO.buscar(2);

		Projeto p1 = new Projeto();
		p1.setTitulo("Reforma do piso da sala");
		p1.setDescricao("Troca do piso da sala por porcelanato");
		pBO.cadastrar(p1, u);
		System.out.println("**Projeto cadastrado**");

		Projeto p2 = new Projeto();
		p2.setTitulo("Festa de aniversário");
		p2.setDescricao("Festa XPTO de aniversário");
		pBO.cadastrar(p2, u);
		System.out.println("**Projeto cadastrado**");

		Projeto p3 = new Projeto();
		p3.setTitulo("App para iPhone");
		p3.setDescricao("App para bla bla bla no iPhone");
		pBO.cadastrar(p3, u);
		System.out.println("**Projeto cadastrado**");

		Projeto p4 = new Projeto();
		p4.setTitulo("Site da empresa");
		p4.setDescricao("Novo site para minha empresa");
		pBO.cadastrar(p4, u);
		System.out.println("**Projeto cadastrado**");
	}

	public static void cadastraProfissional() {

		// 1
		Profissional p = new Profissional();
		p.setLocalizavel(true);
		p.setDescricao("Tenho experiência na área a mais de 5 anos.");

		Usuario u1 = uBO.buscar(1);

		uBO.cadastrarProfissional(u1, p);

		System.out.println("**Profissional cadastrado**");

		// 2
		Profissional p2 = new Profissional();
		p2.setLocalizavel(true);
		p2.setDescricao("Empresa de intermediação de serviços pela web");

		Usuario u3 = uBO.buscar(3);

		uBO.cadastrarProfissional(u3, p2);

		System.out.println("**Profissional cadastrado**");
	}

	public static void cadastraClienteJuridico() {

		ClienteJuridico cj = new ClienteJuridico();

		cj.setNomeFantasia("Facility");
		cj.setRazaoSocial("Facility S/A");
		cj.setCnpj("2340978674534");

		Usuario u3 = uBO.buscar(3);

		uBO.cadastrarClienteJuridico(u3, cj);

		System.out.println("**Cliente Juridico cadastrado**");

	}

	public static void cadastraClienteFisico() {

		ClienteFisico cf = new ClienteFisico();

		cf.setNome("Marcelo");
		cf.setSobrenome("Portella");
		cf.setCpf("12345678900");
		cf.setSexo(Sexo.MASCULINO);

		Usuario u1 = uBO.buscar(1);

		uBO.cadastrarClienteFisico(u1, cf);

		System.out.println("**Cliente Físico cadastrado**");

	}

	public static void cadastraUsuario() {

		Usuario u1 = new Usuario();
		u1.setNome("Marcelo Portella");
		u1.setUsername("m7portella");
		u1.setEmail("m7portella@gmail.com");
		u1.setSenha("123456");
		u1.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		Usuario u2 = new Usuario();
		u2.setNome("Amanda Yuri Ike");
		u2.setUsername("amandayuri");
		u2.setEmail("amandayurike@gmail.com");
		u2.setSenha("123456");
		u2.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		Usuario u3 = new Usuario();
		u3.setNome("Andersson Galves");
		u3.setUsername("anderssongalves");
		u3.setEmail("anderssongalves@gmail.com");
		u3.setSenha("123456");
		u3.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		Usuario u4 = new Usuario();
		u4.setNome("Matheur Damiate");
		u4.setUsername("mbdamiate");
		u4.setEmail("mbdamiate@gmail.com");
		u4.setSenha("123456");
		u4.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		Usuario u5 = new Usuario();
		u5.setNome("Barbara Weltson");
		u5.setUsername("weltsonbarbara");
		u5.setEmail("weltsonbarbara@gmail.com");
		u5.setSenha("123456");
		u5.setTokenApi("i8zIUe9YdeS34T5y2WtgeT8");

		uBO.cadastrar(u1);
		System.out.println("**Usuário cadastrado**");

		uBO.cadastrar(u2);
		System.out.println("**Usuário cadastrado**");

		uBO.cadastrar(u3);
		System.out.println("**Usuário cadastrado**");

		uBO.cadastrar(u4);
		System.out.println("**Usuário cadastrado**");

		uBO.cadastrar(u5);
		System.out.println("**Usuário cadastrado**");

	}

}
