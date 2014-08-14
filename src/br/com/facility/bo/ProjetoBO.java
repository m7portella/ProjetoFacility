package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.ProjetoAtividadeDAO;
import br.com.facility.dao.ProjetoDAO;
import br.com.facility.dao.impl.ProjetoAtividadeDAOImpl;
import br.com.facility.dao.impl.ProjetoDAOImpl;
import br.com.facility.enums.StatusProjeto;
import br.com.facility.to.Projeto;
import br.com.facility.to.ProjetoAtividade;
import br.com.facility.to.Usuario;

public class ProjetoBO {

	private EntityManager em;
	private ProjetoDAO pDAO;
	private ProjetoAtividadeDAO paDAO;

	public ProjetoBO(EntityManager e) {
		em = e;
		pDAO = new ProjetoDAOImpl(em);
		paDAO = new ProjetoAtividadeDAOImpl(em);
	}

	public void cadastrar(Projeto p, Usuario u) {

		// vincula Usuário so Projeto
		p.setUsuario(u);
		// data atual
		p.setDataAbertura(Calendar.getInstance());
		// status inicial ATIVO
		p.setStatus(StatusProjeto.ATIVO);
		p.setDataStatus(Calendar.getInstance());

		pDAO.insert(p);

	}

	public Projeto buscar(long id) {
		Projeto p = pDAO.searchByID(id);
		return p;
	}

	public List<Projeto> listarPorUsuario(Usuario u) {
		List<Projeto> lista = pDAO.listarPorUsuario(u);
		return lista;
	}

	public void alterar(Projeto p) {
		pDAO.update(p);
	}

	public void deletar(Projeto p) {

		// RN - Projetos deletados são mantidos no BD com status DELETADO
		p.setStatus(StatusProjeto.DELETADO);
		p.setDataStatus(Calendar.getInstance());
		pDAO.update(p);

	}

	// ---------------- PROJETO ATIVIDADE ----------------- //

	public void cadastrarAtividade(ProjetoAtividade pa) {
		paDAO.insert(pa);
	}

	public void alterarAtividade(ProjetoAtividade pa) {
		paDAO.update(pa);
	}

	public void removerAtividade(ProjetoAtividade pa) {
		paDAO.remove(pa);
	}

	public List<ProjetoAtividade> listarAtividadePorProjeto(Projeto projeto) {
		List<ProjetoAtividade> lista = paDAO.listaAtividadesPorProjeto(projeto);
		return lista;
	}

}
