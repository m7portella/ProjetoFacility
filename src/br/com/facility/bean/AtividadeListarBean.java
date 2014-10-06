package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;

@ManagedBean
@SessionScoped
public class AtividadeListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance()
			.createEntityManager();
	private AtividadeBO aBO;
	private List<Atividade> lista;
	private Categoria categoria;

	@PostConstruct
	public void init() {
		aBO = new AtividadeBO(em);
		this.lista = this.listar();
	}

	public List<Atividade> listar() {
		lista = aBO.listarAtividades();
		return lista;
	}
	
	public List<Atividade> listarPorCategoria() {
		lista = aBO.listarAtividades(categoria);
		return lista;
	}

	public List<Atividade> getLista() {
		return lista;
	}

	public void setLista(List<Atividade> lista) {
		this.lista = lista;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
