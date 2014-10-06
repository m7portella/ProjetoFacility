package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import br.com.facility.bo.CategoriaBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Categoria;

@ManagedBean
@SessionScoped
public class CategoriaListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
	
	private CategoriaBO categoriaBO;
	
	private List<Categoria> lista;
	
	public List<Categoria> getLista() {
		return lista;
	}

	public void setLista(List<Categoria> lista) {
		this.lista = lista;
	}

	@PostConstruct
	public void init(){
		categoriaBO = new CategoriaBO(em);
		this.lista = this.listar();
	}
	
	public List<Categoria> listar(){
		this.lista = categoriaBO.listar();
		return lista;
	}
	
}
