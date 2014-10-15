package br.com.facility.bean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoUsuario;
import br.com.facility.to.Usuario;

@ManagedBean
@RequestScoped
public class UsuarioLoginBean implements Serializable {

	private static final long serialVersionUID = -1397268246305929012L;
	private UsuarioBO uBO;
	private Usuario usuario;
	private String user;
	private String senha;
	private HttpSession session;
	
	private FacesContext context;

	public String logar(){
		
		uBO = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		usuario = uBO.logar(user, senha);
		
		if(usuario != null){
			context = FacesContext.getCurrentInstance();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Logado", "User Logado"));
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);

			session.setAttribute("usuario", usuario);
			
			if(usuario.getTipo() == TipoUsuario.CLIENTE || usuario.getTipo() == TipoUsuario.PROFISSIONAL){
				usuario.setClienteLogado(true);
				return "/xhtml/private/client/index-logado";
			}else{
				return "/xhtml/public/index";
			}
			
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
	
	public String mudarPerfilCliente(){

		usuario.setClienteLogado(true);
		usuario.setProfissionalLogado(false);
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("usuario", usuario);
		return "/xhtml/private/client/index-logado";
		
	}
	
	public String mudarPerfilProfissional(){
		usuario = getUsuarioLogado();
		usuario.setProfissionalLogado(true);
		usuario.setClienteLogado(false);
		HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
		session.setAttribute("usuario", usuario);
		return "/xhtml/private/professional/index-logado";
	}
	
	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		usuario = uBO.buscar(usuario.getId());
		return usuario;
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
