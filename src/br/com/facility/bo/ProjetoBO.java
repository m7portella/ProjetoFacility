package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.ProjetoDAO;
import br.com.facility.dao.impl.ProjetoDAOImpl;
import br.com.facility.enums.StatusProjeto;
import br.com.facility.to.Projeto;
import br.com.facility.to.Usuario;

public class ProjetoBO {

	private EntityManager em;
	private ProjetoDAO pDAO;
	
	public ProjetoBO(EntityManager e){
		em = e;
		pDAO = new ProjetoDAOImpl(em);
	}
	
	public void cadastrar(Projeto p, Usuario u){
		
		// vincula Usuário so Projeto
		p.setUsuario(u);
		// data atual
		p.setDataAbertura(Calendar.getInstance());
		// status inicial ATIVO
		p.setStatus(StatusProjeto.ATIVO);
		p.setDataStatus(Calendar.getInstance());
		
		pDAO.insert(p);
		
	}
	
	public Projeto consultar(long id){
		Projeto p = pDAO.searchByID(id);
		return p;
	}
	
	public List<Projeto> listarPorUsuario(Usuario u){
		List<Projeto> lista = pDAO.listarPorUsuario(u);
		return lista;
	}
	
	public void alterar(Projeto p){
		pDAO.update(p);
	}
	
	public void deletar(Projeto p){
		
		// RN - Projetos deletados são mantidos no BD com status DELETADO
		p.setStatus(StatusProjeto.DELETADO);
		p.setDataStatus(Calendar.getInstance());
		pDAO.update(p);
		
	}
	
}
