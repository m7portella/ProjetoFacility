package br.com.facility.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.metamodel.domain.Entity;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.ProjetoBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.enums.TipoAtividadeEspecialidade;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Projeto;
import br.com.facility.to.ProjetoAtividade;
import br.com.facility.to.Usuario;

@ManagedBean
@ViewScoped
public class ProjetoCadastroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Projeto projeto;
	private Usuario usuario;
	private ProjetoBO pBo;
	private UsuarioBO uBo;
	private AtividadeBO aBO;
	private int idUsuario;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Atividade> atividades = new ArrayList<Atividade>();
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();
	private List<Categoria> categoriasSelecionadas = new ArrayList<Categoria>();
	private List<Atividade> atividadesSelecionadas = new ArrayList<Atividade>();
	private List<Especialidade> especialidadesSelecionadas = new ArrayList<Especialidade>();

	@PostConstruct
	public void init() {
		EntityManager e = EntityManagerFactorySingleton.getInstance()
				.createEntityManager();
		projeto = new Projeto();
		projeto.setDataLimite(Calendar.getInstance());
		pBo = new ProjetoBO(e);
		uBo = new UsuarioBO(e);
		aBO = new AtividadeBO(e);
		categorias = aBO.listarCategorias();
	}

	public String salvar() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		usuario = (Usuario) session.getAttribute("usuario");
		usuario = uBo.buscar(usuario.getId());
		
			//Para atualizar o usuário da sessão para mostrar o projeto cadastrado na lista
			session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("usuario", usuario);

		// System.out.println("nome usuário session: " + user);

		if (usuario != null) {
			pBo.cadastrar(projeto, usuario);
			
			if(!atividadesSelecionadas.isEmpty()){

				for (Atividade ativ : atividadesSelecionadas) {
					ativ = aBO.buscarAtividade(ativ.getId());
					
					ProjetoAtividade pa = new ProjetoAtividade();
					pa.setProjeto(projeto);
					pa.setAtividade(ativ);
					
					if(!especialidadesSelecionadas.isEmpty()){
						for (Especialidade espec : especialidadesSelecionadas) {
							espec = aBO.buscarEspecialidade(espec.getId()); 
							
							pa.setEspecialidade(espec);
							pa.setTipo(TipoAtividadeEspecialidade.ESPECIALIDADE);
							pBo.cadastrarAtividade(pa);
						}
					}else{
						pa.setTipo(TipoAtividadeEspecialidade.ATIVIDADE);					
						pBo.cadastrarAtividade(pa);
					}
					
				}
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastrado",
								"Projeto Cadastrado"));
				return "/xhtml/private/client/listar-projeto";
			}
			 else{
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Falta selecionar Atividades para o Projeto",
								"Falta Atividade para o Projeto"));
				return "/xhtml/private/client/abrir-projeto";
			}
			
			
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuário"
							+ usuario + " Nulo", "Erro em Cadastrar Projeto"));
			return "/xhtml/private/client/abrir-projeto";
		}
	}
	
	public void selecionaAtividades(){
		
		List<Atividade> lista = new ArrayList<Atividade>();
		atividades = new ArrayList<Atividade>();
		
		for (Categoria cat : getCategoriasSelecionadas()) {
			lista = aBO.listarAtividades(cat);
			atividades.addAll(lista);
		}
		
		especialidades = new ArrayList<Especialidade>();
		especialidadesSelecionadas = new ArrayList<Especialidade>();
		
	}
	
	public void selecionaEspecialidades(){
		List<Especialidade> lista = new ArrayList<Especialidade>();
		especialidades = new ArrayList<Especialidade>();
		
		for(Atividade a : atividadesSelecionadas){
			lista = aBO.listarEspecialidades(a);
			especialidades.addAll(lista);
		}
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Categoria> getCategoriasSelecionadas() {
		return categoriasSelecionadas;
	}

	public void setCategoriasSelecionadas(List<Categoria> categoriasSelecionadas) {
		this.categoriasSelecionadas = categoriasSelecionadas;
	}

	public List<Atividade> getAtividadesSelecionadas() {
		return atividadesSelecionadas;
	}

	public void setAtividadesSelecionadas(List<Atividade> atividadesSelecionadas) {
		this.atividadesSelecionadas = atividadesSelecionadas;
	}

	public List<Especialidade> getEspecialidadesSelecionadas() {
		return especialidadesSelecionadas;
	}

	public void setEspecialidadesSelecionadas(
			List<Especialidade> especialidadesSelecionadas) {
		this.especialidadesSelecionadas = especialidadesSelecionadas;
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

	// seta usuario
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
