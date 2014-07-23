package br.com.facility.to;

import java.io.Serializable;

public class OrcamentoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1685070688287580094L;
	private Integer codigo;
	private Long negociacao;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + negociacao.hashCode();
	}

	public boolean equals(Object o) {
		OrcamentoPK myId = (OrcamentoPK) o;

		if ((o instanceof OrcamentoPK) 
				// iguala todos os atributos que compõe a chave
				&& (codigo == myId.getCodigo())
				&& (negociacao == myId.getNegociacao())){
			return true;
		}
		return false;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Long getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Long negociacao) {
		this.negociacao = negociacao;
	}
	
}
