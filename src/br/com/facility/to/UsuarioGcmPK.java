package br.com.facility.to;

import java.io.Serializable;

public class UsuarioGcmPK implements Serializable{

	private Integer usuario;
	private String registrationId;
	
	public int hashCode() {
		// junta o hashCode dos atributos chave
		return usuario.hashCode() + registrationId.hashCode();
	}

	public boolean equals(Object o) {
		UsuarioGcmPK myId = (UsuarioGcmPK) o;

		if ((o instanceof UsuarioGcmPK) 
				// iguala todos os atributos que compõe a chave
				&& (usuario == myId.getUsuario())
				&& (registrationId.equals(myId.getRegistrationId()))){
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

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

}
