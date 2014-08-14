package br.com.facility.to;

import java.io.Serializable;


public class OrcamentoAtividadePK implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4044625528636486394L;
	private OrcamentoPK orcamento;
	protected Long negociacaoAtividade;
	
	public int hashCode(){
		return getOrcamento().hashCode() + negociacaoAtividade.hashCode();
	}
	
	
	public Long getNegociacaoAtividade() {
		return negociacaoAtividade;
	}

	public void setNegociacaoAtividade(Long negociacaoAtividade) {
		this.negociacaoAtividade = negociacaoAtividade;
	}


	public OrcamentoPK getOrcamento() {
		return orcamento;
	}


	public void setOrcamento(OrcamentoPK orcamento) {
		this.orcamento = orcamento;
	}



	
}
