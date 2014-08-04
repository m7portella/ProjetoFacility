package br.com.facility.teste;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.QualificacaoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Qualificacao;
import br.com.facility.to.ServicoConcluido;

public class QualificacaoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static QualificacaoBO qBO = new QualificacaoBO(em);
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

		q = new Qualificacao();
		
		
	}
	
}
