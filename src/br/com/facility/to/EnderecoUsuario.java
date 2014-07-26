package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="F_ENDERECO_USUARIO")
@IdClass(EnderecoUsuarioPK.class)
public class EnderecoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4505111312042294804L;

	@Id
	@ManyToOne()
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	@Id
	@JoinColumn(name="cd_cep")
	@ManyToOne()
	private Cep cep;
	
	@Column(name="nr_endereco", nullable=false, length=5)
	private int numero;
	
	@Column(name="ds_complemento", length=30)
	private String complemento;

	
	public EnderecoUsuario() {
		super();
	}

	public EnderecoUsuario(Usuario usuario, Cep cep, int numero,
			String complemento) {
		super();
		this.usuario = usuario;
		this.cep = cep;
		this.numero = numero;
		this.complemento = complemento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cep getCep() {
		return cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	
}
