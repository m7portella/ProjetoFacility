package br.com.facility.dao;

import br.com.facility.to.Negociacao;
import br.com.facility.to.ServicoConcluido;
import br.com.facility.to.ServicoConcluidoPK;

public interface ServicoConcluidoDAO extends DAO<ServicoConcluido, ServicoConcluidoPK>{

	public ServicoConcluido consultaPorNegociacao(Negociacao n);
	
}
