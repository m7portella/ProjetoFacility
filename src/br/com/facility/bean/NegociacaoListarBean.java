package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class NegociacaoListarBean implements Serializable{
	

	private static final long serialVersionUID = 1729785040771253850L;
	private Usuario usuario;
	private EntityManager entityManager;
	private List<Negociacao> negociacao;
	
	@PostConstruct
	public void init() {
		this.entityManager = EntityManagerFactorySingleton.getInstance().createEntityManager();
		this.negociacao    = this.listar();
	}

	
	public List<Negociacao> getNegociacao() {
		return negociacao;
	}

	public void setProjetos(List<Negociacao> negociacao) {
		this.negociacao=negociacao;
	}
	
	//TODO: Alterar para receber o usuario logado 
	public Usuario getUsuario() {
		this.usuario = new UsuarioBO(this.entityManager).buscar(2);
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Negociacao> listar() {
		NegociacaoBO nBO= new NegociacaoBO(this.entityManager);
		List<Negociacao> lista = nBO.listarPorUsuario(this.getUsuario());
		return lista;
		
	}
		

}