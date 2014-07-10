package br.com.facility.to;

import java.io.Serializable;


public class TelefonePK implements Serializable{

	private Integer codigo;
	private Integer usuario;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	
	
	
}
