package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.QualificacaoAtividade;
import br.com.facility.to.ServicoConcluido;

public interface QualificacaoAtividadeDAO extends DAO<QualificacaoAtividade, Integer> {

	public List<QualificacaoAtividade> listarPorServicoConcluido(ServicoConcluido sc);
	
}
