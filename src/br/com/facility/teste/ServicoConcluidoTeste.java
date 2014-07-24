package br.com.facility.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.ServicoConcluidoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusConclusao;
import br.com.facility.to.Negociacao;
import br.com.facility.to.ServicoConcluido;

public class ServicoConcluidoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static ServicoConcluidoBO scBO = new ServicoConcluidoBO(em);
	private static ServicoConcluido sc;
	private static Negociacao n;
	
	public static void main(String[] args) {
		
		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
	
		// SERVICO CONCLUIDO
		cadastraServicoConcluido();
		recuperaServicoConcluido();
		
		alteraServicoConcluido();
		recuperaServicoConcluido();
		
	}
	
	public static void cadastraServicoConcluido(){
		
		n = nBO.consultar(1);
		
		sc = new ServicoConcluido();
		sc.setNegociacao(n);
		sc.setDataConclusao(Calendar.getInstance());
		sc.setStatus(StatusConclusao.SUCESSO);
		
		scBO.cadastrar(sc, n);
		
		System.out.println("**Serviço Concluido com sucesso**");
		
	}
	
	public static void alteraServicoConcluido(){
		
		sc.setStatus(StatusConclusao.NAO_PRESTADO);
		sc.setComentario("Profissional fdp!");
		
		scBO.alterar(sc);
		
		System.out.println("**Serviço Concluido alterado com sucesso**");
		
	}
	
	public static void recuperaServicoConcluido(){
		
		ServicoConcluido s = scBO.consultar(n);
		
		System.out.println(s.getCodigo());
		System.out.println(s.getNegociacao().getProtocolo());
		System.out.println(s.getDataConclusao().getTime());
		System.out.println(s.getStatus());
		System.out.println(s.getDataConclusao().getTime());
		System.out.println(s.getComentario());
		
	}
	
}
