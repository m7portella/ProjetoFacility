package br.com.facility.bean;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.StatusUsuario;
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
	
	public String cadastrar(){
		
		if(usuario.getSenha().equals(senhaRepetida)){
			uBo.cadastrar(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, 
					"Usu�rio Cadastrado", "Usu�rio Cadastrado com Sucesso"));
			return "/xhtml/login/login";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, 
					"Senhas diferentes", "Senha e Repetir Senha s�o diferentes"));
			return "/xhtml/public/cadastra-usuario";
		}
	}
	
	public void validarUsername(FacesContext context, UIComponent comp, Object obj) throws ValidatorException {
		String username = obj.toString();
		//Procura pelo username no banco de dados
		
		Usuario existente = uBo.buscarPorUsername(username);
		if(existente != null){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este Username j� est� sendo utilizado", 
						"Username j� cadastrado"));
		}
	}
	
	public void validarEmail(FacesContext context, UIComponent comp, Object obj) throws ValidatorException {
		String email = obj.toString();
		
		Usuario existente = uBo.buscarPorEmail(email);
		if(existente != null){
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Este E-mail j� est� sendo utilizado", 
						"E-mail j� cadastrado"));
		}
	}
	
	public void sobeFoto(FileUploadEvent event){

		String nomeArquivo = event.getFile().getFileName();

		File file = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images/avatars/" + nomeArquivo));
		try {
			FileOutputStream output = new FileOutputStream(file);

			output.write(IOUtils.toByteArray(event.getFile().getInputstream()));
			output.close();			
			//cliente.setFoto(nomeArquivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public StreamedContent getFoto(){
		FacesContext context = FacesContext.getCurrentInstance();
		DefaultStreamedContent foto = new DefaultStreamedContent();
		foto.setContentType("image/jpg");

		try {
			if (possuiFoto()){
				// System.out.println( context.getExternalContext().getRealPath("/") );
			}else{
				foto.setStream(new FileInputStream(
						 context.getExternalContext().getRealPath("/resources/images/sem-imagem.jpg")));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return foto;
	}
	
	private boolean possuiFoto() {
		return false;
	}
	
	public String removerConta() {
		try {
			Usuario usuario = this.getUsuarioLogado();
			usuario.setStatus(StatusUsuario.DELETADO);
			uBo.alterar(usuario);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Conta removida com sucesso", "Removida com sucesso"));
			
			return new UsuarioLoginBean().encerraSessao();

		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuario = ((Usuario) session.getAttribute("usuario"));
		return uBo.buscar(usuario.getId());
	}
	
	public String extenderCadastro(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("usuario", usuario);
		
		return "/xhtml/private/client/cadastra-cliente-fisico";
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
