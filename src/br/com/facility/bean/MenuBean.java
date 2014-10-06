package br.com.facility.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.component.menu.Menu;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuItem;
import org.primefaces.model.menu.MenuModel;
import org.primefaces.model.menu.Submenu;

import br.com.facility.bo.AtividadeBO;
import br.com.facility.bo.CategoriaBO;

//@ManagedBean
public class MenuBean implements Serializable {
//
////	 @Autowired
////	 private MenuBO menuBO;
//	 private CategoriaBO cBO;
//	 private AtividadeBO aBO;
//
//	 private MenuModel menuModel;
//	
//	@PostConstruct
//	public void init(){
//		FacesContext fc = FacesContext.getCurrentInstance();
//		List<Menu> listaMenus = menuBO.getListaMenuOrdenado();
//        // MONTA MENU DINAMICO
//        menuModel = new DefaultMenuModel();
//
//        for (Menu menu : listaMenus)
//        {
//            Submenu subMenu = new Submenu();
//            subMenu.setLabel(menu.getNome());
//            for (Funcionalidade funcionalidade : menu.getListaFuncionalidades())
//            {
//                MenuItem menuItem = new MenuItem();
//                menuItem.setImmediate(true);
//                menuItem.setProcess("@this");
//
//                menuItem.setValue(funcionalidade.getNome());
//                //
//                // menuItem.setActionExpression(createMethodExpression(funcionalidade.getAction()));
//                menuItem.setAction(createMethodBinding(funcionalidade.getAction()));
//                subMenu.getChildren().add(menuItem);
//            }
//            menuModel.addSubmenu(subMenu);
//
//        }
//		
//	}
//	
}
