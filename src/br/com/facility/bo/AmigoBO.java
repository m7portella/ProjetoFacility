package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.AmigoDAO;
import br.com.facility.dao.impl.AmigoDAOImpl;
import br.com.facility.enums.StatusAmigo;
import br.com.facility.enums.TipoAmigo;
import br.com.facility.to.Amigo;
import br.com.facility.to.AmigoPK;
import br.com.facility.to.Usuario;

public class AmigoBO {

	private EntityManager em;
	private AmigoDAO aDAO;

	public AmigoBO(EntityManager e) {
		//em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		em = e;
		aDAO = new AmigoDAOImpl(em);
	}
	
	public void aprovar(Usuario u, Usuario a){
		
		// RN - altera em ambas as listas o status para ATIVO
		Amigo a1  = buscar(u, a);
		a1.setStatus(StatusAmigo.ATIVO);
		a1.setDataStatus(Calendar.getInstance());
		Amigo a2 = buscar(a, u);
		a2.setStatus(StatusAmigo.ATIVO);
		a2.setDataStatus(Calendar.getInstance());
		
		aDAO.update(a1);
		aDAO.update(a2);
	}

	public void adicionar(Usuario u, Usuario a, TipoAmigo t) {

		// RN - amigo é adicionado nas listas de ambos usuários
		Amigo a1 = new Amigo();
		a1.setUsuario(u);
		a1.setAmigo(a);
		// Data adicionado atual
		a1.setDataAdicionado(Calendar.getInstance());
		// Status inicial AGUARDANDO APROVAÇÃO
		a1.setStatus(StatusAmigo.AGUARDANDO_APROVACAO);
		a1.setDataStatus(Calendar.getInstance());
		a1.setFavorito(false);
		
		// TODO Definir regras para tipo de amigo (Pessoal ou profissional)
		a1.setTipo(t);

		Amigo a2 = new Amigo();
		a2.setUsuario(a);
		a2.setAmigo(u);
		// Data adicionado atual
		a2.setDataAdicionado(Calendar.getInstance());
		// Status inicial APROVAR
		a2.setStatus(StatusAmigo.APROVAR);
		a2.setDataStatus(Calendar.getInstance());
		a2.setFavorito(false);
		a2.setTipo(t);
		
		aDAO.insert(a1);
		aDAO.insert(a2);
		
	}
	
	public Amigo buscar(Usuario u, Usuario a){
		AmigoPK aPK = new AmigoPK(u.getId(), a.getId());
		Amigo a1 = aDAO.searchByID(aPK);
		return a1;
	}
	
	public List<Amigo> listarAmigos(Usuario u){
		
		List<Amigo> lista = aDAO.listarAmigos(u);
		return lista;
		
	}
	
	public void deletar(Amigo a){
		
		// RN - altera status em ambas as listas para DELETADO
		a.setStatus(StatusAmigo.DELETADO);
		Amigo a2 = buscar(a.getAmigo(), a.getUsuario());
		a2.setStatus(StatusAmigo.DELETADO);
		aDAO.update(a);
		aDAO.update(a2);
		
	}
	
	public void favoritar(Amigo a, boolean f){
		a.setFavorito(f);
		aDAO.update(a);
	}
	
	public void alterarStatus(Amigo a, StatusAmigo s){
		a.setStatus(s);
		a.setDataStatus(Calendar.getInstance());
		aDAO.update(a);
	}
	
	public void alterarTipo(Amigo a, TipoAmigo t){
		a.setTipo(t);
		aDAO.update(a);
	}

}
