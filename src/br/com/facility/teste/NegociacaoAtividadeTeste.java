package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.bo.NegociacaoAtividadeBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoAtividadeEspecialidade;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;

public class NegociacaoAtividadeTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static NegociacaoAtividadeBO naBO = new NegociacaoAtividadeBO(em);
	private static NegociacaoAtividade na;
	private static NegociacaoBO nBO = new NegociacaoBO(em);
	private static AtividadeBO aBO = new AtividadeBO(em);
	private static EspecialidadeBO eBO = new EspecialidadeBO(em);
	private static Negociacao n;
	
	public static void main(String[] args) {
		
		// cadastra usuário, cliente e profissional
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		// cadastra projeto e negociacao
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		//cadastra atividade e especialidade
		//AtividadeTeste.cadastarAtividade();
		//EspecialidadeTeste.cadastrarEspecialidade();
		
		
		// Métodos próprios dessa classe Teste
		cadastrarNegociacaoAtividade();
		consultaNegociacaoAtividade();
		
		listaPorNegociacao();
		
		alteraNegociacaoAtividade();
		consultaNegociacaoAtividade();
		
		removeNegociacaoAtividade();
		consultaNegociacaoAtividade();
	}
	
	public static void cadastrarNegociacaoAtividade(){
		
		n = nBO.buscar(1);
		na = new NegociacaoAtividade();
		na.setNegociacao(n);
		na.setAtividade(aBO.buscar(1));
		na.setEspecialidade(eBO.buscar(5));
		na.setItem(1);
		na.setTipo(TipoAtividadeEspecialidade.ESPECIALIDADE);
		na.setValor(145);

		naBO.cadastrar(na);
		System.out.println("**Negociação Atividade cadastrada com sucesso**");

		n = nBO.buscar(1);
		na = new NegociacaoAtividade();
		na.setNegociacao(n);
		na.setAtividade(aBO.buscar(1));
		na.setEspecialidade(eBO.buscar(6));
		na.setItem(2);
		na.setTipo(TipoAtividadeEspecialidade.ESPECIALIDADE);
		na.setValor(230);

		naBO.cadastrar(na);
		System.out.println("**Negociação Atividade cadastrada com sucesso**");

	}
	
	public static void consultaNegociacaoAtividade(){
		n = nBO.buscar(1);
		na = naBO.buscar(1, n);
		
		if(na != null){
					
			System.out.println("Nro Protocolo: " + na.getNegociacao().getProtocolo());
			System.out.println("Atividade: " + na.getAtividade().getNome());
			if(na.getTipo() == TipoAtividadeEspecialidade.ESPECIALIDADE){
				System.out.println("Especialidade: " + na.getEspecialidade().getNome());				
			}
			System.out.println("Valor: " + na.getValor());
		}else{
			System.out.println("**Negociação Atividade não encontrada**");
		}
	}
	
	public static void alteraNegociacaoAtividade(){
		na.setValor(200);
		naBO.alterar(na);
		System.out.println("**Negociacao Atividade alterado**");
		
	}
	
	public static void removeNegociacaoAtividade(){
		naBO.remover(na);
		System.out.println("**Negociacao Atividade deletado");
	}
	
	public static void listaPorNegociacao(){
		n = nBO.buscar(1);
		List<NegociacaoAtividade> lst = naBO.listarPorNegociacao(n);
		
		if(!lst.isEmpty()){
			System.out.println("Consulta Por Nro Protocolo " + n.getProtocolo());
			for (NegociacaoAtividade na : lst) {
				
				System.out.println("\nNro Protocolo: " + na.getNegociacao().getProtocolo());
				System.out.println("Atividade: " + na.getAtividade().getNome());
				if(na.getTipo() == TipoAtividadeEspecialidade.ESPECIALIDADE){
					System.out.println("Especialidade: " + na.getEspecialidade().getNome());				
				}
				System.out.println("Valor: " + na.getValor());
			}
		}else{
			System.out.println("**Negociação não tem Negociacao Atividade cadastrada**");
		}
		
	}

}
