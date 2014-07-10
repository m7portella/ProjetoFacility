package br.com.facility.to;

import java.io.Serializable;

public class LocalAtendimento implements Serializable{

	private int id;
	
	private String bairro;
	
	private String cidade;
	
	private String estado;
	
	private String pais;

	public LocalAtendimento() {
		super();
	}

	public LocalAtendimento(int id, String bairro, String cidade,
			String estado, String pais) {
		super();
		this.id = id;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
