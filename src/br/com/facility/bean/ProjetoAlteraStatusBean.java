package br.com.facility.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusProjeto;
import br.com.facility.to.Projeto;

@ManagedBean
@RequestScoped
public class ProjetoAlteraStatusBean {

	private Projeto p;
	private ProjetoBO pBO;
	private EntityManager em;
	
	@PostConstruct
	public void init(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		pBO = new ProjetoBO(em);
	}
	
	public void statusConcluido(){
		p.setStatus(StatusProjeto.CONCLUIDO);
		System.out.println("Status: " + p.getStatus());
		pBO.alterar(p);
	}

	public Projeto getP() {
		return p;
	}

	public void setP(Projeto p) {
		this.p = p;
	}
	
	
}
