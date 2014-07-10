package br.com.facility.to;

import java.io.Serializable;

public class AmigoPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8333019208838543105L;
	private Integer usuario;
	private Integer amigo;

	public int hashCode() {
		// junta o hashCode dos atributos chave
		return usuario.hashCode() + amigo.hashCode();
	}

	public boolean equals(Object o) {
		AmigoPK myId = (AmigoPK) o;

		if ((o instanceof AmigoPK) 
				// iguala todos os atributos que compõe a chave
				&& (usuario == myId.getUsuario())
				&& (amigo == myId.getAmigo())){
			return true;
		}
		return false;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public Integer getAmigo() {
		return amigo;
	}

	public void setAmigo(Integer amigo) {
		this.amigo = amigo;
	}

	public AmigoPK() {
		super();
	}

	public AmigoPK(Integer usuario, Integer amigo) {
		super();
		this.usuario = usuario;
		this.amigo = amigo;
	}

}
