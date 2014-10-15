package br.com.facility.to;

import java.io.Serializable;

public class MensagemPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 944784461070560769L;
	private Long codigo;
	private Long protocolo;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + protocolo.hashCode();
	}

	public boolean equals(Object o) {
		MensagemPK myId = (MensagemPK) o;

		if ((o instanceof MensagemPK) 
				// iguala todos os atributos que compõe a chave
				&& (codigo == myId.getCodigo())
				&& (protocolo == myId.getProtocolo())){
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

	public Long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(Long negociacao) {
		this.protocolo = negociacao;
	}
	
}
