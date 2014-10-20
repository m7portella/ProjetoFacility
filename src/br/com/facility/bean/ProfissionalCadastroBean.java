package br.com.facility.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.AtividadeProfissional;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.EspecialidadeProfissional;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

@ManagedBean
@ViewScoped
public class ProfissionalCadastroBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
	private Profissional profissional;
	private UsuarioBO uBO;
	private AtividadeBO aBO;
	private AtividadeProfissionalBO apBo;
	private List<Categoria> categorias = new ArrayList<Categoria>();
	private List<Atividade> atividades = new ArrayList<Atividade>();
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();
	private List<Categoria> categoriasSelecionadas = new ArrayList<Categoria>();
	private List<Atividade> atividadesSelecionadas = new ArrayList<Atividade>();
	private List<Especialidade> especialidadesSelecionadas = new ArrayList<Especialidade>();

	@PostConstruct
	public void init() {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
		aBO = new AtividadeBO(em);
		apBo = new AtividadeProfissionalBO(em);
		profissional = new Profissional();
		categorias = aBO.listarCategorias();
		//atividades = aBO.listarAtividades();
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

	public String cadastrar() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			
			HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
			usuario = ((Usuario) session.getAttribute("usuario"));
			usuario = uBO.buscar(usuario.getId());

			this.uBO.cadastrarProfissional(usuario,profissional);
			
			usuario.setClienteLogado(false);
			usuario.setProfissionalLogado(true);
			setClienteLogado(usuario);
			
			//Cadastrar Atividade e Especialidade
			
			if(!atividadesSelecionadas.isEmpty()){
				
				for (Atividade ativ : atividadesSelecionadas) {
					AtividadeProfissional ativProf = new AtividadeProfissional();
 					
					ativ = aBO.buscarAtividade(ativ.getId());
					
					apBo.cadastrar(ativProf, ativ, profissional);
				}
				
			}
			
			if(!especialidadesSelecionadas.isEmpty()){
				for (Especialidade espec : especialidadesSelecionadas) {
					EspecialidadeProfissional especProf = new EspecialidadeProfissional();
					espec = aBO.buscarEspecialidade(espec.getId());
					
					apBo.cadastrar(especProf, espec, profissional);
				}
			}
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Profissional Cadastrado", "Profissional Cadastrado com Sucesso"));
			return "/xhtml/private/professional/index-logado";
		} catch (Exception e) {
			e.printStackTrace();
			return "/xhtml/private/professional/cadastrar-profissional";
		}
		
	}
	
	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuario = ((Usuario) session.getAttribute("usuario"));
		usuario = uBO.buscar(usuario.getId());
		return usuario;
	}
	
	private void setClienteLogado(Usuario user){
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) ctx.getExternalContext().getSession(false);
		session.setAttribute("usuario", user);
		System.out.println("Setou usuário na sessão - Profissional Logado: " + user.isProfissionalLogado());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
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

	public List<Categoria> getCategoriasSelecionadas() {
		return categoriasSelecionadas;
	}

	public void setCategoriasSelecionadas(List<Categoria> categoriasSelecionadas) {
		this.categoriasSelecionadas = categoriasSelecionadas;
	}

}
