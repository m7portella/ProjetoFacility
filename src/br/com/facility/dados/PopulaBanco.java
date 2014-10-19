package br.com.facility.dados;

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
	private static AtividadeProfissionalBO apBO = new AtividadeProfissionalBO(
			em);

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

	public static void cadastraAtividadeProfissional() {
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

		// limpeza
		Atividade a5 = aBO.buscarAtividade(6);

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

		// segurança
		Atividade a7 = aBO.buscarAtividade(8);

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

		// Mobile
		Atividade a11 = aBO.buscarAtividade(11);

		Especialidade e13 = new Especialidade();
		e13.setAtividade(a11);
		e13.setNome("Android");
		eBO.cadastrar(e13);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e14 = new Especialidade();
		e14.setAtividade(a11);
		e14.setNome("iOS");
		eBO.cadastrar(e14);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

	}

	public static void cadastrarAtividades() {

		// animais
		Categoria c1 = cBO.buscar(50);

		Atividade a14 = new Atividade();
		a14.setNome("Pets");
		a14.setCategoria(c1);
		aBO.cadastrar(a14);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a15 = new Atividade();
		a15.setNome("Animais de grande porte");
		a15.setCategoria(c1);
		aBO.cadastrar(a15);
		System.out.println("*** Atividade Cadastrada ***");

		// noiva e casamento
		Categoria c2 = cBO.buscar(51);

		Atividade a16 = new Atividade();
		a16.setNome("Noiva");
		a16.setCategoria(c2);
		aBO.cadastrar(a16);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a17 = new Atividade();
		a17.setNome("Noivo");
		a17.setCategoria(c2);
		aBO.cadastrar(a17);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a18 = new Atividade();
		a18.setNome("Casamento");
		a18.setCategoria(c2);
		aBO.cadastrar(a18);
		System.out.println("*** Atividade Cadastrada ***");

		// Arquitetura e decoração
		Categoria c3 = cBO.buscar(52);

		Atividade a19 = new Atividade();
		a19.setNome("Decorador");
		a19.setCategoria(c3);
		aBO.cadastrar(a19);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a20 = new Atividade();
		a20.setNome("Montador de móveis");
		a20.setCategoria(c3);
		aBO.cadastrar(a20);
		System.out.println("*** Atividade Cadastrada ***");

		// Construção
		Categoria c4 = cBO.buscar(53);

		Atividade a21 = new Atividade();
		a21.setNome("Materiais de construção");
		a21.setCategoria(c4);
		aBO.cadastrar(a21);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a22 = new Atividade();
		a22.setNome("Móveis");
		a22.setCategoria(c4);
		aBO.cadastrar(a22);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a23 = new Atividade();
		a23.setNome("Projetos");
		a23.setCategoria(c4);
		aBO.cadastrar(a23);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a24 = new Atividade();
		a24.setNome("Interiores");
		a24.setCategoria(c4);
		aBO.cadastrar(a24);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a25 = new Atividade();
		a25.setNome("Exteriores");
		a25.setCategoria(c4);
		aBO.cadastrar(a25);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a26 = new Atividade();
		a26.setNome("Telhado e cobertura");
		a26.setCategoria(c4);
		aBO.cadastrar(a26);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a27 = new Atividade();
		a27.setNome("Telhado e cobertura");
		a27.setCategoria(c4);
		aBO.cadastrar(a27);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a28 = new Atividade();
		a28.setNome("Documentação");
		a28.setCategoria(c4);
		aBO.cadastrar(a28);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a29 = new Atividade();
		a29.setNome("Equipamento de segurança");
		a29.setCategoria(c4);
		aBO.cadastrar(a29);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a30 = new Atividade();
		a30.setNome("Estrutura");
		a30.setCategoria(c4);
		aBO.cadastrar(a30);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a31 = new Atividade();
		a31.setNome("Cabeamento");
		a31.setCategoria(c4);
		aBO.cadastrar(a31);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a32 = new Atividade();
		a32.setNome("Cerca");
		a32.setCategoria(c4);
		aBO.cadastrar(a32);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a33 = new Atividade();
		a33.setNome("Demolição e descarte");
		a33.setCategoria(c4);
		aBO.cadastrar(a33);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a34 = new Atividade();
		a34.setNome("Preparação de terreno");
		a34.setCategoria(c4);
		aBO.cadastrar(a34);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a35 = new Atividade();
		a35.setNome("Porta, portão e janela");
		a35.setCategoria(c4);
		aBO.cadastrar(a35);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a36 = new Atividade();
		a36.setNome("Eletricidade");
		a36.setCategoria(c4);
		aBO.cadastrar(a36);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a37 = new Atividade();
		a37.setNome("Construção");
		a37.setCategoria(c4);
		aBO.cadastrar(a37);
		System.out.println("*** Atividade Cadastrada ***");

		// automóvel
		Categoria c5 = cBO.buscar(54);

		Atividade a64 = new Atividade();
		a64.setNome("Funilaria");
		a64.setCategoria(c5);
		aBO.cadastrar(a64);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a65 = new Atividade();
		a65.setNome("Mecânica");
		a65.setCategoria(c5);
		aBO.cadastrar(a65);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a66 = new Atividade();
		a66.setNome("Auto Elétrica");
		a66.setCategoria(c5);
		aBO.cadastrar(a66);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a67 = new Atividade();
		a67.setNome("Outros");
		a67.setCategoria(c5);
		aBO.cadastrar(a67);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a68 = new Atividade();
		a68.setNome("Higienização para Carros");
		a68.setCategoria(c5);
		aBO.cadastrar(a68);
		System.out.println("*** Atividade Cadastrada ***");

		// festas e eventos
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

		// locação
		Categoria c7 = cBO.buscar(56);

		Atividade a38 = new Atividade();
		a38.setNome("Serviço de taxi aéreo");
		a38.setCategoria(c7);
		aBO.cadastrar(a38);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a39 = new Atividade();
		a39.setNome("Entretenimento");
		a39.setCategoria(c7);
		aBO.cadastrar(a39);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a40 = new Atividade();
		a40.setNome("Veículos");
		a40.setCategoria(c7);
		aBO.cadastrar(a40);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a41 = new Atividade();
		a41.setNome("Informática e telecom");
		a41.setCategoria(c7);
		aBO.cadastrar(a41);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a42 = new Atividade();
		a42.setNome("Imóveis");
		a42.setCategoria(c7);
		aBO.cadastrar(a42);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a43 = new Atividade();
		a43.setNome("Construção");
		a43.setCategoria(c7);
		aBO.cadastrar(a43);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a44 = new Atividade();
		a44.setNome("Outros");
		a44.setCategoria(c7);
		aBO.cadastrar(a44);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a45 = new Atividade();
		a45.setNome("Móveis");
		a45.setCategoria(c7);
		aBO.cadastrar(a45);
		System.out.println("*** Atividade Cadastrada ***");

		// segurança
		Categoria c8 = cBO.buscar(57);

		Atividade a46 = new Atividade();
		a46.setNome("Investigação");
		a46.setCategoria(c8);
		aBO.cadastrar(a46);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a47 = new Atividade();
		a47.setNome("Segurança patrimonial");
		a47.setCategoria(c8);
		aBO.cadastrar(a47);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a48 = new Atividade();
		a48.setNome("Vida e previdência");
		a48.setCategoria(c8);
		aBO.cadastrar(a48);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a49 = new Atividade();
		a49.setNome("Seguros");
		a49.setCategoria(c8);
		aBO.cadastrar(a49);
		System.out.println("*** Atividade Cadastrada ***");

		// transporte e mudanças
		Categoria c9 = cBO.buscar(58);

		Atividade a50 = new Atividade();
		a50.setNome("Traslado");
		a50.setCategoria(c9);
		aBO.cadastrar(a50);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a51 = new Atividade();
		a51.setNome("Transportadora");
		a51.setCategoria(c9);
		aBO.cadastrar(a51);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a52 = new Atividade();
		a52.setNome("Serviços de armazenamento");
		a52.setCategoria(c9);
		aBO.cadastrar(a52);
		System.out.println("*** Atividade Cadastrada ***");

		// viagem e turismo
		Categoria c10 = cBO.buscar(59);

		Atividade a53 = new Atividade();
		a53.setNome("Pacote turístico");
		a53.setCategoria(c10);
		aBO.cadastrar(a53);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a54 = new Atividade();
		a54.setNome("Acampamento de férias");
		a54.setCategoria(c10);
		aBO.cadastrar(a54);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a55 = new Atividade();
		a55.setNome("Passeios turísticos");
		a55.setCategoria(c10);
		aBO.cadastrar(a55);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a56 = new Atividade();
		a56.setNome("Guia turístico");
		a56.setCategoria(c10);
		aBO.cadastrar(a56);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a57 = new Atividade();
		a57.setNome("Esportes radicais");
		a57.setCategoria(c10);
		aBO.cadastrar(a57);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a58 = new Atividade();
		a58.setNome("Hotéis");
		a58.setCategoria(c10);
		aBO.cadastrar(a58);
		System.out.println("*** Atividade Cadastrada ***");

		// serviços gerais
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

		// saúde e beleza
		Categoria c12 = cBO.buscar(61);

		Atividade a59 = new Atividade();
		a59.setNome("Bem estar");
		a59.setCategoria(c12);
		aBO.cadastrar(a59);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a60 = new Atividade();
		a60.setNome("Spa");
		a60.setCategoria(c12);
		aBO.cadastrar(a60);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a61 = new Atividade();
		a61.setNome("Estética");
		a61.setCategoria(c12);
		aBO.cadastrar(a61);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a62 = new Atividade();
		a62.setNome("Salão de beleza");
		a62.setCategoria(c12);
		aBO.cadastrar(a62);
		System.out.println("*** Atividade Cadastrada ***");

		// serviços gráficos
		Categoria c13 = cBO.buscar(62);

		Atividade a69 = new Atividade();
		a69.setNome("Foto");
		a69.setCategoria(c13);
		aBO.cadastrar(a69);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a70 = new Atividade();
		a70.setNome("Impressão");
		a70.setCategoria(c13);
		aBO.cadastrar(a70);
		System.out.println("*** Atividade Cadastrada ***");

		// TI
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

		// consultoria
		Categoria c15 = cBO.buscar(64);

		Atividade a71 = new Atividade();
		a71.setNome("Consultoria Financeira");
		a71.setCategoria(c15);
		aBO.cadastrar(a71);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a72 = new Atividade();
		a72.setNome("vestuário e Moda");
		a72.setCategoria(c15);
		aBO.cadastrar(a72);
		System.out.println("*** Atividade Cadastrada ***");

		// publicidade e marketing
		Categoria c16 = cBO.buscar(64);

		Atividade a73 = new Atividade();
		a73.setNome("Marketing promocional");
		a73.setCategoria(c16);
		aBO.cadastrar(a73);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a74 = new Atividade();
		a74.setNome("Publicidade");
		a74.setCategoria(c16);
		aBO.cadastrar(a74);
		System.out.println("*** Atividade Cadastrada ***");
		
		//aulas
		Categoria c17 = cBO.buscar(64);

		Atividade a75 = new Atividade();
		a75.setNome("Artes e Artesanatos");
		a75.setCategoria(c17);
		aBO.cadastrar(a75);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a76 = new Atividade();
		a76.setNome("Concursos");
		a76.setCategoria(c17);
		aBO.cadastrar(a76);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a77 = new Atividade();
		a77.setNome("Dança");
		a77.setCategoria(c17);
		aBO.cadastrar(a77);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a78 = new Atividade();
		a78.setNome("Escolares e Reforço");
		a78.setCategoria(c17);
		aBO.cadastrar(a78);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a79 = new Atividade();
		a79.setNome("Esportes");
		a79.setCategoria(c17);
		aBO.cadastrar(a79);
		System.out.println("*** Atividade Cadastrada ***");
		
		Atividade a80 = new Atividade();
		a80.setNome("Idíomas");
		a80.setCategoria(c17);
		aBO.cadastrar(a80);
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
		c5.setNome("Automóvel");
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

		// 7
		Projeto pj5 = pBO.buscar(5);
		Negociacao n7 = new Negociacao();
		nBO.cadastrar(n7, pj5, pf2);
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

		Usuario u2 = uBO.buscar(1);
		Projeto p5 = new Projeto();
		p5.setTitulo("Reforma da cozinha");
		p5.setDescricao("Reforma completa da cozinha");
		pBO.cadastrar(p5, u2);
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

		// 1
		ClienteFisico cf = new ClienteFisico();

		cf.setNome("Marcelo");
		cf.setSobrenome("Portella");
		cf.setCpf("12345678900");
		cf.setSexo(Sexo.MASCULINO);

		Usuario u1 = uBO.buscar(1);

		uBO.cadastrarClienteFisico(u1, cf);

		System.out.println("**Cliente Físico cadastrado**");

		// 2
		ClienteFisico cf2 = new ClienteFisico();

		cf2.setNome("Amanda");
		cf2.setSobrenome("Yuri Ike");
		cf2.setCpf("12345678900");
		cf2.setSexo(Sexo.FEMININO);

		Usuario u2 = uBO.buscar(2);

		uBO.cadastrarClienteFisico(u2, cf2);

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
