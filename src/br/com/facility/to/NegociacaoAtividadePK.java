package br.com.facility.to;

import java.io.Serializable;

public class NegociacaoAtividadePK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5187653561659982393L;
	private Long codigo;
	private Long negociacao;
	
	public int hashCode(){
		return codigo.hashCode() + negociacao.hashCode();
	}
	
	public boolean equals(Object o){
		NegociacaoAtividadePK myId = (NegociacaoAtividadePK) o;
		
		if((o instanceof NegociacaoAtividadePK)
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

	public void setNegociacao(Long l) {
		this.negociacao = l;
	}
	
	
	
}
