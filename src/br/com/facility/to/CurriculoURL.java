/**
 * 
 */
package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Andersson
 * 
 * Data:15/07/2014
 *
 */
@Entity
@Table(name="F_CURRICULO_URL")
@SequenceGenerator(allocationSize = 1,
name = "sq_curriculo_url", sequenceName = "SQ_F_CURRICULO_URL")
public class CurriculoURL implements Serializable {

	private static final long serialVersionUID = -6018684382858649843L;

	@Id
	@GeneratedValue(generator="sq_curriculo_url", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_url")
	private int id;
	
	/*
	@Id
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_curriculo", nullable=false)
	private Curriculo curriculo;
	*/
	
	@Column(name="ds_url", length=200)
	private String url;
	
	@Column(name="ds_tipo", length=250)
	private String tipo;

	public CurriculoURL() {
		super();
	
	}

	public CurriculoURL(int id, String url, String tipo) {
		super();
		this.id = id;
		this.url = url;
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
