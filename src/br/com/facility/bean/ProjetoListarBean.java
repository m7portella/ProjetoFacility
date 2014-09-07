package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class ProjetoListarBean implements Serializable {

	private static final long serialVersionUID = 8765298454755083587L;
	
	private Usuario usuario;
	private EntityManager entityManager;
	private List<Projeto> projetos;
	
	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	//TODO: Alterar para receber o usuario logado 
	public Usuario getUsuario() {
		this.usuario = new UsuarioBO(this.entityManager).buscar(2);
		return usuario;
	}
	
	@PostConstruct
	public void init() {
		this.entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
		this.projetos = this.listar();
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Projeto> listar() {
		ProjetoBO pBO= new ProjetoBO(this.entityManager);
		List<Projeto> lista = pBO.listarPorUsuario(this.getUsuario());
		return lista;
		
	}
	

}
