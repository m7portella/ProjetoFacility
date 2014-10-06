package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Profissional;

@ManagedBean
@ViewScoped
public class ProfissionalListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance()
			.createEntityManager();
	private UsuarioBO uBO;
	private List<Profissional> listaProfissional;
	private Profissional profissional;
	private int id;

	@PostConstruct
	public void init() {
		uBO = new UsuarioBO(em);
		listar();
	}
	
	public void buscarPorNome() {
		profissional = uBO.buscarProfissional(id);
		listaProfissional.add(profissional);
	}

	public List<Profissional> listar() {
		return listaProfissional = uBO.listarProfissional();
	}

	public List<Profissional> getListaProfissional() {
		return listaProfissional;
	}

	public void setListaProfissional(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
