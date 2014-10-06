package br.com.facility.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
public class ClienteCadastroBean implements Serializable {

	private static final long serialVersionUID = -2742342275179908597L;

	private ClienteFisico 	cliente;
	private Telefone 		telefone;
	private EnderecoUsuario endereco;
	private Cep 			cep;


	private UsuarioBO bo;
	private EntityManager em;

	
	@PostConstruct
	public void init(){
		this.em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		bo 			= new UsuarioBO(this.getEntityManager());

		cliente 	= new ClienteFisico();
		cliente.setDataNascimento(Calendar.getInstance());

		telefone 	= new Telefone();
		endereco 	= new EnderecoUsuario();
		cep			= new Cep();
	}
	
	public void cadastrarClienteFisico(){
		try {
			
			this.cadastrarTelefone();
			this.cadastrarEndereco();

			cliente.setSexo(Sexo.FEMININO);
			bo.cadastrarClienteFisico(this.getUsuarioLogado(), cliente);

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Usuário cadastrado", "Cadastrado com sucesso"));
		} catch(Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Ocorreu um erro: " + e.getMessage(), ""));
			e.printStackTrace();
		}
		
	}
	
	private void cadastrarTelefone(){
		telefone.setTipo(TipoTelefone.CELULAR);
		telefone.setUsuario( this.getUsuarioLogado() );
		new TelefoneBO(this.getEntityManager()).cadastrar(telefone);		
	}
	
	private void cadastrarEndereco(){
		this.cep.setTipoLogragouro(TipoLogradouro.RUA); 
		new CepBO(this.getEntityManager()).cadastrar(this.cep);
		 
		this.endereco.setCep(this.cep);
		this.endereco.setUsuario(this.getUsuarioLogado());
		 
		new EnderecoUsuarioBO(this.getEntityManager()).cadastrar(endereco);
	}
	
	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return bo.buscarPorUsername((String) session.getAttribute("usuario"));

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
