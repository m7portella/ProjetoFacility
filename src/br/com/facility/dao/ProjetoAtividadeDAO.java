package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Atividade;
import br.com.facility.to.Projeto;
import br.com.facility.to.ProjetoAtividade;
import br.com.facility.to.ProjetoAtividadePK;

public interface ProjetoAtividadeDAO extends DAO<ProjetoAtividade, ProjetoAtividadePK> {

	List<ProjetoAtividade> listaAtividadesPorProjeto(Projeto projeto);
	
}
