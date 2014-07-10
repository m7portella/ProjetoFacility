package br.com.facility.bo;

import javax.persistence.EntityManager;

import br.com.facility.dao.ProfissionalDAO;
import br.com.facility.dao.impl.ProfissionalDAOImpl;

public class ProfissionalBO {
	
	private EntityManager em;
	private ProfissionalDAO pDAO;
	
	public ProfissionalBO(EntityManager e){
		em = e;
		pDAO = new ProfissionalDAOImpl(em);
	}
	
	// métodos a implementar
	//cadasrtar
	//alterar
	//excluir - altera status
	//recuperar
	//buscar por usuario

}
