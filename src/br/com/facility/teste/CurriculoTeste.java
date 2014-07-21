/**
 * 
 */
package br.com.facility.teste;

import javax.persistence.EntityManager;

import br.com.facility.bo.CurriculoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Curriculo;
import br.com.facility.to.CurriculoFormacao;
import br.com.facility.to.CurriculoIdioma;
import br.com.facility.to.CurriculoImagem;
import br.com.facility.to.CurriculoURL;

/**
 * @author Andersson
 *
 * Data: 20/07/2014
 *
 */
public class CurriculoTeste {

	private static EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private static CurriculoBO cBO = new CurriculoBO(em);
	private static Curriculo c;
	private static CurriculoFormacao cF;
	private static CurriculoIdioma cId;
	private static CurriculoImagem cIm;
 	private static CurriculoURL cUrl;
	
	public static void main(String[] args) {
		
		

	}

	
	
}
