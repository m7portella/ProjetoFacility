package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

@ManagedBean
@ViewScoped
public class NegociacaoProfissionalListarBean {

	private Usuario usuario;
	private Profissional profissional;
	private EntityManager entityManager;
	private List<Negociacao> negociacao;
	private UsuarioBO uBO;
	private NegociacaoBO nBO;
	private long protocolo;

	@PostConstruct
	public void init() {
		this.entityManager = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBO = new UsuarioBO(entityManager);
		nBO = new NegociacaoBO(entityManager);
		this.negociacao = this.listar();
		
	}
	
	public String statusConcluido() {
		Negociacao n = nBO.buscar(protocolo);
		n.setStatus(StatusNegociacao.CONCLUIDO);
		//System.out.println(n.getStatus());
		nBO.alterar(n);
		return "/xhtml/private/profissional/listar-negociacao";
	}
	
	public String statusCancelado() {
		Negociacao n = nBO.buscar(protocolo);
		n.setStatus(StatusNegociacao.CANCELADO);
		//System.out.println(n.getStatus());
		nBO.alterar(n);
		return "/xhtml/private/profissional/listar-negociacao";
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
		
		profissional = uBO.buscarProfissional(getUsuario().getId());
		
		List<Negociacao> lista = nBO.listarPorProfissional(profissional);
		return lista;

	}

	public long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
}
