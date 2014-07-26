package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoPreco;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.Profissional;

public class AtividadeProfissionalTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static AtividadeProfissionalBO apBO = new AtividadeProfissionalBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	private static Profissional p;
	private static AtividadeProfissional ap1;
	private static EspecialidadeProfissional ep1;
	private static Especialidade e1;
	private static Atividade a1;
	private static List<AtividadeProfissional> listaA;
	private static List<EspecialidadeProfissional> listaE;
	private static List<AtividadeProfissional> listaP1;
	private static List<EspecialidadeProfissional> listaP2;
	
	public static void main(String[] args) {
		
		// cadastra usuários, cliente e profissional
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		
		// cadastra atividades e especialidades
		AtividadeTeste.cadastarAtividade();
		EspecialidadeTeste.cadastrarEspecialidade();
		
		// ATIVIDADE / ESPECIALIDADE PROFISSIONAL
		cadastraAtividade();
		consultaEspecialidade();
		//listaEspecialidades();
		
		alteraAtividade();
		listaEspecialidades();
		
		excluiAtividade();
		listaEspecialidades();
		
	}
	
	public static void cadastraAtividade(){
		
		a1 = aBO.buscar(4);
		p = uBO.buscarProfissional(1);
		
		// Atividade
		ap1 = new AtividadeProfissional();
		ap1.setPreco(80);
		ap1.setTipoPreco(TipoPreco.HORA);
		ap1.setEstrelas(4);
		apBO.cadastrar(ap1, a1, p);
		
		System.out.println("**Atividade Profissional cadastrada com sucesso**");
		e1 = eBO.buscar(6);
		
		// Especialidade
		ep1 = new EspecialidadeProfissional();
		ep1.setPreco(80);
		ep1.setTipoPreco(TipoPreco.HORA);
		ep1.setEstrelas(4);
		apBO.cadastrar(ep1, e1, p);
		
		System.out.println("**Especialidade Profissional cadastrada com sucesso**");
		
	}
	
	public static void consultaEspecialidade(){
		
		AtividadeProfissional ap = apBO.buscar(a1, p);
		System.out.println(ap.getAtividade().getNome());
		System.out.println(ap.getTipoPreco());
		System.out.println(ap.getPreco());
		
		EspecialidadeProfissional ep = apBO.buscar(e1, p);
		System.out.println(ep.getEspecialidade().getNome());
		System.out.println(ep.getExperiencia());
		System.out.println(ep.getTipoPreco());
		System.out.println(ep.getPreco());
		
	}
	
	public static void listaEspecialidades(){
		
		listaA = apBO.listarAtividadePorProfissional(p);
		for (AtividadeProfissional ap : listaA) {
			System.out.println(ap.getAtividade().getNome());
			System.out.println(ap.getTipoPreco());
			System.out.println(ap.getPreco());
		}
		
		listaE = apBO.listarEspecialidadePorProfissional(p);
		for (EspecialidadeProfissional ep : listaE) {
			System.out.println(ep.getEspecialidade().getNome());
			System.out.println(ep.getExperiencia());
			System.out.println(ep.getTipoPreco());
			System.out.println(ep.getPreco());
		}
		
		listaP1 = apBO.listarProfissionalPorAtividade(a1);
		for (AtividadeProfissional ap : listaP1) {
			System.out.println(ap.getProfissional().getId());
		}
		
		listaP2 = apBO.listarProfissionalPorEspecialidade(e1);
		for (EspecialidadeProfissional ep : listaP2) {
			System.out.println(ep.getProfissional().getId());
		}
		
	}

	public static void alteraAtividade(){
		
		ap1.setDataExperiencia(Calendar.getInstance());
		apBO.alterar(ap1);
		System.out.println("**Atividade profissional alterada**");
		
		ep1.setExperiencia("Experiência em bla bla bla...");
		apBO.alterar(ep1);
		System.out.println("**Especialidade profissional alterada**");
		
	}
	
	
	public static void excluiAtividade(){
		
		apBO.remover(ap1);
		System.out.println("**Atividade profissional removida**");
		
		apBO.remover(ep1);
		System.out.println("**Especialidade profissional removida**");
		
	}
	
	
}
