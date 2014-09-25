package br.com.facility.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.Sexo;
import br.com.facility.to.ClienteFisico;
import br.com.facility.to.Usuario;

@ViewScoped
@ManagedBean
public class ClienteCadastroBean implements Serializable {

	private ClienteFisico cliente;
	
	public ClienteFisico getCliente() {
		return cliente;
	}

	public void setCliente(ClienteFisico cliente) {
		this.cliente = cliente;
	}

	private UsuarioBO bo;
	private Sexo sexos;
	

	public Sexo getSexos() {
		return sexos;
	}

	public void setSexos(Sexo sexos) {
		this.sexos = sexos;
	}

	@PostConstruct
	public void init(){
		this.bo 		= new UsuarioBO(getEntityManager());
		this.cliente 	= new ClienteFisico();
	}
	
	public void cadastrar(){
		this.bo.cadastrarClienteFisico(this.getUsuarioLogado(), cliente);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
																			"Usuário cadastrado", "Cadastrado com sucesso"));
	}
	
	private EntityManager getEntityManager() {
		return EntityManagerFactorySingleton.getInstance().createEntityManager();
	}
	
	//TODO: Substituir esse metodo para o usuario logado.
	protected Usuario getUsuarioLogado() {
		return bo.buscar(1);
	}
	
}
