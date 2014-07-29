package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;
import br.com.facility.to.NegociacaoAtividadePK;

public interface NegociacaoAtividadeDAO extends DAO<NegociacaoAtividade, NegociacaoAtividadePK> {

	List<NegociacaoAtividade> listaPorNegociacao(Negociacao negociacao);
	
}
