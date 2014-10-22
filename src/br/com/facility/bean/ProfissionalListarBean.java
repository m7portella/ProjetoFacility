package br.com.facility.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.MenuItem;

import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.bo.AtividadeBO;
import br.com.facility.to.Atividade;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Profissional;

@ManagedBean
@RequestScoped
public class ProfissionalListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance()
			.createEntityManager();
	private UsuarioBO uBO;
	private List<Profissional> listaProfissional;
	private Profissional profissional;
	private AtividadeBO aBO;
	private Atividade atividade;
	private String nome;
	private AtividadeProfissionalBO apBO;
	private List<Especialidade> especialidades = new ArrayList<Especialidade>();
	private List<Especialidade> especialidadesSelecionadas = new ArrayList<Especialidade>();
	private int id;

	@PostConstruct
	public void init() {
		uBO = new UsuarioBO(em);
		aBO = new AtividadeBO(em);
		apBO = new AtividadeProfissionalBO(em);

		
		/*if (especialidade == null) {
			listar();
			System.out.println("passou reto");
		} else {
			listarPorEspecialidade(especialidade.getId());
			System.out.println("Especialidade: " + especialidade.getId() + " - "
					+ especialidade.getNome());
		}*/

	}
	
	public String atividadeMenu(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		Integer idAtiv = Integer.parseInt(menuItem.getParams().get("listId").get(0));
		atividade = aBO.buscarAtividade(idAtiv);
		System.out.println("Atividade: " + atividade.getId() + " - " + atividade.getNome());
		
		if (atividade == null) {
			listar();
			System.out.println("passou reto");
		} else {
			listarPorAtividade(atividade.getId());
			especialidades = aBO.listarEspecialidades(atividade);
			System.out.println("Atividade: " + atividade.getId() + " - " + atividade.getNome());
		}
		
		
		return "/xhtml/public/listar-profissional";
	}
	
	public void selecionaEspecialidades(){
		
		listaProfissional = new ArrayList<Profissional>();
		
		for(Especialidade esp : especialidadesSelecionadas){
			List<Profissional> lstProf = apBO.listarProfissionalPorEspecialidade(esp.getId());
			
			for(Profissional profissional : lstProf){
				listaProfissional.add(profissional);
			}
		}
		
	}
	
	public void listarPorAtividade(int id) {
		listaProfissional = apBO.listarProfissionalPorAtividade(id);
		
		for(Profissional prof : listaProfissional){
			System.out.println(prof.getNome() + " - " + prof.getId());
		}
		
	}
	
	public void listarProf(){
		listaProfissional = uBO.listarProfissional();
	}
	
	public void buscarPorNome() {
		listaProfissional = uBO.buscarProfissionalPorNome(nome);
	}

//	public void listarPorEspecialidade(int id) {
//		listaProfissional = apBO.listarProfissionalPorEspecialidade(id);
//	}
//
//	public String especialidadeMenu(ActionEvent event) {
//		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
//		Integer idEspec = Integer
//				.parseInt(menuItem.getParams().get("listId").get(0));
//		especialidade = aBO.buscarEspecialidade(idEspec);
//		System.out.println("Especialidade: " + especialidade.getId() + " - "
//				+ especialidade.getNome());
//		
//		if (especialidade == null) {
//			listar();
//			System.out.println("passou reto");
//		} else {
//			listarPorEspecialidade(especialidade.getId());
//			System.out.println("Especialidade: " + especialidade.getId() + " - "
//					+ especialidade.getNome());
//		}
//		
//		return "/xhtml/private/client/listar-profissional";
//	}

	public List<Profissional> listar() {
		return listaProfissional = uBO.listarProfissional();
	}

	public List<Profissional> getListaProfissional() {
		return listaProfissional;
	}

	public void setListaProfissional(List<Profissional> listaProfissional) {
		this.listaProfissional = listaProfissional;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}

	public List<Especialidade> getEspecialidadesSelecionadas() {
		return especialidadesSelecionadas;
	}

	public void setEspecialidadesSelecionadas(
			List<Especialidade> especialidadesSelecionadas) {
		this.especialidadesSelecionadas = especialidadesSelecionadas;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
