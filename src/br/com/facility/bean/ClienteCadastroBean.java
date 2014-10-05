package br.com.facility.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.facility.bo.EnderecoUsuarioBO;
import br.com.facility.bo.ResponsavelBO;
import br.com.facility.bo.TelefoneBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.Responsavel;
import br.com.facility.to.Telefone;
import br.com.facility.to.Usuario;

@ViewScoped
@ManagedBean
public class ClienteCadastroBean implements Serializable {

	private static final long serialVersionUID = -2742342275179908597L;

	private ClienteFisico cliente;
	
	private ClienteJuridico clienteJuridico;
	
	private Telefone telefone;
	
	private EnderecoUsuario endereco;
	
	private Responsavel responsavel;
	
	public ClienteFisico getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFisico cliente) {
		this.cliente = cliente;
	}
	
	public ClienteJuridico getClienteJuridico() {
		return clienteJuridico;
	}

	public void setClienteJuridico(ClienteJuridico clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}
	
	public EnderecoUsuario getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoUsuario endereco) {
		this.endereco = endereco;
	}


	private UsuarioBO bo;
	private TelefoneBO telefoneBO;
	private EnderecoUsuarioBO enderecoBO;
	private ResponsavelBO responsavelBO;
	
	@PostConstruct
	public void init(){
		bo 		= new UsuarioBO(getEntityManager());
		cliente 	= new ClienteFisico();
		clienteJuridico = new ClienteJuridico();
		telefone = new Telefone();
		telefoneBO = new TelefoneBO(getEntityManager());
		enderecoBO= new EnderecoUsuarioBO(getEntityManager());
	}
	
	public void cadastrarClienteFisico(){
		bo.cadastrarClienteFisico(this.getUsuarioLogado(), cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
																			"Usuário cadastrado", "Cadastrado com sucesso"));
	}
	
	public void cadastrarClienteJuridico(){
		bo.cadastrarClienteJuridico(this.getUsuarioLogado(), clienteJuridico);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
																			"Usuário cadastrado", "Cadastrado com sucesso"));
	}
	
	public void CadastrarResponsavel(){
		responsavelBO.cadastrar(responsavel, clienteJuridico);
		
	}

	public void cadastrarTelefone(){
		telefoneBO.cadastrar(telefone);
	}
	
	public void cadastrarEndereco(){
		enderecoBO.cadastrar(endereco);
		
	}
	private EntityManager getEntityManager() {
		return EntityManagerFactorySingleton.getInstance().createEntityManager();
	}
	
	//TODO: Substituir esse metodo para o usuario logado.
	protected Usuario getUsuarioLogado() {
		return bo.buscar(1);
	}

	
}
