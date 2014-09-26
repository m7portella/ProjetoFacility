package br.com.facility.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Usuario;

@RequestScoped
@ManagedBean
public class UsuarioCadastroBean implements Serializable {

	private Usuario usuario;
	private String senhaRepetida;
	UsuarioBO uBo;
	
	@PostConstruct
	public void init(){
		uBo = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		usuario = new Usuario();
	}
	
	public void cadastrar(){
		if(usuario.equals(senhaRepetida)){
			uBo.cadastrar(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Usuário Cadastrado", "Usuário Cadastrado com Sucesso"));
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Senhas diferentes", "Senha e Repetir Senha são diferentes"));
		}
	}
	
	public void validarUsername(FacesContext context, UIComponent comp, Object obj) throws ValidatorException {
		String username = obj.toString();
		//Procura pelo email no banco de dados
		
		Usuario existente = uBo.buscarPorUsername(username);
		if(existente != null){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este Username já está sendo utilizado", 
						"Username já está sendo utilizado"));
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getSenhaRepetida() {
		return senhaRepetida;
	}

	public void setSenhaRepetida(String senhaRepetida) {
		this.senhaRepetida = senhaRepetida;
	}
	
}
