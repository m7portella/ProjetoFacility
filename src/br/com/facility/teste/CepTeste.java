package br.com.facility.teste;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.CepBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoLogradouro;
import br.com.facility.to.Cep;

public class CepTeste {
	
	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static CepBO cBO = new CepBO(em);
	private static Cep c;
	
	public static void main(String[] args) {
		
		adicionaCEP();
		consultaCEP();
		
		alteraCEP();
		buscaCEP();
		
		deletaCEP();
		deletaPorID();
	}
	
	public static void adicionaCEP(){
		c = new Cep();
			c.setNumero("00123456");
			c.setTipoLogragouro(TipoLogradouro.RUA);
			c.setLogradouro("EFG Puxa o Agu�");
			c.setBairro("Vila das Letras");
			c.setCidade("S�o Paulo");
			c.setEstado("S�o Paulo");
			c.setPais("Brasil");
		cBO.cadastrar(c);	
	}
	
	public static void alteraCEP(){
		c = cBO.buscar(1);
		c.setBairro("Vila Penteado");
		c.setNumero("02842260");
		cBO.alterar(c);
	}
	
	public static void deletaCEP(){
		cBO.remover(c);
	}
	
	public static void deletaPorID(){
		cBO.removerPorId(1);
	}
	
	public static void consultaCEP(){
		c = cBO.buscar(1);
		System.out.println(c.getTipoLogragouro() + " " + c.getLogradouro() + ", " + c.getBairro() + " - " + c.getCidade() + "/" + c.getEstado());
	}
	
	public static void buscaCEP(){
		List<Cep> lstCep = cBO.listarPorCep("02842260");
		
		if(!lstCep.isEmpty()){
			for (Cep c : lstCep) {
				System.out.println(c.getTipoLogragouro() + " " + c.getLogradouro() + ", " + c.getBairro() + " - " + c.getCidade() + "/" + c.getEstado());
			}
		} else {
			System.out.println("**Cep n�o encontrado/cadastrado **");
		}
	}
}
