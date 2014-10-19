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
	//
	// // @Autowired
	// // private MenuBO menuBO;
	// private CategoriaBO cBO;
	// private AtividadeBO aBO;
	//
	// private MenuModel menuModel;
	//
	// @PostConstruct
	// public void init(){
	// FacesContext fc = FacesContext.getCurrentInstance();
	// List<Menu> listaMenus = menuBO.getListaMenuOrdenado();
	// // MONTA MENU DINAMICO
	// menuModel = new DefaultMenuModel();
	//
	// for (Menu menu : listaMenus)
	// {
	// Submenu subMenu = new Submenu();
	// subMenu.setLabel(menu.getNome());
	// for (Funcionalidade funcionalidade : menu.getListaFuncionalidades())
	// {
	// MenuItem menuItem = new MenuItem();
	// menuItem.setImmediate(true);
	// menuItem.setProcess("@this");
	//
	// menuItem.setValue(funcionalidade.getNome());
	// //
	// //
	// menuItem.setActionExpression(createMethodExpression(funcionalidade.getAction()));
	// menuItem.setAction(createMethodBinding(funcionalidade.getAction()));
	// subMenu.getChildren().add(menuItem);
	// }
	// menuModel.addSubmenu(subMenu);
	//
	// }
	//
	// }
	//

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
		
		
//		usuario = getUsuarioLogado();
//		if(usuario == null){
//			//MenuItem Início Facility
//			DefaultMenuItem menuItemFacility = new DefaultMenuItem();
//			menuItemFacility.setTitle("FACILITY");
//			menuItemFacility.setUrl("/xhtml/public/index.xhtml");
//			
//		}else{
//			if(usuario.isClienteLogado()){
//				//MenuItem Início Facility
//				DefaultMenuItem menuItemFacility = new DefaultMenuItem();
//				menuItemFacility.setTitle("FACILITY");
//				menuItemFacility.setUrl("/xhtml/private/client/index-logado.xhtml");
//			}
//		}
		
		
		List<Categoria> lstCategorias = cBO.listar();
		
		for (Categoria categoria : lstCategorias) {
			DefaultSubMenu subMenuCategoria = new DefaultSubMenu(categoria.getNome());
			subMenuCategoria.setLabel(categoria.getNome());
//			getMenuModel().addElement(subMenuCategoria);
			
			List<Atividade> lstAtividades = aBO.listarAtividades(categoria);
			
			for (Atividade atividade : lstAtividades) {
				DefaultSubMenu subMenuAtiv = new DefaultSubMenu(atividade.getNome());
				subMenuAtiv.setLabel(atividade.getNome());
				subMenuCategoria.addElement(subMenuAtiv);
				
//				DefaultMenuItem menuItemAtiv = new DefaultMenuItem(atividade.getNome());
//				menuItemAtiv.setTitle(atividade.getNome());
//				menuItemAtiv.setId(atividade.getId().toString());
//				subMenuCategoria.addElement(menuItemAtiv);
				
				List<Especialidade> lstEspecialidades = aBO.listarEspecialidades(atividade);
				
				int i = 0;
				for (Especialidade especialidade : lstEspecialidades) {
					DefaultMenuItem menuItemEspec = new DefaultMenuItem(especialidade.getNome());
					
					i += 1;
					
					menuItemEspec.setId("lstEspecialidades");
					menuItemEspec.setCommand("#{menuBean.displayList}");
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
//	    especialidade = esp;
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
