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


@Entity
@Table(name="F_CURRICULO_IMAGEM")
@SequenceGenerator(allocationSize = 1,
name = "sq_curriculo_imagem", sequenceName = "SQ_F_CURRICULO_IMAGEM")
public class CurriculoImagem implements Serializable{

	private static final long serialVersionUID = 7308599246034548534L;

	@Id
	@GeneratedValue(generator="sq_curriculo_imagem", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_imagem")
	private int id;
	
	/*
	@Id
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_curriculo", nullable=false)
	private Curriculo curriculo;
	*/
	
	@Column(name="ds_url", length=200)
	private String url;
	
	@Column(name="ds_imagem", length=200)
	private String descricao;

	public CurriculoImagem() {
		super();
		
	}

	public CurriculoImagem(String url, String descricao) {
		super();
		this.url = url;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
