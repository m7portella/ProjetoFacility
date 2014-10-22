package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@ViewScoped
public class ProjetoListarBean implements Serializable {

	private static final long serialVersionUID = 8765298454755083587L;

	private Usuario usuario;
	private UsuarioBO uBO;
	private ProjetoBO pBO;
	private List<Projeto> lstProjetos;
	private Projeto projeto;
	private long projetoId;

	@PostConstruct
	public void init() {
		EntityManager entity = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBO = new UsuarioBO(entity);
		pBO = new ProjetoBO(entity);
		lstProjetos = listar();
	}

	public List<Projeto> listar() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		usuario = uBO.buscar(usuario.getId());

		if (usuario != null) {
			return pBO.listarPorUsuario(usuario);

			// if(getLstProjetos().isEmpty()){
			// FacesContext.getCurrentInstance().addMessage(null,
			// new FacesMessage(FacesMessage.SEVERITY_ERROR,
			// "Você não possui Projetos cadastrados. ",
			// "Lista de Projetos Nula"));
			// }
		} else {
			return null;
		}

	}

	public String statusConcluido() {
		Projeto p = pBO.buscar(projetoId);
		pBO.concluir(p);
		return "/xhtml/private/listar-projeto";
	}
	
	public String statusCancelado() {
		Projeto p = pBO.buscar(projetoId);
		pBO.cancelar(p);
		return "/xhtml/private/listar-projeto";
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Projeto> getLstProjetos() {
		return lstProjetos;
	}

	public void setLstProjetos(List<Projeto> lstProjetos) {
		this.lstProjetos = lstProjetos;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(long projetoId) {
		this.projetoId = projetoId;
	}

	
}
