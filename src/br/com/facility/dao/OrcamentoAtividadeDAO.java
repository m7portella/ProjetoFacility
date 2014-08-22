package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoAtividade;
import br.com.facility.to.OrcamentoAtividadePK;

public interface OrcamentoAtividadeDAO extends DAO<OrcamentoAtividade, OrcamentoAtividadePK> {

	List<OrcamentoAtividade> listaPorOrcamento(Orcamento orcamento);
	
}
