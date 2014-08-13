package br.com.facility.dao;

import java.util.List;
import br.com.facility.to.Negociacao;
import br.com.facility.to.NegociacaoAtividade;

public interface NegociacaoAtividadeDAO extends DAO<NegociacaoAtividade, Long> {

	List<NegociacaoAtividade> listaPorNegociacao(Negociacao negociacao);
	
}
