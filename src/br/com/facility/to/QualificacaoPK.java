package br.com.facility.to;

import java.io.Serializable;

public class QualificacaoPK implements Serializable{

	private Long codigo;
	private Long servicoConcluido;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + getServicoConcluido().hashCode();
	}

	public boolean equals(Object o) {
		QualificacaoPK myId = (QualificacaoPK) o;

		if ((o instanceof QualificacaoPK) 
				// iguala todos os atributos que compõe a chave
				&& (codigo == myId.getCodigo())
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
