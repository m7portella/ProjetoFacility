package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.CepBO;
import br.com.facility.bo.EnderecoUsuarioBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.EnderecoUsuarioPK;

public class EnderecoUsuarioTeste {

	private static EntityManager em = EntityManagerFactorySingleton
			.getInstance().createEntityManager();
	private static UsuarioBO uBO = new UsuarioBO(em);
	private static EnderecoUsuarioBO eBO = new EnderecoUsuarioBO(em);
	private static CepBO cBO = new CepBO(em);
	private static EnderecoUsuario e;
	
	public static void main(String[] args) {
		
		CepTeste.adicionaCEP();
		UsuarioTeste.cadastraUsuario();
		
		adicionaEndereco();
		consultaEndereco();
		
		alteraEndereco();
		consultaEndereco();
		
		listarPorUsuario();
//		deletaPorID();
		
	}
	
	public static void adicionaEndereco(){
		e = new EnderecoUsuario();
			e.setCep(cBO.consultar(1));
			e.setUsuario(uBO.consultar(1));
			e.setNumero(321);
		eBO.cadastrar(e);
	}
	
	public static void alteraEndereco(){
		e.setComplemento("BL.11 APTO. 21");
		eBO.alterar(e);
	}
	
	public static void deletaPorID(){
		EnderecoUsuarioPK pk = new EnderecoUsuarioPK();
			pk.setCep(1);
			pk.setUsuario(1);
		eBO.deletarPorID(pk);
	}
	
	public static void consultaEndereco(){
		EnderecoUsuarioPK pk = new EnderecoUsuarioPK();
			pk.setCep(1);
			pk.setUsuario(1);
		e = eBO.consulta(pk);
		
		System.out.println(e.getUsuario().getUsername());
		System.out.println(e.getCep().getNumero());
		System.out.println(e.getCep().getTipoLogragouro() + " " + e.getCep().getLogradouro() + ", Nº" + e.getNumero() + " " + e.getComplemento());

	}
	
	public static void listarPorUsuario(){
		List<EnderecoUsuario> lstEndereco = eBO.listarPorUsuario(uBO.consultar(1));
		
		if(!lstEndereco.isEmpty()){
			for (EnderecoUsuario end : lstEndereco) {
				System.out.println(end.getUsuario().getUsername());
				System.out.println(end.getCep().getNumero());
				System.out.println(end.getCep().getTipoLogragouro() + " " + end.getCep().getLogradouro() + ", Nº" + end.getNumero() + " " + end.getComplemento());
			}
		}
	}
}
