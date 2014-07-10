package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.EntityManagerFactorySingleton;
import br.com.facility.dao.TelefoneDAO;
import br.com.facility.dao.impl.TelefoneDAOImpl;
import br.com.facility.to.Telefone;
import br.com.facility.to.TelefonePK;
import br.com.facility.to.Usuario;

public class TelefoneBO {

	private EntityManager em;
	private TelefoneDAO tDao;
	
	public TelefoneBO(EntityManager e){
		//em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		em = e;
		tDao = new TelefoneDAOImpl(em);
	}
	
	public void inserir(Telefone t){
		tDao.insert(t);
	}
	
	public void remover(Telefone t){
		tDao.remove(t);
	}
	
	public void alterar(Telefone t){
		tDao.update(t);
	}
	
	public Telefone consultar(TelefonePK id){
		Telefone t = tDao.searchByID(id);
		return t;
	}
	
	public List<Telefone> listarTodos(Usuario usuario){
		List<Telefone> lst = tDao.buscarPorUsuario(usuario);
		return lst;
	}
	
}
