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
	private UsuarioBO uBO;

	@PostConstruct
	public void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
		profissional = new Profissional();
	}

	public String cadastrar() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			usuario = ((Usuario) session.getAttribute("usuario"));
			usuario = uBO.buscar(usuario.getId());

			this.uBO.cadastrarProfissional(usuario,profissional);
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Profissional Cadastrado", "Profissional Cadastrado com Sucesso"));
			return "/xhtml/private/professional/index-logado";
		} catch (Exception e) {
			e.printStackTrace();
			return "/xhtml/private/professional/cadastrar-profissional";
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
