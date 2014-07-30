/**
 * 
 */
package br.com.facility.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.bo.CurriculoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.NivelIdioma;
import br.com.facility.to.Curriculo;
import br.com.facility.to.CurriculoFormacao;
import br.com.facility.to.CurriculoIdioma;
import br.com.facility.to.CurriculoImagem;
import br.com.facility.to.CurriculoURL;

public class CurriculoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static CurriculoBO cBO = new CurriculoBO(em);
	private static UsuarioBO uBO = new UsuarioBO(em);
	
	private static Curriculo c;
	private static CurriculoFormacao cF;
	private static CurriculoIdioma cId;
	private static CurriculoImagem cIm;
 	private static CurriculoURL cUrl;
 	
 	private static List<CurriculoFormacao> listaCF = new ArrayList<>();
 	private static List<CurriculoIdioma> listaCId = new ArrayList<>();
 	private static List<CurriculoImagem> listaCIm = new ArrayList<>();
 	private static List<CurriculoURL> listaCUrl = new ArrayList<>();
	
	public static void main(String[] args) {
		
		// cadastra usuário, cliente e profissional
		
		
		UsuarioTeste.cadastraUsuario();
		UsuarioTeste.cadastraClienteFisico();
		UsuarioTeste.cadastraProfissional();
		
		adicionaCurriculo();
		adicionaFormacao();
		adicionaIdioma();
		adicionaImagem();
		adicionaUrl();
		
		
		consultaCurriculo();
		/*
		
		alteraCurriculo();
		alteraFormacao();
		alteraIdioma();
		alteraImagem();
		alteraUrl();
		
		consultaCurriculo();
		
		
		removeFormacao();
		removeIdioma();
		removeImagem();
		removeUrl();
		
		consultaCurriculo();
		
		removeCurriculo();
		consultaCurriculo();
		*/
	}
	

	
	public static void adicionaFormacao(){
		
		cF = new CurriculoFormacao();
		
		cF.setInstituicao("Fiap");
		cF.setCurso("Analise");
		cF.setDataConclusao(Calendar.getInstance());
		
		listaCF.add(cF);
		
		cBO.cadastrarCFormacao(cF);
		System.out.println("Curriculo Formação Cadastrado");
		
	}
	
	public static void adicionaIdioma(){
		
		cId = new CurriculoIdioma();
		
		cId.setIdioma("Ingles");
		cId.setNivel(NivelIdioma.INTERMEDIARIO);
		
		listaCId.add(cId);
		
		cBO.cadastrarCIdioma(cId);
		System.out.println("Curriculo Idioma cadastrado");
		
	}
	
	public static void adicionaImagem(){
		
		cIm = new CurriculoImagem();
		
		cIm.setUrl("facebook.com");
		cIm.setDescricao("Rede Social");
		
		listaCIm.add(cIm);
		
		cBO.cadastrarCImagem(cIm);
		System.out.println("Curriculo Imagem cadastrado");
		
	}
	
	public static void adicionaUrl(){
		
		cUrl = new CurriculoURL();
		
		cUrl.setUrl("twitter.com");
		cUrl.setTipo("Rede Social");
		
		listaCUrl.add(cUrl);
		
		cBO.cadastrarCUrl(cUrl);
		System.out.println("Curriculo Url Cadastrado");
		
	}
	
	public static void adicionaCurriculo(){
		
		c = new Curriculo();
		
		c.setProfissional(uBO.buscarProfissional(1));
		c.setResumo("Zica do Pantano Teste!");
		
		c.setFormacoes(listaCF);
		c.setIdiomas(listaCId);
		c.setImagens(listaCIm);
		c.setUrls(listaCUrl);
		
		cBO.cadastrarCurriculo(c);
		System.out.println("Curriculo Cadastrado");
		
	}
	
	public static void removeFormacao(){
		
		cBO.removerCFormacao(cF);
		System.out.println("**Curriculo Formação deletado**");
		
	}
	
	public static void removeIdioma(){
		
		cBO.removerCIdioma(cId);
		System.out.println("**Curriculo Idioma deletado**");
		
	}
	
	public static void removeImagem(){
		
		cBO.removerCImagem(cIm);
		System.out.println("**Curriculo Imagem deletada**");
		
	}
	
	public static void removeUrl(){
		
		cBO.removerCUrl(cUrl);
		System.out.println("**Curriculo Url deletado**");
		
	}
	
	public static void removeCurriculo(){
		
		cBO.removerCurriculo(c);
		System.out.println("**Curriculo deletado**");
		
	}
	
	public static void alteraFormacao(){
		
		cF.setCurso("Sistema da Informação");
		cBO.alterarCFormacao(cF);
		
		System.out.println("**Curriculo Formação alterado**");
		
	}
	
	public static void alteraIdioma(){
		
		cId.setIdioma("Espanhol");
		cBO.alterarCIdioma(cId);
		
		System.out.println("**Curriculo Idioma alterado**");
		
	}
	
	public static void alteraImagem(){
		
		cIm.setDescricao("Social");
		cBO.alterarCImagem(cIm);
		
		System.out.println("**Curriculo Imagem alterada**");
		
	}
	
	public static void alteraUrl(){
		
		cUrl.setUrl("google.com.br");
		cBO.alterarCUrl(cUrl);
		
		System.out.println("**Curriculo Url alterado**");
		
	}
	
	public static void alteraCurriculo(){
		
		c.setResumo("Melhorando");
		cBO.alterarCurriculo(c);
		
		System.out.println("**Curriculo alterado**");
		
	}
	
	public static void consultaCurriculo(){
	
		Curriculo c = cBO.buscarCurriculo(1);
		
		
		if (c != null) {
		
			System.out.println(c.getProfissional());
			System.out.println(c.getResumo());
			
			for (CurriculoFormacao listaFormacao : c.getFormacoes()) {
				
				System.out.println(listaFormacao.getInstituicao());
				System.out.println(listaFormacao.getCurso());
				System.out.println(listaFormacao.getDataConclusao());
				
			}
			
			for (CurriculoIdioma listaIdioma : c.getIdiomas()) {
				
				System.out.println(listaIdioma.getIdioma());
				System.out.println(listaIdioma.getNivel());
				
			}
			
			for (CurriculoImagem listaImagem : c.getImagens()) {
				
				System.out.println(listaImagem.getUrl());
				System.out.println(listaImagem.getDescricao());
				
			}
			
			for (CurriculoURL listaUrl : c.getUrls()) {
				
				System.out.println(listaUrl.getUrl());
				System.out.println(listaUrl.getTipo());
				
			}
			
		}else{
			System.out.println("**Curriculo não existe**");
		}
		
	}	
	
	
}
