package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.LocalAtendimentoDAO;
import br.com.facility.dao.impl.LocalAtendimentoDAOImpl;
import br.com.facility.to.LocalAtendimento;

public class LocalAtendimentoBO {

	private EntityManager em;
	private LocalAtendimentoDAO lDAO;
	
	public LocalAtendimentoBO(EntityManager e){
		em = e;
		lDAO = new LocalAtendimentoDAOImpl(em);
	}
	
	public void cadastrar(LocalAtendimento local){
		lDAO.insert(local);
	}
	
	public void alterar(LocalAtendimento local){
		lDAO.update(local);
	}
	
	public void remover(LocalAtendimento local){
		lDAO.remove(local);
	}
	
	public void removerPorID(int id){
		lDAO.removeById(id);
	}
	
	public LocalAtendimento buscar(int id){
		return lDAO.searchByID(id);
	}
	
	public List<LocalAtendimento> listar(){
		List<LocalAtendimento> lst = lDAO.listarTodos();
		return lst;
	}
	
	public List<LocalAtendimento> listarPorCidade(String estado, String cidade){
		List<LocalAtendimento> lst = lDAO.listarPorCidade(estado, cidade);
		return lst;
	}
	
	public List<LocalAtendimento> listarPorEstado(String estado){
		List<LocalAtendimento> lst = lDAO.listarPorEstado(estado);
		return lst;
	}
	
}
