package br.com.facility.to;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="F_USUARIO")
@SequenceGenerator(allocationSize=1,name="sq_usuario",sequenceName="SQ_F_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(generator="sq_usuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private int id;
	
	@Column(name="ds_username", nullable=false)
	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
