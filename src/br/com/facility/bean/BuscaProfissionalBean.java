package br.com.facility.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

@ManagedBean
@RequestScoped
public class BuscaProfissionalBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance()
			.createEntityManager();

	private UsuarioBO uBO;

	private Profissional profissional;
	private int id;

	@PostConstruct
	public void init() {
		uBO = new UsuarioBO(em);
		profissional = new Profissional();
	}

	public void buscar() {
		try {
			Usuario u = uBO.buscar(id);
			if (u == null){
				System.out.println("\nID de usuário inválido ou profissional não cadastrado!");
			} else {
				profissional = uBO.buscarProfissional(u.getId());
				System.out.println("\nNome: " + profissional.getNome());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

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
