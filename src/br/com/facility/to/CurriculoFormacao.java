/**
 * 
 */
package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="F_CURRICULO_FORMAC")
@SequenceGenerator(allocationSize = 1,
name = "sq_curriculo_formacao", sequenceName = "SQ_F_CURRICULO_FORMACAO")
public class CurriculoFormacao implements Serializable{

	private static final long serialVersionUID = 4765942086081516703L;

	@Id
	@GeneratedValue(generator="sq_curriculo_formacao", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_formacao")
	private int id;
	
	/*
	@Id
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_curriculo", nullable=false)
	private Curriculo curriculo;
	*/
	
	@Column(name="ds_curso", nullable=false, length=200)
	private String curso;
	
	@Column(name="ds_instituicao", length=50)
	private String instituicao;
	
	@Column(name="dt_conclusao")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataConclusao;

	public CurriculoFormacao() {
		super();
		
	}

	public CurriculoFormacao( String curso, String instituicao,
			Calendar dataConclusao) {
		super();
		this.curso = curso;
		this.instituicao = instituicao;
		this.dataConclusao = dataConclusao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}
	
}
