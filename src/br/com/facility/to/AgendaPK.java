package br.com.facility.to;

import java.io.Serializable;

public class AgendaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -201000953913838088L;
	private Integer codigo;
	private Long negociacao;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + negociacao.hashCode();
	}

	public boolean equals(Object o) {
		AgendaPK myId = (AgendaPK) o;

		if ((o instanceof AgendaPK) 
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
