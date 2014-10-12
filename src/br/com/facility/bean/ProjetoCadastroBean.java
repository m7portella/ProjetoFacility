package br.com.facility.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.metamodel.domain.Entity;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@RequestScoped
public class ProjetoCadastroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projeto projeto;
	private Usuario usuario;
	private ProjetoBO pBo;
	private UsuarioBO uBo;
	private int idUsuario;

	@PostConstruct
	public void init() {
		EntityManager e = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		projeto = new Projeto();
		projeto.setDataLimite(Calendar.getInstance());
		pBo = new ProjetoBO(e);
		uBo = new UsuarioBO(e);

	}

	public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		usuario = uBo.buscar(usuario.getId());
		
			//Para atualizar o usuário da sessão para mostrar o projeto cadastrado na lista
			session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("usuario", usuario);

		// System.out.println("nome usuário session: " + user);

		if (usuario != null) {
			pBo.cadastrar(projeto, usuario);
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado",
							"Projeto Cadastrado"));
			return "/client/listar-projeto";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário"
							+ usuario + " Nulo", "Erro em Cadastrar Projeto"));
			return "/client/abrir-projeto";
		}
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	// seta usuario
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
