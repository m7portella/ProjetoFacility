package br.com.facility.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.CepBO;
import br.com.facility.bo.EnderecoUsuarioBO;
import br.com.facility.bo.ResponsavelBO;
import br.com.facility.bo.TelefoneBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusResponsavel;
import br.com.facility.enums.TipoLogradouro;
import br.com.facility.enums.TipoTelefone;
import br.com.facility.to.Cep;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.Responsavel;
import br.com.facility.to.Telefone;
import br.com.facility.to.Usuario;

@ViewScoped
@ManagedBean
public class ClienteJuridicoCadastroBean implements Serializable {

	static final long serialVersionUID = -4052213409371154662L;
	
	private ClienteJuridico cliente;
	private Responsavel responsavel;
	private Telefone telefone;
	private EnderecoUsuario endereco;
	private Usuario usuario;
	private Cep cep;
	private UsuarioBO uBo;
	private HttpSession session;
	private EntityManager em;

	@PostConstruct
	public void init() {
		this.em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBo = new UsuarioBO(em);

		cliente = new ClienteJuridico();
		responsavel= new Responsavel();
		telefone = new Telefone();
		endereco = new EnderecoUsuario();
		cep = new Cep();
	}

	public void cadastrarClienteJuridico(){
		try {

//			this.cadastrarTelefone();
			this.cadastrarEndereco();
			
			usuario = getUsuarioLogado();
			
			uBo.cadastrarClienteJuridico(usuario, cliente);
			
			usuario.setClienteLogado(true);
			setClienteLogado(usuario);

			this.cadastrarResponsavel();
		
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
							"Cliente Físico cadastrado", "Cadastrado com sucesso"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
						"Ocorreu um erro: " + e.getMessage(), ""));
			e.printStackTrace();
		}
			
	}

	private void cadastrarResponsavel(){
		responsavel.setClienteJuridico(cliente);
		new ResponsavelBO(this.getEntityManager()).cadastrar(this.responsavel, cliente);
	}
	private void cadastrarTelefone() {
//		telefone.setTipo(TipoTelefone.CELULAR);
		telefone.setUsuario(this.getUsuarioLogado());
		new TelefoneBO(this.getEntityManager()).cadastrar(telefone);
	}

	private void cadastrarEndereco() {
		this.cep.setTipoLogragouro(TipoLogradouro.RUA);
		new CepBO(this.getEntityManager()).cadastrar(this.cep);

		this.endereco.setCep(this.cep);
		this.endereco.setUsuario(this.getUsuarioLogado());

		new EnderecoUsuarioBO(this.getEntityManager()).cadastrar(endereco);
	}

	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuario = ((Usuario) session.getAttribute("usuario"));
		usuario = uBo.buscar(usuario.getId());
		return usuario;

	}
	
	private void setClienteLogado(Usuario user){
		FacesContext ctx = FacesContext.getCurrentInstance();
		session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuario", user);
		System.out.println("Setou usuário na sessão");
	}
	
	public SelectItem[] getTipoTelefone() {
		SelectItem[] itens = new SelectItem[TipoTelefone.values().length];
		int i = 0;
		for (TipoTelefone tipo : TipoTelefone.values()) {
			itens[i++] = new SelectItem(tipo, tipo.getLabel());
		}
		return itens;
	}

	private EntityManager getEntityManager() {
		return this.em;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public ClienteJuridico getCliente() {
		return cliente;
	}

	public void setCliente(ClienteJuridico cliente) {
		this.cliente = cliente;
	}

	public EnderecoUsuario getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoUsuario endereco) {
		this.endereco = endereco;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

}
