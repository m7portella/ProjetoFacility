package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.facility.enums.TipoLogradouro;

@Entity
@Table(name="F_CEP_ENDERECO")
@SequenceGenerator(name="sq_cep", sequenceName="SQ_F_CEP", allocationSize=1)
public class Cep implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -13408058961025062L;

	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_cep")
	private int id;
	
	@Column(name="nr_cep", nullable=false, length=10)
	private String numero;
	
	@Column(name="cd_tipo_logradouro", nullable=false)
	private TipoLogradouro tipoLogragouro;
	
	@Column(name="ds_logradouro", nullable=false, length=30)
	private String logradouro;
	
	@Column(name="ds_bairro", nullable=false, length=40)
	private String bairro;
	
	@Column(name="ds_cidade", nullable=false, length=40)
	private String cidade;
	
	@Column(name="ds_estado", nullable=false, length=40)
	private String estado;
	
	@Column(name="ds_pais", nullable=false, length=40)
	private String pais;

	public Cep() {
		super();
	}

	public Cep(int id, String numero, TipoLogradouro tipoLogragouro,
			String bairro, String cidade, String estado, String pais) {
		super();
		this.id = id;
		this.numero = numero;
		this.tipoLogragouro = tipoLogragouro;
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

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public TipoLogradouro getTipoLogragouro() {
		return tipoLogragouro;
	}

	public void setTipoLogragouro(TipoLogradouro tipoLogragouro) {
		this.tipoLogragouro = tipoLogragouro;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	
	
}
