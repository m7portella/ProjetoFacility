package br.com.facility.to;

import java.io.Serializable;

public class QualificacaoAtividadePK implements Serializable{

	private static final long serialVersionUID = 1747983627186070346L;

	private Long codigo;
	private Long servicoConcluido;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return getCodigo().hashCode() + getServicoConcluido().hashCode();
	}

	public boolean equals(Object o) {
		QualificacaoAtividadePK myId = (QualificacaoAtividadePK) o;

		if ((o instanceof QualificacaoAtividadePK) 
				// iguala todos os atributos que compõe a chave
				&& (getCodigo() == myId.getCodigo())
				&& (getServicoConcluido() == myId.getServicoConcluido())){
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

	public Long getServicoConcluido() {
		return servicoConcluido;
	}

	public void setServicoConcluido(Long servicoConcluido) {
		this.servicoConcluido = servicoConcluido;
	}
	
}
