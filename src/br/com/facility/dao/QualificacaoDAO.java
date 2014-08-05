package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Qualificacao;
import br.com.facility.to.QualificacaoPK;
import br.com.facility.to.ServicoConcluido;

public interface QualificacaoDAO extends DAO<Qualificacao, QualificacaoPK>{

	public List<Qualificacao> listarPorServicoConcluido(ServicoConcluido sc);
	
}
