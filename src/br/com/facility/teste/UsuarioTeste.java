package br.com.facility.teste;

import javax.persistence.EntityManager;

import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.dao.UsuarioDAO;
import br.com.facility.dao.impl.UsuarioDAOImpl;
import br.com.facility.to.Usuario;

public class UsuarioTeste {
	
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO uDAO = new UsuarioDAOImpl(em);
		
		Usuario u = new Usuario();
		u.setUsername("m7portella");
		
		uDAO.insert(u);
		
	}

}
