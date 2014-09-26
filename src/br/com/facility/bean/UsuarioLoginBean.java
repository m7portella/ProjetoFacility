package br.com.facility.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioLoginBean implements Serializable {

	private static final long serialVersionUID = -1397268246305929012L;
	private UsuarioBO bo;
	private Usuario usuario;
	private String user;
	private String senha;
	private HttpSession session;

	public String logar(){
		
		bo = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		usuario = bo.buscarPorUsername(user);
		
		if(usuario.getSenha().equals(senha)){
			FacesContext context = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logado", "User Logado"));
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("usuario", user);
			
			
			return "/private/index-loggado";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username ou Senha incorreta", "Username ou Senha incorreta"));
			return "/xhtml/login/login";
		}
	}
	
	public String encerraSessao() {
		FacesContext ctx = FacesContext.getCurrentInstance();
		session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuario", null);
		session.invalidate();
		return "/xhtml/login/login";
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
