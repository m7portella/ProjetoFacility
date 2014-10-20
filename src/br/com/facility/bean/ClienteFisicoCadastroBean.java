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
import br.com.facility.bo.TelefoneBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.Sexo;
import br.com.facility.enums.TipoLogradouro;
import br.com.facility.enums.TipoTelefone;
import br.com.facility.to.Cep;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.Telefone;
import br.com.facility.to.Usuario;

@ViewScoped
@ManagedBean
public class ClienteFisicoCadastroBean implements Serializable {

	private static final long serialVersionUID = -2742342275179908597L;

	private ClienteFisico cliente;
	private Telefone telefone;
	private EnderecoUsuario endereco;
	private Cep cep;
	private Usuario usuario;
	private UsuarioBO uBo;

	private EntityManager em;
	

	@PostConstruct
	public void init() {
		this.em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBo = new UsuarioBO(em);

		
		if(this.getUsuarioLogado().getClienteFisico() == null) {
			cliente = new ClienteFisico();
			cliente.setDataNascimento(Calendar.getInstance());
		}else{
			cliente = this.getUsuarioLogado().getClienteFisico();
		}
		

		telefone = new Telefone();
		endereco = new EnderecoUsuario();
		cep = new Cep();
	}


	public void cadastrarClienteFisico() {
		try {
			//atualiza
			if(cliente.getId() != 0) {
				uBo.alterarClienteFisico(cliente);

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Atualizacao de Cliente Fisico", "Atualizado com sucesso"));

			}else {
				this.cadastrarTelefone();
				this.cadastrarEndereco();
				
				//Cadastra
				usuario = getUsuarioLogado();
				
				usuario.setClienteLogado(true);
				setClienteLogado(usuario);
				uBo.cadastrarClienteFisico(usuario, cliente);
				
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Usu�rio cadastrado", "Cadastrado com sucesso"));
			}

		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro: " + e.getMessage(), ""));
			e.printStackTrace();
		}

	}

	private void setClienteLogado(Usuario user){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuario", user);
		System.out.println("Setou usu�rio na sess�o - Cliente Logado: " + user.isClienteLogado());
	}
	
	private void cadastrarTelefone() {
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
		return uBo.buscar(usuario.getId());
	}

	public SelectItem[] getSexo() {
		SelectItem[] itens = new SelectItem[Sexo.values().length];
		int i = 0;
		for (Sexo sexo : Sexo.values()) {
			itens[i++] = new SelectItem(sexo, sexo.getLabel());
		}
		return itens;
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

	public ClienteFisico getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFisico cliente) {
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

}