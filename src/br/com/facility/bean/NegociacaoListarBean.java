package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class NegociacaoListarBean implements Serializable {

	private static final long serialVersionUID = 1729785040771253850L;
	private Usuario usuario;
	private EntityManager entityManager;
	private List<Negociacao> negociacao;
	private UsuarioBO uBO;
	private NegociacaoBO nBO;
	private long protocolo;

	@PostConstruct
	public void init() {
		this.entityManager = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		this.negociacao = this.listar();
		uBO = new UsuarioBO(entityManager);
		nBO = new NegociacaoBO(entityManager);
		
	}
	
	public void statusConcluido() {
		Negociacao n = nBO.buscar(protocolo);
		n.setStatus(StatusNegociacao.CONCLUIDO);
		System.out.println(n.getStatus());
		nBO.alterar(n);
	}

	public List<Negociacao> getNegociacao() {
		return negociacao;
	}

	public void setProjetos(List<Negociacao> negociacao) {
		this.negociacao = negociacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Negociacao> listar() {
		NegociacaoBO nBO = new NegociacaoBO(this.entityManager);
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		this.usuario = (Usuario) session.getAttribute("usuario");
		
		List<Negociacao> lista = nBO.listarPorUsuario(this.getUsuario());
		return lista;

	}

	public long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}

}