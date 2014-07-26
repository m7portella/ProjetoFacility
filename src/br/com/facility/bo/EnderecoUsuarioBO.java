package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.EnderecoUsuarioDAO;
import br.com.facility.dao.impl.EnderecoUsuarioDAOImpl;
import br.com.facility.to.EnderecoUsuario;
import br.com.facility.to.EnderecoUsuarioPK;
import br.com.facility.to.Usuario;

public class EnderecoUsuarioBO {

	private EntityManager em;
	private EnderecoUsuarioDAO eDAO;
	
	public EnderecoUsuarioBO(EntityManager e){
		em = e;
		eDAO = new EnderecoUsuarioDAOImpl(em);
	}

	public void cadastrar(EnderecoUsuario endereco){
		eDAO.insert(endereco);
	}
	
	public void alterar(EnderecoUsuario endereco){
		eDAO.update(endereco);
	}
	
	public void remover(EnderecoUsuario endereco){
		eDAO.remove(endereco);
	}
	
	public void removerPorID(EnderecoUsuarioPK id){
		eDAO.removeById(id);
	}
	
	public EnderecoUsuario buscar(EnderecoUsuarioPK id){
		return eDAO.searchByID(id);
	}
	
	public List<EnderecoUsuario> listarPorUsuario(Usuario usuario){
		List<EnderecoUsuario> lstEndereco = eDAO.listaPorUsuario(usuario);
		return lstEndereco;
	}
}
