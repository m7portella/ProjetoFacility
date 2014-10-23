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

	// especialidades
	public static void cadastrarEspecialidades() {

		// pets
		Atividade a1 = aBO.buscarAtividade(2);

		Especialidade e20 = new Especialidade();
		e20.setAtividade(a1);
		e20.setNome("Adestramento de Cães");
		eBO.cadastrar(e20);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e21 = new Especialidade();
		e21.setAtividade(a1);
		e21.setNome("Creche para Cães");
		eBO.cadastrar(e21);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e13 = new Especialidade();
		e13.setAtividade(a1);
		e13.setNome("Hotel para Cães e Gatos");
		eBO.cadastrar(e13);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e14 = new Especialidade();
		e14.setAtividade(a1);
		e14.setNome("Banho e tosa");
		eBO.cadastrar(e14);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e15 = new Especialidade();
		e15.setAtividade(a1);
		e15.setNome("Veterinário");
		eBO.cadastrar(e15);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e16 = new Especialidade();
		e16.setAtividade(a1);
		e16.setNome("Instituto de Beleza para Animais");
		eBO.cadastrar(e16);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e17 = new Especialidade();
		e17.setAtividade(a1);
		e17.setNome("Passeio de Cães");
		eBO.cadastrar(e17);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e18 = new Especialidade();
		e18.setAtividade(a1);
		e18.setNome("Pet 24 horas");
		eBO.cadastrar(e18);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e19 = new Especialidade();
		e19.setAtividade(a1);
		e19.setNome("Pet Shop Móvel");
		eBO.cadastrar(e19);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e22 = new Especialidade();
		e22.setAtividade(a1);
		e22.setNome("Atendimento Pet Home Care");
		eBO.cadastrar(e22);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e23 = new Especialidade();
		e23.setAtividade(a1);
		e23.setNome("Serviço funerários de animais");
		eBO.cadastrar(e23);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e24 = new Especialidade();
		e24.setAtividade(a1);
		e24.setNome("Microchip para Pets");
		eBO.cadastrar(e24);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e25 = new Especialidade();
		e25.setAtividade(a1);
		e25.setNome("Boate pra Cachorro");
		eBO.cadastrar(e25);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e26 = new Especialidade();
		e26.setAtividade(a1);
		e26.setNome("Petshop");
		eBO.cadastrar(e26);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e27 = new Especialidade();
		e27.setAtividade(a1);
		e27.setNome("Spa para Cães");
		eBO.cadastrar(e27);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// Animais de grande porte
		Atividade a2 = aBO.buscarAtividade(3);

		Especialidade e30 = new Especialidade();
		e30.setAtividade(a2);
		e30.setNome("Inseminação");
		eBO.cadastrar(e30);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e31 = new Especialidade();
		e31.setAtividade(a2);
		e31.setNome("Vacinação");
		eBO.cadastrar(e31);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e32 = new Especialidade();
		e32.setAtividade(a2);
		e32.setNome("Microchip");
		eBO.cadastrar(e32);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e33 = new Especialidade();
		e33.setAtividade(a2);
		e33.setNome("Veteriário para Animais de Grande Porte");
		eBO.cadastrar(e33);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e34 = new Especialidade();
		e34.setAtividade(a2);
		e34.setNome("Hospital Veterinário");
		eBO.cadastrar(e34);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// noiva
		Atividade a3 = aBO.buscarAtividade(4);

		Especialidade e35 = new Especialidade();
		e35.setAtividade(a3);
		e35.setNome("Dia da Noiva");
		eBO.cadastrar(e35);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e36 = new Especialidade();
		e36.setAtividade(a3);
		e36.setNome("Vestido de Noiva");
		eBO.cadastrar(e36);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e37 = new Especialidade();
		e37.setAtividade(a3);
		e37.setNome("Aluguel de Vestido de Noiva");
		eBO.cadastrar(e37);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e38 = new Especialidade();
		e38.setAtividade(a3);
		e38.setNome("Aluguel de Vestido");
		eBO.cadastrar(e38);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e39 = new Especialidade();
		e39.setAtividade(a3);
		e39.setNome("Penteado para Noivas");
		eBO.cadastrar(e39);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e40 = new Especialidade();
		e40.setAtividade(a3);
		e40.setNome("Maquiagem para Noivas");
		eBO.cadastrar(e40);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e41 = new Especialidade();
		e41.setAtividade(a3);
		e41.setNome("Arranjo para Cabelo");
		eBO.cadastrar(e41);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e42 = new Especialidade();
		e42.setAtividade(a3);
		e42.setNome("Bouquet de Flores");
		eBO.cadastrar(e42);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e43 = new Especialidade();
		e43.setAtividade(a3);
		e43.setNome("Brindes para Chá de Cozinha");
		eBO.cadastrar(e43);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e44 = new Especialidade();
		e44.setAtividade(a3);
		e44.setNome("Lembrancinha de Chá de Cozinha");
		eBO.cadastrar(e44);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// noivo
		Atividade a4 = aBO.buscarAtividade(5);

		Especialidade e45 = new Especialidade();
		e45.setAtividade(a4);
		e45.setNome("Assessoria");
		eBO.cadastrar(e45);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e46 = new Especialidade();
		e46.setAtividade(a4);
		e46.setNome("Dia do Noivo");
		eBO.cadastrar(e46);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e47 = new Especialidade();
		e47.setAtividade(a4);
		e47.setNome("Aluguel de Trajes Mascuinos");
		eBO.cadastrar(e47);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// casamento
		Atividade a5 = aBO.buscarAtividade(6);

		Especialidade e48 = new Especialidade();
		e48.setAtividade(a5);
		e48.setNome("Cerimonial");
		eBO.cadastrar(e48);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e49 = new Especialidade();
		e49.setAtividade(a5);
		e49.setNome("Buffet para Casamento");
		eBO.cadastrar(e49);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e50 = new Especialidade();
		e50.setAtividade(a5);
		e50.setNome("Decoração de Igreja");
		eBO.cadastrar(e50);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// docoração

		// materiais de construção
		Atividade a6 = aBO.buscarAtividade(8);

		Especialidade e51 = new Especialidade();
		e51.setAtividade(a6);
		e51.setNome("Lojas de Materiais de Construção");
		eBO.cadastrar(e51);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// móveis
		Atividade a8 = aBO.buscarAtividade(9);

		Especialidade e52 = new Especialidade();
		e52.setAtividade(a8);
		e52.setNome("Marcenaria");
		eBO.cadastrar(e52);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e53 = new Especialidade();
		e53.setAtividade(a8);
		e53.setNome("Cozinha");
		eBO.cadastrar(e53);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// projetos
		Atividade a9 = aBO.buscarAtividade(10);

		Especialidade e54 = new Especialidade();
		e54.setAtividade(a9);
		e54.setNome("Fechamento de Áreas e Varandas");
		eBO.cadastrar(e54);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e55 = new Especialidade();
		e55.setAtividade(a9);
		e55.setNome("Planta Arquitetônica para Apovação na Prefeitura");
		eBO.cadastrar(e55);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e56 = new Especialidade();
		e56.setAtividade(a9);
		e56.setNome("Projeto de Eletricidade");
		eBO.cadastrar(e56);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// interiores
		Atividade a10 = aBO.buscarAtividade(11);

		Especialidade e57 = new Especialidade();
		e57.setAtividade(a10);
		e57.setNome("Arquivo");
		eBO.cadastrar(e57);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e58 = new Especialidade();
		e58.setAtividade(a10);
		e58.setNome("Desentupimento");
		eBO.cadastrar(e58);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e59 = new Especialidade();
		e59.setAtividade(a10);
		e59.setNome("Elevador");
		eBO.cadastrar(e59);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// exteriores
		Atividade a13 = aBO.buscarAtividade(12);

		Especialidade e60 = new Especialidade();
		e60.setAtividade(a13);
		e60.setNome("Antena e Para-Raios");
		eBO.cadastrar(e60);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e61 = new Especialidade();
		e61.setAtividade(a13);
		e61.setNome("Jardim, Paisagismo");
		eBO.cadastrar(e61);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e62 = new Especialidade();
		e62.setAtividade(a13);
		e62.setNome("Fechamento de Áreas e Varandas");
		eBO.cadastrar(e62);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// telhado e cobertura
		Atividade a14 = aBO.buscarAtividade(13);

		Especialidade e63 = new Especialidade();
		e63.setAtividade(a14);
		e63.setNome("Projeto de telhados e Cobertura");
		eBO.cadastrar(e63);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e64 = new Especialidade();
		e64.setAtividade(a14);
		e64.setNome("Reforma de Telhado e Cobertura");
		eBO.cadastrar(e64);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e65 = new Especialidade();
		e65.setAtividade(a14);
		e65.setNome("Telhado e Cobertura - Outros");
		eBO.cadastrar(e65);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// documentação
		// Atividade a15 = aBO.buscarAtividade();
		//
		// Especialidade e66 = new Especialidade();
		// e66.setAtividade(a15);
		// e66.setNome("Alvará");
		// eBO.cadastrar(e66);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e67 = new Especialidade();
		// e67.setAtividade(a15);
		// e67.setNome("Autoriazação");
		// eBO.cadastrar(e67);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e68 = new Especialidade();
		// e68.setAtividade(a15);
		// e68.setNome("Avaliação");
		// eBO.cadastrar(e68);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e69 = new Especialidade();
		// e69.setAtividade(a15);
		// e69.setNome("Inspeção");
		// eBO.cadastrar(e69);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");

		// equipamentos de segurança 14
		Atividade a15 = aBO.buscarAtividade(14);

		Especialidade e66 = new Especialidade();
		e66.setAtividade(a15);
		e66.setNome("Sistema de Incêndio");
		eBO.cadastrar(e66);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e67 = new Especialidade();
		e67.setAtividade(a15);
		e67.setNome("Equipamento de Segurança em Canteiros e Obras");
		eBO.cadastrar(e67);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e68 = new Especialidade();
		e68.setAtividade(a15);
		e68.setNome("Equipamento de Segurança em Salas de Máquinas");
		eBO.cadastrar(e68);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e69 = new Especialidade();
		e69.setAtividade(a15);
		e69.setNome("Outros Equipamento");
		eBO.cadastrar(e69);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		
		// estrutura 15
		Atividade a23 = aBO.buscarAtividade(15);

		Especialidade e90 = new Especialidade();
		e90.setAtividade(a23);
		e90.setNome("Fechamento de Áreas e Varandas");
		eBO.cadastrar(e90);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		// cabeamento 16
		Atividade a24 = aBO.buscarAtividade(16);

		Especialidade e91 = new Especialidade();
		e91.setAtividade(a24);
		e91.setNome("Cabeamento Elétrico");
		eBO.cadastrar(e91);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e92 = new Especialidade();
		e92.setAtividade(a24);
		e92.setNome("Cabeamento Estruturado");
		eBO.cadastrar(e92);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e93 = new Especialidade();
		e93.setAtividade(a24);
		e93.setNome("Cabeamento Óptico");
		eBO.cadastrar(e93);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		

		// cerca

		// demolição e descarte 17
		Atividade a25 = aBO.buscarAtividade(17);

		Especialidade e94 = new Especialidade();
		e94.setAtividade(a25);
		e94.setNome("Demolição e Descarte - Outros");
		eBO.cadastrar(e94);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e95 = new Especialidade();
		e95.setAtividade(a25);
		e95.setNome("Demolição e Descarte de casas");
		eBO.cadastrar(e95);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e96 = new Especialidade();
		e96.setAtividade(a25);
		e96.setNome("Demolição e Descarte de Muros");
		eBO.cadastrar(e96);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// preparação de terreno 18
		Atividade a26 = aBO.buscarAtividade(18);

		Especialidade e97 = new Especialidade();
		e97.setAtividade(a26);
		e97.setNome("Agrimensura");
		eBO.cadastrar(e97);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e98 = new Especialidade();
		e98.setAtividade(a26);
		e98.setNome("Documentação para Obra");
		eBO.cadastrar(e98);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e99 = new Especialidade();
		e99.setAtividade(a26);
		e99.setNome("Fundação");
		eBO.cadastrar(e99);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		// porta, portão e janela 19
		Atividade a27 = aBO.buscarAtividade(19);

		Especialidade e100 = new Especialidade();
		e100.setAtividade(a27);
		e100.setNome("Campainha");
		eBO.cadastrar(e100);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		Especialidade e101 = new Especialidade();
		e101.setAtividade(a27);
		e101.setNome("Chaveiro, Tranca e Fechadura");
		eBO.cadastrar(e101);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		// eletricidade (null) 20
		
		// construção
		
		// festas 26
		Atividade a28 = aBO.buscarAtividade(26);

		Especialidade e102 = new Especialidade();
		e102.setAtividade(a28);
		e102.setNome("Segurança para festas");
		eBO.cadastrar(e102);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e103 = new Especialidade();
		e103.setAtividade(a27);
		e103.setNome("Campainha");
		eBO.cadastrar(e103);
		System.out.println("\n *** Especialidade Cadastrada *** \n");
		
		// festa infantil 27
		
		// eventos 28
		
		// formaturas 29
		
		// serviços de taxi 30
		
		// entretenimento 31
		
		// veículos 32
		
		// informática e telecom 33
		
		// imóveis 34
		
		// contrução 35
		
		// outros 36
		
		// móveis 37
		
		// investigação (null) 28
		
		// segurança patrimonial 39
		
		// vida e prefidencia 40
		
		// seguros 41
		
		// traslado 42
		
		// transportadora 43
		
		// serviços de armazenamento 44
		
		// pacote de turismo 45

		// acampamento de ferias 46
		
		// passeios turístcos 47
		
		// guia turistico 48
		
		// espertes radicais 49
		
		// hotéis 50
		
		// limpeza 51
		Atividade a11 = aBO.buscarAtividade(51);

		Especialidade e1 = new Especialidade();
		e1.setAtividade(a11);
		e1.setNome("Empregada doméstica");
		eBO.cadastrar(e1);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e2 = new Especialidade();
		e2.setAtividade(a11);
		e2.setNome("Diarista");
		eBO.cadastrar(e2);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e3 = new Especialidade();
		e3.setAtividade(a11);
		e3.setNome("Copeira");
		eBO.cadastrar(e3);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e4 = new Especialidade();
		e4.setAtividade(a11);
		e4.setNome("Faxineiro");
		eBO.cadastrar(e4);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e5 = new Especialidade();
		e5.setAtividade(a11);
		e5.setNome("Auxiliar de cozinha");
		eBO.cadastrar(e5);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e6 = new Especialidade();
		e6.setAtividade(a11);
		e6.setNome("Limpeza de prédio");
		eBO.cadastrar(e6);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e7 = new Especialidade();
		e7.setAtividade(a11);
		e7.setNome("Controle de pragas");
		eBO.cadastrar(e7);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e8 = new Especialidade();
		e8.setAtividade(a11);
		e8.setNome("Higienização");
		eBO.cadastrar(e8);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// manutenção 52

		// segurança 53
		Atividade a12 = aBO.buscarAtividade(53);

		Especialidade e9 = new Especialidade();
		e9.setAtividade(a12);
		e9.setNome("Porteiro");
		eBO.cadastrar(e9);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e10 = new Especialidade();
		e10.setAtividade(a12);
		e10.setNome("Vigia");
		eBO.cadastrar(e10);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e11 = new Especialidade();
		e11.setAtividade(a12);
		e11.setNome("Ronda noturna");
		eBO.cadastrar(e11);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e12 = new Especialidade();
		e12.setAtividade(a12);
		e12.setNome("Segurança para Condomínios");
		eBO.cadastrar(e12);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// Cozinha 54
		Atividade a55 = aBO.buscarAtividade(54);

		Especialidade e70 = new Especialidade();
		e70.setAtividade(a55);
		e70.setNome("Copeira");
		eBO.cadastrar(e70);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e71 = new Especialidade();
		e71.setAtividade(a55);
		e71.setNome("Auxilixar de Cozinha");
		eBO.cadastrar(e71);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e72 = new Especialidade();
		e72.setAtividade(a55);
		e72.setNome("Chef de Cozinha");
		eBO.cadastrar(e72);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// outros 55
		Atividade a56 = aBO.buscarAtividade(55);

		Especialidade e73 = new Especialidade();
		e73.setAtividade(a56);
		e73.setNome("Motoboy");
		eBO.cadastrar(e73);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e74 = new Especialidade();
		e74.setAtividade(a56);
		e74.setNome("Galão de Água");
		eBO.cadastrar(e74);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// bem estar 56
		Atividade a57 = aBO.buscarAtividade(56);

		Especialidade e75 = new Especialidade();
		e75.setAtividade(a57);
		e75.setNome("Acumpuntura");
		eBO.cadastrar(e75);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e76 = new Especialidade();
		e76.setAtividade(a57);
		e76.setNome("Ventosas");
		eBO.cadastrar(e76);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e77 = new Especialidade();
		e77.setAtividade(a57);
		e77.setNome("Banhos de ofurô");
		eBO.cadastrar(e77);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e78 = new Especialidade();
		e78.setAtividade(a57);
		e78.setNome("Pilates");
		eBO.cadastrar(e78);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// spa 57
		Atividade a58 = aBO.buscarAtividade(57);

		Especialidade e79 = new Especialidade();
		e79.setAtividade(a58);
		e79.setNome("Spa Urbano");
		eBO.cadastrar(e79);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e80 = new Especialidade();
		e80.setAtividade(a58);
		e80.setNome("Spa Hotek Resort");
		eBO.cadastrar(e80);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e81 = new Especialidade();
		e81.setAtividade(a58);
		e81.setNome("Spa Fazenda");
		eBO.cadastrar(e81);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// estética 58
		Atividade a59 = aBO.buscarAtividade(58);

		Especialidade e82 = new Especialidade();
		e82.setAtividade(a59);
		e82.setNome("Estética Masculina");
		eBO.cadastrar(e82);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e83 = new Especialidade();
		e83.setAtividade(a59);
		e83.setNome("Tratamento de Gordura Localizada");
		eBO.cadastrar(e83);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e84 = new Especialidade();
		e84.setAtividade(a59);
		e84.setNome("Carboxterapia");
		eBO.cadastrar(e84);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// salao de beleza 59
		Atividade a60 = aBO.buscarAtividade(59);

		Especialidade e85 = new Especialidade();
		e85.setAtividade(a60);
		e85.setNome("Cortes de Cabelos");
		eBO.cadastrar(e85);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e86 = new Especialidade();
		e86.setAtividade(a60);
		e86.setNome("Cortes e Coloração");
		eBO.cadastrar(e86);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e87 = new Especialidade();
		e87.setAtividade(a60);
		e87.setNome("Mãoes e Pés");
		eBO.cadastrar(e87);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e88 = new Especialidade();
		e88.setAtividade(a60);
		e88.setNome("Apliques de Cabelo");
		eBO.cadastrar(e88);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e89 = new Especialidade();
		e89.setAtividade(a60);
		e89.setNome("Alisamento de Cabelo");
		eBO.cadastrar(e89);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// cirurgia plástica
		// Atividade a61 = aBO.buscarAtividade(59);
		//
		// Especialidade e90 = new Especialidade();
		// e90.setAtividade(a61);
		// e90.setNome("Lipoaspiração");
		// eBO.cadastrar(e90);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e91 = new Especialidade();
		// e91.setAtividade(a61);
		// e91.setNome("Abdominoplastia");
		// eBO.cadastrar(e91);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e92 = new Especialidade();
		// e92.setAtividade(a61);
		// e92.setNome("Prótese Mamária");
		// eBO.cadastrar(e92);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");

		// clínica de massagem
		// Atividade a62 = aBO.buscarAtividade(59);
		//
		// Especialidade e93 = new Especialidade();
		// e93.setAtividade(a62);
		// e93.setNome("Massagem Relaxante");
		// eBO.cadastrar(e93);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e94 = new Especialidade();
		// e94.setAtividade(a62);
		// e94.setNome("Shiatsu");
		// eBO.cadastrar(e94);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");
		//
		// Especialidade e95 = new Especialidade();
		// e95.setAtividade(a62);
		// e95.setNome("Massagem Desportiva");
		// eBO.cadastrar(e95);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");

		// moda
		// Atividade a63 = aBO.buscarAtividade();
		//
		// Especialidade e96 = new Especialidade();
		// e96.setAtividade(a63);
		// e96.setNome("Massagem Relaxante");
		// eBO.cadastrar(e96);
		// System.out.println("\n *** Especialidade Cadastrada *** \n");

		// desenvolvimento Mobile
		Atividade a61 = aBO.buscarAtividade(62);

		Especialidade e28 = new Especialidade();
		e28.setAtividade(a61);
		e28.setNome("Android");
		eBO.cadastrar(e28);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		Especialidade e29 = new Especialidade();
		e29.setAtividade(a61);
		e29.setNome("iOS");
		eBO.cadastrar(e29);
		System.out.println("\n *** Especialidade Cadastrada *** \n");

		// desenvolvimento de software 63

		// suporte técnico 64

		// WebDesigner 65

		// consultoria financeira 66

		// vestuário e moda 67

		// marketing promocional 68

		// publicidade 69

		// funilaria 21

		// mecâncica 22

		// auto-elétrica 23

		// outros 24

		// higienização de carros 25

		// locação de ambulância (null)

		// cursos de linguas (75)

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
		a15.setNome("Animais de Grande Porte");
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
		a20.setNome("Montador de Móveis");
		a20.setCategoria(c3);
		aBO.cadastrar(a20);
		System.out.println("*** Atividade Cadastrada ***");

		// Construção
		Categoria c4 = cBO.buscar(53);

		// Atividade a21 = new Atividade();
		// a21.setNome("Materiais de construção");
		// a21.setCategoria(c4);
		// aBO.cadastrar(a21);
		// System.out.println("*** Atividade Cadastrada ***");

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
		a26.setNome("Telhado e Cobertura");
		a26.setCategoria(c4);
		aBO.cadastrar(a26);
		System.out.println("*** Atividade Cadastrada ***");

		// Atividade a27 = new Atividade();
		// a27.setNome("Telhado e cobertura");
		// a27.setCategoria(c4);
		// aBO.cadastrar(a27);
		// System.out.println("*** Atividade Cadastrada ***");

		// Atividade a28 = new Atividade();
		// a28.setNome("Documentação");
		// a28.setCategoria(c4);
		// aBO.cadastrar(a28);
		// System.out.println("*** Atividade Cadastrada ***");

		Atividade a29 = new Atividade();
		a29.setNome("Equipamento de Segurança");
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

		// Atividade a32 = new Atividade();
		// a32.setNome("Cerca");
		// a32.setCategoria(c4);
		// aBO.cadastrar(a32);
		// System.out.println("*** Atividade Cadastrada ***");

		Atividade a33 = new Atividade();
		a33.setNome("Demolição e Descarte");
		a33.setCategoria(c4);
		aBO.cadastrar(a33);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a34 = new Atividade();
		a34.setNome("Preparação de Terreno");
		a34.setCategoria(c4);
		aBO.cadastrar(a34);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a35 = new Atividade();
		a35.setNome("Porta, Portão e Janela");
		a35.setCategoria(c4);
		aBO.cadastrar(a35);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a36 = new Atividade();
		a36.setNome("Eletricidade");
		a36.setCategoria(c4);
		aBO.cadastrar(a36);
		System.out.println("*** Atividade Cadastrada ***");

		// Atividade a37 = new Atividade();
		// a37.setNome("Construção");
		// a37.setCategoria(c4);
		// aBO.cadastrar(a37);
		// System.out.println("*** Atividade Cadastrada ***");

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
		a38.setNome("Serviço de Taxi Aéreo");
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
		a41.setNome("Informática e Telecom");
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
		a50.setNome("Translado");
		a50.setCategoria(c9);
		aBO.cadastrar(a50);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a51 = new Atividade();
		a51.setNome("Transportadora");
		a51.setCategoria(c9);
		aBO.cadastrar(a51);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a52 = new Atividade();
		a52.setNome("Serviços de Armazenamento");
		a52.setCategoria(c9);
		aBO.cadastrar(a52);
		System.out.println("*** Atividade Cadastrada ***");

		// viagem e turismo
		Categoria c10 = cBO.buscar(59);

		Atividade a53 = new Atividade();
		a53.setNome("Pacote Turístico");
		a53.setCategoria(c10);
		aBO.cadastrar(a53);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a54 = new Atividade();
		a54.setNome("Acampamento de Férias");
		a54.setCategoria(c10);
		aBO.cadastrar(a54);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a55 = new Atividade();
		a55.setNome("Passeios Turísticos");
		a55.setCategoria(c10);
		aBO.cadastrar(a55);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a56 = new Atividade();
		a56.setNome("Guia Turístico");
		a56.setCategoria(c10);
		aBO.cadastrar(a56);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a57 = new Atividade();
		a57.setNome("Esportes Radicais");
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
		a62.setNome("Salão de Beleza");
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
		a11.setNome("Desenvolvimento de Software");
		a11.setCategoria(c14);
		aBO.cadastrar(a11);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a12 = new Atividade();
		a12.setNome("Suporte Técnico");
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
		a72.setNome("Vestuário e Moda");
		a72.setCategoria(c15);
		aBO.cadastrar(a72);
		System.out.println("*** Atividade Cadastrada ***");

		// publicidade e marketing
		Categoria c16 = cBO.buscar(64);

		Atividade a73 = new Atividade();
		a73.setNome("Marketing Promocional");
		a73.setCategoria(c16);
		aBO.cadastrar(a73);
		System.out.println("*** Atividade Cadastrada ***");

		Atividade a74 = new Atividade();
		a74.setNome("Publicidade");
		a74.setCategoria(c16);
		aBO.cadastrar(a74);
		System.out.println("*** Atividade Cadastrada ***");

		// aulas
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
		a80.setNome("Idiomas");
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
		c3.setNome("Arquitetura e Decoração");
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
		c6.setNome("Festas e Eventos");
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
		c9.setNome("Transporte e Mudança");
		cBO.cadastrar(c9);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c10 = new Categoria();
		c10.setNome("Viagem e Turismo");
		cBO.cadastrar(c10);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c11 = new Categoria();
		c11.setNome("Serviços Gerais");
		cBO.cadastrar(c11);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c12 = new Categoria();
		c12.setNome("Saúde e Beleza");
		cBO.cadastrar(c12);
		System.out.println("*** CATEGORIA CADASTRADA ***");

		Categoria c13 = new Categoria();
		c13.setNome("Serviços Gráficos");
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
		c16.setNome("Publicidade e Marketing");
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