package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.TipoQualificacao;


@Entity
@Table(name="F_QUALIFICACAO")
@SequenceGenerator(allocationSize=1,name="sq_qualificacao",sequenceName="SQ_F_QUALIFICACAO")
public class Qualificacao implements Serializable{

	private static final long serialVersionUID = 2587858394861824746L;

	@Id
	@GeneratedValue(generator="sq_qualificacao", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_qualificacao")
	private long id;
	
//	@Id
//	@OneToMany (cascade=CascadeType.ALL)
//	@JoinColumn(name="cd_servicoConcluido", nullable=false)
//	private Set<ServicoConcluido> servicoConcluido;
	
	@Column(name="cd_tipo" , nullable=false)
	private TipoQualificacao tipo;
	
	@Column(name="nr_estrelas" , nullable=false)
	private int estrelas;
	
	@Column(name="dt_qualificacao" , nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataQualificacao;
	
	@Column(name="ds_qualificacao")
	private String descricao;
	
	public Qualificacao() {
		super();
	}

	public Qualificacao(Set<ServicoConcluido> servicoConcluido,
			TipoQualificacao tipo, int estrelas, Calendar dataQualificacao,
			String descricao) {
		super();
//		this.servicoConcluido = servicoConcluido;
		this.tipo = tipo;
		this.estrelas = estrelas;
		this.dataQualificacao = dataQualificacao;
		this.descricao = descricao;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public Set<ServicoConcluido> getServicoConcluido() {
//		return servicoConcluido;
//	}
//
//	public void setServicoConcluido(Set<ServicoConcluido> servicoConcluido) {
//		this.servicoConcluido = servicoConcluido;
//	}

	public TipoQualificacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoQualificacao tipo) {
		this.tipo = tipo;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public Calendar getDataQualificacao() {
		return dataQualificacao;
	}

	public void setDataQualificacao(Calendar dataQualificacao) {
		this.dataQualificacao = dataQualificacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
