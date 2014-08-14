package br.com.facility.bo;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.facility.dao.OrcamentoAtividadeDAO;
import br.com.facility.dao.OrcamentoDAO;
import br.com.facility.dao.impl.OrcamentoAtividadeDAOImpl;
import br.com.facility.dao.impl.OrcamentoDAOImpl;
import br.com.facility.enums.StatusOrcamento;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoAtividade;
import br.com.facility.to.OrcamentoPK;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public class OrcamentoBO {

	EntityManager em;
	OrcamentoDAO oDAO;
	OrcamentoAtividadeDAO oaDAO;

	public OrcamentoBO(EntityManager e) {
		em = e;
		oDAO = new OrcamentoDAOImpl(em);
		oaDAO = new OrcamentoAtividadeDAOImpl(em);
	}

	public void cadastrar(Orcamento o, Negociacao n) {

		// vincula Negociacao, Usuario e Profissional
		o.setNegociacao(n);
		o.setUsuario(n.getUsuario());
		o.setProfissional(n.getProfissional());
		// RN - status inicial ENVIADO
		o.setStatus(StatusOrcamento.ENVIADO);
		o.setDataStatus(Calendar.getInstance());
		oDAO.insert(o);

	}

	public Orcamento buscar(long codigo, Negociacao n) {

		OrcamentoPK oPK = new OrcamentoPK();
		oPK.setCodigo(codigo);
		oPK.setNegociacao(n.getProtocolo());
		Orcamento o = oDAO.searchByID(oPK);
		return o;

	}

	public List<Orcamento> listarPorNegociacao(Negociacao n) {
		List<Orcamento> lista = oDAO.listaPorNegociacao(n);
		return lista;
	}

	public List<Orcamento> listarPorUsuario(Usuario u) {
		List<Orcamento> lista = oDAO.listaPorUsuario(u);
		return lista;
	}

	public List<Orcamento> listarPorProfissional(Profissional p) {
		List<Orcamento> lista = oDAO.listaPorProfissional(p);
		return lista;
	}

	public void alterar(Orcamento o) {
		oDAO.update(o);
	}

	// ORCAMENTO ATIVIDADE //

	public void cadastrarOrcamentoAtividade(OrcamentoAtividade oa) {
		oaDAO.insert(oa);
	}

	public void alterarOrcamentoAtividade(OrcamentoAtividade oa) {
		oaDAO.update(oa);
	}

	public void removerOrcamentoAtividade(OrcamentoAtividade oa) {
		oaDAO.remove(oa);
	}

	public List<OrcamentoAtividade> listarPorOrcamento(Orcamento orcamento) {
		List<OrcamentoAtividade> lista = oaDAO.listaPorOrcamento(orcamento);
		return lista;
	}

}
