package br.com.facility.dao;

import java.util.List;
import br.com.facility.to.Mensagem;
import br.com.facility.to.MensagemPK;
import br.com.facility.to.Negociacao;

public interface MensagemDAO extends DAO<Mensagem, MensagemPK>{

	public List<Mensagem> listaPorNegociacao(Negociacao n);
	
}
