package br.com.facility.to;

import java.io.Serializable;

public class ServicoConcluidoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1336700045594798241L;
	private Long codigo;
	private Long negociacao;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + negociacao.hashCode();
	}

	public boolean equals(Object o) {
		ServicoConcluidoPK myId = (ServicoConcluidoPK) o;

		if ((o instanceof ServicoConcluidoPK) 
				// iguala todos os atributos que compõe a chave
				&& (codigo == myId.getCodigo())
				&& (negociacao == myId.getNegociacao())){
			return true;
		}
		return false;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Long getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Long negociacao) {
		this.negociacao = negociacao;
	}
	
}
