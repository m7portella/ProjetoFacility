package br.com.facility.teste;

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
		
		// cadastra usu�rio, cliente e profissional
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		// cadastra projeto e negociacao
		ProjetoTeste.cadastraProjeto();
		NegociacaoTeste.cadastraNegociacao();
		
		//cadastra atividade e especialidade
		AtividadeTeste.cadastarAtividade();
		EspecialidadeTeste.cadastrarEspecialidade();
		
		
		// M�todos pr�prios dessa classe Teste
		cadastrarNegociacaoAtividade();
		consultaNegociacaoAtividade();
	}
	
	public static void cadastrarNegociacaoAtividade(){
		
		n = nBO.buscar(1);
		na = new NegociacaoAtividade();
		na.setNegociacao(n);
		na.setAtividade(aBO.buscar(1));
		na.setEspecialidade(eBO.buscar(5));
		na.setItem(2);
		na.setTipo(TipoAtividadeEspecialidade.EXEMPLO);
		na.setValor(145);

		naBO.cadastrar(na);
		System.out.println("**Negocia��o Atividade cadastrada com sucesso**");

	}
	
	public static void consultaNegociacaoAtividade(){
		n = nBO.buscar(1);
		na = naBO.buscar(1, n);
		
		if(na != null){
					
			System.out.println("Nro Protocolo: " + na.getNegociacao());
			System.out.println("Atividade: " + na.getAtividade().getNome());
			if(na.getEspecialidade() != null){
				System.out.println("Especialidade: " + na.getEspecialidade().getNome());				
			}
			System.out.println("Valor: " + na.getValor());
		}else{
			System.out.println("**Negocia��o Atividade n�o encontrada**");
		}
	}

}
