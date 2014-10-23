package br.com.facility.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.NegociacaoBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class NegociacaoCadastroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Negociacao negociacao;
	private Usuario usuario;
	private Profissional profissional;
	private Projeto projeto;
	private NegociacaoBO nBO;
	private ProjetoBO pBO;
	private UsuarioBO uBO;
	private List<Projeto> lstProjetos = new ArrayList<Projeto>();
	private Projeto projetoSelecionado;
	private int profissionalID;
	
	@PostConstruct
	public void init(){
		negociacao = new Negociacao();
		projeto = new Projeto();
		
		EntityManager e = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBO = new UsuarioBO(e);
		pBO = new ProjetoBO(e);
	}
	
	public void cadastrar(){
		usuario = getUsuarioLogado();
		if(usuario != null){
			
			projeto = pBO.buscar(projeto.getId());
			nBO.cadastrar(negociacao, projeto, profissional);
		}else{
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Não foi possível Abrir Negociação", "Não foi possível Abrir Negociação"));
		}
	}
	
	public String chamarNegociacao(){
		
		if(profissional == null){
			profissional = uBO.buscarProfissional(profissionalID);
		}
		
		return "/xhtml/private/client/abrir-negociacao";
	}
	
	public void listarProjetosCliente(){
		
		lstProjetos = pBO.listarPorUsuario(usuario);
		
	}

	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuario = ((Usuario) session.getAttribute("usuario"));
		usuario = uBO.buscar(usuario.getId());
		return usuario;
	}
	
	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
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

	public NegociacaoBO getnBO() {
		return nBO;
	}

	public void setnBO(NegociacaoBO nBO) {
		this.nBO = nBO;
	}

	public UsuarioBO getuBO() {
		return uBO;
	}

	public void setuBO(UsuarioBO uBO) {
		this.uBO = uBO;
	}

	public List<Projeto> getLstProjetos() {
		return lstProjetos;
	}

	public void setLstProjetos(List<Projeto> lstProjetos) {
		this.lstProjetos = lstProjetos;
	}

	public Projeto getProjetoSelecionado() {
		return projetoSelecionado;
	}

	public void setProjetoSelecionado(Projeto projetoSelecionado) {
		this.projetoSelecionado = projetoSelecionado;
	}

}
