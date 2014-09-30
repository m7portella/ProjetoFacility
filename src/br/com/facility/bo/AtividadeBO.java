package br.com.facility.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.AtividadeDAO;
import br.com.facility.dao.CategoriaDAO;
import br.com.facility.dao.EspecialidadeDAO;
import br.com.facility.dao.impl.AtividadeDAOImpl;
import br.com.facility.dao.impl.CategoriaDAOImpl;
import br.com.facility.dao.impl.EspecialidadeDAOImpl;
import br.com.facility.to.Atividade;
import br.com.facility.to.Categoria;
import br.com.facility.to.Especialidade;

public class AtividadeBO {

	private EntityManager em;
	private AtividadeDAO aDAO;
	private CategoriaDAO cDAO;
	private EspecialidadeDAO eDAO;
	
	public AtividadeBO(EntityManager e) {
		em = e;
		aDAO = new AtividadeDAOImpl(em);
		cDAO = new CategoriaDAOImpl(em);
		eDAO = new EspecialidadeDAOImpl(em);
	}
	
	public void cadastrar(Atividade a) {
		aDAO.insert(a);
	}
	
	public void remover(Atividade a) {
		aDAO.remove(a);
	}
	
	public void alterar(Atividade a) {
		aDAO.update(a);
	}
	
	public Atividade buscarAtividade(Integer id) {
		Atividade a = aDAO.searchByID(id);
		return a;
	}
	
	public List<Atividade> listarAtividades() {
		List<Atividade> lista = aDAO.listarTodos();
		return lista;
	}
	
	public List<Atividade> listarAtividades(Categoria c) {
		List<Atividade> lista = aDAO.listarPorCategoria(c);
		return lista;
	}
	
	public void cadastrar(Categoria c) {
		cDAO.insert(c);
	}
	
	public void alterar(Categoria c) {
		cDAO.update(c);
	}
	
	public Categoria buscarCategoria(Integer id) {
		return cDAO.searchByID(id);
	}
	
	public List<Categoria> listarCategorias() {
		return cDAO.listar();
		
	}
	
	public void remover(Categoria c) {
		cDAO.remove(c);
	}
	
	public void cadastrar(Especialidade esp) {
		eDAO.insert(esp);
	}
	
	public void alterar(Especialidade esp) {
		eDAO.update(esp);
	}
	
	public Especialidade buscarEspecialidade(Integer id) {
		return eDAO.searchByID(id);
	}
	
	public void remover(Especialidade esp) {
		eDAO.remove(esp);
	}
	
	public List<Especialidade> listarEspecialidades(Atividade a) {
		return eDAO.listarPorAtividade(a);
	}
	
}
