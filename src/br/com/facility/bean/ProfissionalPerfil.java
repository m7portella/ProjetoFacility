package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.sun.xml.internal.txw2.Document;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.Profissional;

@ManagedBean
@ViewScoped
public class ProfissionalPerfil implements Serializable {

	
	private UsuarioBO uBO;
	private List<AtividadeProfissional> lstAtividadeProfissional;
	private List<EspecialidadeProfissional> lstEspecialidadeProfissional;
	private List<Atividade> lstAtividade;
	private List<Especialidade> lstEspecialidades;
	private Profissional profissional;
	private AtividadeProfissionalBO apBO;
	private AtividadeBO aBO;
	private TreeNode treenode;
	private int id;
	
	@PostConstruct
	public void init(){
		profissional = new Profissional();
		EntityManager em = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		uBO = new UsuarioBO(em);
		apBO = new AtividadeProfissionalBO(em);
		aBO = new AtividadeBO(em);
		mostrarPerfil();
	}
	
	public String mostrarPerfil(){
		
		profissional = uBO.buscarProfissional(id);
		lstAtividadeProfissional = apBO.listarAtividadePorProfissional(profissional);
		lstEspecialidadeProfissional = apBO.listarEspecialidadePorProfissional(profissional);
		
		treenode = criarListaAtividade();
		
		return "/xhtml/private/client/perfil-profissional";
		
	}
	
	public TreeNode criarListaAtividade(){
		TreeNode tree = new DefaultTreeNode(new Atividade(), null);
		
		for(AtividadeProfissional ativProf : lstAtividadeProfissional){
			
			TreeNode treeAtividade = new DefaultTreeNode(ativProf.getAtividade(), treenode);
			
			for (EspecialidadeProfissional especProf : lstEspecialidadeProfissional) {
				if(especProf.getEspecialidade().getAtividade() == ativProf.getAtividade()){
					TreeNode treeEspecialidade = new DefaultTreeNode(especProf.getEspecialidade(), treeAtividade);
				}
			}
			
		}
		
		return treenode;
	}
	
	public UsuarioBO getuBO() {
		return uBO;
	}

	public void setuBO(UsuarioBO uBO) {
		this.uBO = uBO;
	}

	public List<AtividadeProfissional> getLstAtividadeProfissional() {
		return lstAtividadeProfissional;
	}

	public void setLstAtividadeProfissional(
			List<AtividadeProfissional> lstAtividadeProfissional) {
		this.lstAtividadeProfissional = lstAtividadeProfissional;
	}

	public List<Atividade> getLstAtividade() {
		return lstAtividade;
	}

	public void setLstAtividade(List<Atividade> lstAtividade) {
		this.lstAtividade = lstAtividade;
	}

	public List<Especialidade> getLstEspecialidades() {
		return lstEspecialidades;
	}

	public void setLstEspecialidades(List<Especialidade> lstEspecialidades) {
		this.lstEspecialidades = lstEspecialidades;
	}

	public Profissional getProfissional() {
		return profissional;
	}


	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public TreeNode getTreenode() {
		return treenode;
	}

	public void setTreenode(TreeNode treenode) {
		this.treenode = treenode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


}
