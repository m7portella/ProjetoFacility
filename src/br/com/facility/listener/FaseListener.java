package br.com.facility.listener;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

import br.com.facility.bo.UsuarioBO;

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
		
		
		if(pagina.contains("/private") ){
			if (session == null || session.getAttribute("usuario") == null){
				navigation = context.getApplication().getNavigationHandler();
				navigation.handleNavigation(context, null, "/xhtml/login/login");
			}else{
				navigation.handleNavigation(context, null, pagina);
			}
		}
		
		if(pagina.contains("/login") && session.getAttribute("usuario") == null){
			navigation.handleNavigation(context, null, "/xhtml/login/login");
		}else{
			navigation.handleNavigation(context, null, pagina);
		}
		
	}

	@Override
	public PhaseId getPhaseId() {
		// TODO Auto-generated method stub
		return null;
	}



}
