package br.com.facility.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusNegociacao;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class NegociacaoProjetoListarBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	private long protocolo;
	private long projetoId;
	
	private Projeto projeto;
	private Usuario usuario;
	
	private ProjetoBO projetoBO;
	private NegociacaoBO nBO;

	private List<Negociacao> negociacao;

	@PostConstruct
	@PostUpdate
	public void init() {
		this.entityManager = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		projetoBO = new ProjetoBO(entityManager);
		nBO = new NegociacaoBO(entityManager);
		negociacao = new ArrayList<Negociacao>();
	}

	public String verNegociação() {
		projeto = projetoBO.buscar(projetoId);

		List<Negociacao> lista = listar();
		
		negociacao = lista;
		
		return "/xhtml/private/listar-negociacao-projeto";
	}

	public String statusConcluido() {
		Negociacao n = nBO.buscar(protocolo);
		n.setStatus(StatusNegociacao.CONCLUIDO);
		nBO.alterar(n);
		return "/xhtml/private/listar-negociacao-projeto";
	}
	
	public String statusCancelado() {
		Negociacao n = nBO.buscar(protocolo);
		n.setStatus(StatusNegociacao.CANCELADO);
		nBO.alterar(n);
		return "/xhtml/private/listar-negociacao-projeto";
	}
	
	public List<Negociacao> listar() {
		NegociacaoBO nBO = new NegociacaoBO(this.entityManager);

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		
		List<Negociacao> lista = nBO.listarPorProjeto(projeto);
		
		return lista;

	}

	public long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}

	public long getProjetoId() {
		return projetoId;
	}

	public void setProjetoId(long projetoId) {
		this.projetoId = projetoId;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public List<Negociacao> getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(List<Negociacao> negociacao) {
		this.negociacao = negociacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
