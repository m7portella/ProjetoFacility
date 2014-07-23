package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Negociacao;
import br.com.facility.to.Orcamento;
import br.com.facility.to.OrcamentoPK;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public interface OrcamentoDAO extends DAO<Orcamento, OrcamentoPK>{

	public List<Orcamento> listaPorNegociacao(Negociacao n);
	
	public List<Orcamento> listaPorUsuario(Usuario u);
	
	public List<Orcamento> listaPorProfissional(Profissional p);
	
}
