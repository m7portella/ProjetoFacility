package br.com.facility.to;

import java.io.Serializable;

@SuppressWarnings("all")
public class ResponsavelPK implements Serializable {

	private static final long serialVersionUID = -5217852177091896970L;
	private Integer codigo;
	private Integer clienteJuridico;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return codigo.hashCode() + clienteJuridico.hashCode();
	}

	public boolean equals(Object o) {
		ResponsavelPK myId = (ResponsavelPK) o;

		if ((o instanceof ResponsavelPK)
				// iguala todos os atributos que compõe a chave
				&& (codigo == myId.getCodigo())
				&& (clienteJuridico == myId.getClienteJuridico())) {
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

	public Integer getClienteJuridico() {
		return clienteJuridico;
	}

	public void setClienteJuridico(Integer clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}

}
