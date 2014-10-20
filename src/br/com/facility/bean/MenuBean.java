package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpSession;

import org.primefaces.event.MenuActionEvent;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.CategoriaBO;
import br.com.facility.bo.UsuarioBO;
import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;
import br.com.facility.to.Usuario;

@ManagedBean
@SessionScoped
public class MenuBean implements Serializable {

	private MenuModel menuModel;
	private CategoriaBO cBO;
	private AtividadeBO aBO;
	private UsuarioBO uBO;
	private Usuario usuario;
	private static UIViewRoot uiViewRoot = new UIViewRoot();
	
	@PostConstruct
	public void init(){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uBO = new UsuarioBO(em);
		cBO = new CategoriaBO(em);
		aBO = new AtividadeBO(em);
		gerarMenu();
	}
	
	public void gerarMenu() {
		
		menuModel = new DefaultMenuModel();
		
		List<Categoria> lstCategorias = cBO.listar();
		
		for (Categoria categoria : lstCategorias) {
			DefaultSubMenu subMenuCategoria = new DefaultSubMenu(categoria.getNome());
			subMenuCategoria.setLabel(categoria.getNome());
			
			List<Atividade> lstAtividades = aBO.listarAtividades(categoria);
			
			for (Atividade atividade : lstAtividades) {
				DefaultSubMenu subMenuAtiv = new DefaultSubMenu(atividade.getNome());
				subMenuAtiv.setLabel(atividade.getNome());
				
				subMenuCategoria.addElement(subMenuAtiv);
				
				List<Especialidade> lstEspecialidades = aBO.listarEspecialidades(atividade);
				
				for (Especialidade especialidade : lstEspecialidades) {
					DefaultMenuItem menuItemEspec = new DefaultMenuItem(especialidade.getNome());
					
					menuItemEspec.setId("lstEspecialidades");
					menuItemEspec.setCommand("#{profissionalListarBean.especialidadeMenu}");
					menuItemEspec.setParam("listId", especialidade.getId());
					subMenuAtiv.addElement(menuItemEspec);
					
				}
			}
			menuModel.addElement(subMenuCategoria);
			
		}
	}

	public String displayList(ActionEvent event) {
	    MenuItem menuItem = ((MenuActionEvent) event).getMenuItem();
	    Integer id = Integer.parseInt(menuItem.getParams().get("listId").get(0));
	    Especialidade esp = aBO.buscarEspecialidade(id);
	    System.out.println("Especialidade: " + esp.getId() + " - " + esp.getNome());
	    return "xhtml/private/client/listar-profissional";
	}
	
	public Usuario getUsuarioLogado() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		
		if(session!=null || session.getAttribute("usuario") != null){
			usuario = ((Usuario) session.getAttribute("usuario"));
			usuario = uBO.buscar(usuario.getId());
			return usuario;
		}else{
			return null;
		}
		
	}

	public MenuModel getMenuModel() {
		return menuModel;
	}

	public void setMenuModel(MenuModel menuModel) {
		this.menuModel = menuModel;
	}

}
