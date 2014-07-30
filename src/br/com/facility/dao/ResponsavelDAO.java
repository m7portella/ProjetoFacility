/**
 * 
 */
package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;
import br.com.facility.to.ResponsavelPK;

public interface ResponsavelDAO extends DAO<Responsavel, ResponsavelPK> {
	
	public Responsavel consultaPorClienteJuridico(ClienteJuridico cj);
	
	public List<Responsavel> listarPorCliente(ClienteJuridico cj);

	
}
