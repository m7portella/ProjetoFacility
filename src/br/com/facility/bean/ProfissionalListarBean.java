package br.com.facility.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.MenuItem;

import br.com.facility.bo.AtividadeProfissionalBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.bo.AtividadeBO;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Profissional;

@ManagedBean
@ViewScoped
public class ProfissionalListarBean {

	private EntityManager em = EntityManagerFactorySingleton.getInstance()
			.createEntityManager();
	private UsuarioBO uBO;
	private List<Profissional> listaProfissional;
	private Profissional profissional;
	private AtividadeBO aBO;
	private AtividadeProfissionalBO apBO;
	private Especialidade especialidade;
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

	public void listarPorEspecialidade(int id) {
		listaProfissional = apBO.listarProfissionalPorEspecialidade(id);
	}

	public String especialidadeMenu(ActionEvent event) {
		MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
		Integer idEspec = Integer
				.parseInt(menuItem.getParams().get("listId").get(0));
		especialidade = aBO.buscarEspecialidade(idEspec);
		System.out.println("Especialidade: " + especialidade.getId() + " - "
				+ especialidade.getNome());
		
		if (especialidade == null) {
			listar();
			System.out.println("passou reto");
		} else {
			listarPorEspecialidade(especialidade.getId());
			System.out.println("Especialidade: " + especialidade.getId() + " - "
					+ especialidade.getNome());
		}
		
		return "/xhtml/private/client/listar-profissional";
	}
	
	public void buscarPorNome() {
		profissional = uBO.buscarProfissional(id);
		listaProfissional.add(profissional);
	}

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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

}
