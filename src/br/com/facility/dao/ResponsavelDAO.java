/**
 * 
 */
package br.com.facility.dao;

import java.util.List;

import br.com.facility.to.ClienteJuridico;
import br.com.facility.to.Responsavel;

/**
 * @author Andersson
 *
 * Data:15/07/2014
 *
 */
public interface ResponsavelDAO extends DAO<Responsavel, Integer> {
	
	public List<Responsavel> listarPorCliente(ClienteJuridico cj);

}
