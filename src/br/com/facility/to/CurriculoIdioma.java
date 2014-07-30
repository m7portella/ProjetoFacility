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

import br.com.facility.enums.NivelIdioma;


@Entity
@Table(name="F_CURRICULO_IDIOMA")
@SequenceGenerator(allocationSize = 1,
name = "sq_curriculo_idioma", sequenceName = "SQ_F_CURRICULO_IDIOMA")
public class CurriculoIdioma implements Serializable {

	private static final long serialVersionUID = 9024184163083414392L;

	@Id
	@GeneratedValue(generator="sq_curriculo_idioma", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_idioma")
	private int id;
	
	/*
	@Id
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_curriculo", nullable=false)
	private Curriculo curriculo;
	*/
	
	@Column(name="ds_idioma", length=60)
	private String idioma;
	
	@Column(name="cd_nivel", length=1)
	private NivelIdioma nivel;

	public CurriculoIdioma() {
		super();
		
	}

	public CurriculoIdioma(String idioma, NivelIdioma nivel) {
		super();
		this.idioma = idioma;
		this.nivel = nivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public NivelIdioma getNivel() {
		return nivel;
	}

	public void setNivel(NivelIdioma nivel) {
		this.nivel = nivel;
	}
	
}
