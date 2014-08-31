package br.com.facility.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

@ViewScoped
@ManagedBean
public class UsuarioCadastroBean implements Serializable {

	private Usuario usuario;
	UsuarioBO bo;
	
	@PostConstruct
	public void init(){
		usuario = new Usuario();
	}
	
	public void cadastrar(){
		bo = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		bo.cadastrar(usuario);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
																			"Usuário cadastrado", "Cadastrado com sucesso"));
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
