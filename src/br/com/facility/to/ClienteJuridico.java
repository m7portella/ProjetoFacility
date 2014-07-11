package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "F_CLIENTE_JURIDICO")
public class ClienteJuridico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4911435223614053417L;
	
	@Id
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;

	@Column(name = "ds_razao_social", nullable = false, length = 40)
	private String razaoSocial;

	@Column(name = "ds_nome_fantasia", nullable = false, length = 50)
	private String nomeFantasia;

	@Column(name = "ds_cnpj", nullable = false, length = 20)
	private String cnpj;

	public ClienteJuridico(Usuario usuario, String razaoSocial,
			String nomeFantasia, String cnpj) {
		super();
		this.usuario = usuario;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public ClienteJuridico() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
