package br.com.facility.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.UsuarioBO;
import br.com.facility.to.Usuario;

public class FaseListener implements PhaseListener {

	HttpSession session;
	
	@Override
	public void afterPhase(PhaseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforePhase(PhaseEvent phase) {
		FacesContext context = phase.getFacesContext();
		String pagina = context.getViewRoot().getViewId();
		session = (HttpSession) context.getExternalContext().getSession(false);
		NavigationHandler navigation = context.getApplication().getNavigationHandler();
		
		
		if(session==null || session.getAttribute("usuario") == null){
			System.out.println("sessao null");
			if(pagina.contains("login") || pagina.contains("public")){
				System.out.println("login e public");
				navigation.handleNavigation(context, null, pagina);
			}else{
				System.out.println("erro");
				navigation.handleNavigation(context, null, "/xhtml/erro");
			}
		}else {
//			Usuario usuario = (Usuario) session.getAttribute("usuario");
			Usuario usuario = getUsuarioSession();
			
			
			if(usuario.isClienteLogado()){
				if(pagina.contains("client")){
					System.out.println("if client");
					navigation.handleNavigation(context, null, pagina);
				}else{
					System.out.println("else client");
					navigation.handleNavigation(context, null, "/xhtml/erro");
				}
			}else if(usuario.isProfissionalLogado()){
				if(pagina.contains("professional")){
					System.out.println("if professional");
					navigation.handleNavigation(context, null, pagina);
				}else{
					System.out.println("else professional");
					navigation.handleNavigation(context, null, "/xhtml/erro");
				}
			}else{
				if(pagina.contains("/professional/") || pagina.contains("/client/")){
					System.out.println("if !professional !client");
					navigation.handleNavigation(context, null, "/xhtml/erro");
				}else{
					navigation.handleNavigation(context, null, pagina);
				}
			}
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RENDER_RESPONSE;
	}

	public Usuario getUsuarioSession(){
		FacesContext context = FacesContext.getCurrentInstance();
		session = (HttpSession) context.getExternalContext().getSession(false);
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		return usuario;
	}

}
