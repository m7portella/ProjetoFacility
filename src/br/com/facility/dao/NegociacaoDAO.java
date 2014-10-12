package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public interface NegociacaoDAO extends DAO<Negociacao, Long>{

	public List<Negociacao> listaPorUsuario(Usuario u);
	
	public List<Negociacao> listaPorProfissional(Profissional p);
	
}
