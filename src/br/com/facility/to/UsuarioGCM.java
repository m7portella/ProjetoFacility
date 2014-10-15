package br.com.facility.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(UsuarioGcmPK.class)
@Table(name="F_USUARIO_GCM")
public class UsuarioGCM {

	@Id
	@ManyToOne
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Id
	@Column(name="cd_registration_id", nullable=false)
	private String registrationId;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	public UsuarioGCM(Usuario usuario, String registrationId) {
		super();
		this.usuario = usuario;
		this.registrationId = registrationId;
	}

	public UsuarioGCM() {
		super();
	}
	
}
