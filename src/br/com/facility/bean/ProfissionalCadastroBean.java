package br.com.facility.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

@ManagedBean
@RequestScoped
public class ProfissionalCadastroBean {

	private Usuario usuario;
	private Profissional profissional;
	private UsuarioBO usuarioBO;

	@PostConstruct
	public void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		usuarioBO = new UsuarioBO(em);
		profissional = new Profissional();
	}

	public void cadastrar() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			HttpSession sessao = (HttpSession) context.getExternalContext()
					.getSession(false);

			String user = (String) sessao.getAttribute("username");
			this.usuario = this.usuarioBO.buscarPorUsername(user);
			this.usuarioBO.cadastrarProfissional(this.usuario,
					this.profissional);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Profissional Cadastrado", "Profissional Cadastrado com Sucesso"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

}
