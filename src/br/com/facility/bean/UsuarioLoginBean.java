package br.com.facility.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class UsuarioLoginBean implements Serializable {

	private static final long serialVersionUID = -1397268246305929012L;
	private UsuarioBO bo;
	private Usuario usuario;
	private String user;
	private String senha;

	public String logar(){
		
		bo = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		setUsuario(bo.buscarPorUsername(user));
		
		if(getUsuario().getSenha().equals(senha)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuário logado", "Usuário logado com sucesso!"));
			return "index-loggado?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username ou Senha incorreta", "Username ou Senha incorreta"));
			return "login";
		}
	}


	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}
