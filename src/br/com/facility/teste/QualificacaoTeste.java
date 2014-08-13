package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.QualificacaoBO;
import br.com.facility.bo.ServicoConcluidoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoQualificacao;
import br.com.facility.to.Qualificacao;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static QualificacaoBO qBO = new QualificacaoBO(em);
	private static ServicoConcluidoBO scBO = new ServicoConcluidoBO(em);
	private static ServicoConcluido sc;
	private static Qualificacao q;
	private static List<Qualificacao> lista;
	
	
	public static void main(String[] args) {
		
		// CADASTRA USUARIOS, PROJETO E NEGOCIACAO
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
			
		// SERVICO CONCLUIDO
		ServicoConcluidoTeste.cadastraServicoConcluido();
		
	}
	
	public static void cadastraQualificacao(){

		sc = scBO.buscar(sc.getNegociacao());
		
		q = new Qualificacao();
		q.setServicoConcluido(sc);
		q.setTipo(TipoQualificacao.PRECO);
		q.setEstrelas(3);
		q.setDescricao("Ótimo preço garotinhos!");
		q.setDataQualificacao(Calendar.getInstance());
		
		qBO.cadastrar(q, sc);
		
		System.out.println("Qualificação efetuada com Sucesso!");
		
	}
	
}
