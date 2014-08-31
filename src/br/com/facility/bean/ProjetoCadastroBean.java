package br.com.facility.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class ProjetoCadastroBean implements Serializable{

	
	private Projeto projeto;
	private Usuario usuario;
	private ProjetoBO bo;
	private UsuarioBO usuarioBO;
	private int idUsuario;
	
	@PostConstruct
	public void init(){
		projeto = new Projeto();
		projeto.setDataLimite(Calendar.getInstance());
	}
	
	public void salvar(){
		bo = new ProjetoBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
		
		usuarioBO = new UsuarioBO(EntityManagerFactorySingleton.getInstance().createEntityManager());
			usuario = usuarioBO.buscar(idUsuario);
			
		bo.cadastrar(projeto, usuario);
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	//seta usuario
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

}
