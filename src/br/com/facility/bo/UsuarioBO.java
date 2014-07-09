package br.com.facility.bo;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.dao.UsuarioDAO;
import br.com.facility.dao.impl.UsuarioDAOImpl;
import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.TipoUsuario;
import br.com.facility.to.Usuario;

public class UsuarioBO {
	
	private EntityManager em;
	private UsuarioDAO uDAO;
	
	public UsuarioBO(){
		em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		uDAO = new UsuarioDAOImpl(em);
	}
	
	public void inserir(Usuario u){
		
		// RN - Usuários são cadastrados inicialmente com tipo USUARIO
		u.setTipo(TipoUsuario.USUARIO);
		// data de cadastro atual
		u.setDataCadastro(Calendar.getInstance());
		// status inicial AGUARDANDO CONFIRMAÇÃO
		u.setStatus(StatusUsuario.AGUARDANDO_CONFIRMACAO);
		u.setDataStatus(Calendar.getInstance());
		
		uDAO.insert(u);
	}
	
	public void remover(Usuario u){
		uDAO.remove(u);
	}
	
	public void alterar(Usuario u){
		uDAO.update(u);
	}
	
	public Usuario consultar(int id){
		Usuario u = uDAO.searchByID(id);
		return u;
	}
	
	public void deletar(Usuario u){
		
		// RN - usuários deletados são mantidos no BD com status DELETADO
		u.setStatus(StatusUsuario.DELETADO);
		u.setDataStatus(Calendar.getInstance());
		
		uDAO.update(u);
	}
	
	public void ativar(Usuario u){
		
		u.setStatus(StatusUsuario.ATIVO);
		u.setDataStatus(Calendar.getInstance());
		
		uDAO.update(u);
	}

}
