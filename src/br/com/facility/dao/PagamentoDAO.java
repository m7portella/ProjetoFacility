package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Negociacao;
import br.com.facility.to.Pagamento;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public interface PagamentoDAO extends DAO<Pagamento, Integer>{

	public List<Pagamento> listaPorNegociacao(Negociacao n);
	
	public List<Pagamento> listaPorUsuario(Usuario u);
	
	public List<Pagamento> listaPorProfissional(Profissional p);
	
}
