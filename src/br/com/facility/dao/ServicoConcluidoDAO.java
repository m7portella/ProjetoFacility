package br.com.facility.dao;

import br.com.facility.to.Negociacao;
import br.com.facility.to.ServicoConcluido;

public interface ServicoConcluidoDAO extends DAO<ServicoConcluido, Long>{

	public ServicoConcluido consultaPorNegociacao(Negociacao n);
	
}
