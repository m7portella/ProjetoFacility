package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.Agenda;
import br.com.facility.to.AgendaPK;
import br.com.facility.to.Negociacao;
import br.com.facility.to.Profissional;
import br.com.facility.to.Usuario;

public interface AgendaDAO extends DAO<Agenda, AgendaPK>{

	public List<Agenda> listaPorNegociacao(Negociacao n);
	
	public List<Agenda> listaPorUsuario(Usuario u);
	
	public List<Agenda> listaPorProfissional(Profissional p);
	
}
