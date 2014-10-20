package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "F_CLIENTE_JURIDICO")
public class ClienteJuridico implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8296495229515207788L;

	@Id
	@Column(name="cd_cliente")
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name = "ds_razao_social", nullable = false, length = 40)
	private String razaoSocial;

	@Column(name = "ds_nome_fantasia", nullable = false, length = 50)
	private String nomeFantasia;

	@Column(name = "ds_cnpj", nullable = false, length = 20)
	private String cnpj;

	public ClienteJuridico(int id, Usuario usuario, String razaoSocial,
			String nomeFantasia, String cnpj) {
		super();
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
