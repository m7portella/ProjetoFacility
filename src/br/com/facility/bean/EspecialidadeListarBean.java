package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.EspecialidadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Especialidade;

@ManagedBean
@RequestScoped
public class EspecialidadeListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	private EspecialidadeBO eBO;
	private List<Especialidade> lista;
	
	public List<Especialidade> getLista() {
		return lista;
	}

	public void setLista(List<Especialidade> lista) {
		this.lista = lista;
	}

	@PostConstruct
	public void init(){
		this.eBO = new EspecialidadeBO(em);
		this.lista = this.listar();
	}
	
	public List<Especialidade> listar(){
		this.lista = eBO.listar();
		return this.lista;
	}
}
