package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="F_QUALIF_ATV")
@SequenceGenerator(allocationSize=1,name="sq_qualif_atv",sequenceName="SQ_F_QUALIF_ATV")
public class QualificacaoAtividade implements Serializable {

	private static final long serialVersionUID = 3371497175558341398L;

	@Id
	@GeneratedValue(generator="sq_qualif_atv", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_qualif_atv")
	private int id;
	
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="cd_servicoConcluido", nullable=false)
//	private ServicoConcluido servicoConcluido;
	
//	@Id
//	@OneToOne //(cascade=CascadeType.PERSIST)
//	@JoinColumn(name="cd_atividadeNegociada", nullable=false)
//	private NegociacaoAtividade atividadeNegociada;
	
	@Column(name="nr_estrelas" , nullable=false)
	private int estrelas;
	
	@Column(name="dt_qualificacao" , nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataQuaificacao;
	
	@Column(name="ds_comentario")
	private String comentarios;
	
	@Column(name="ds_positivo")
	private String positivo;
	
	@Column(name="ds_negativo")
	private String negativo;

	public QualificacaoAtividade() {
		super();
		
	}

	public QualificacaoAtividade(ServicoConcluido servicoConcluido,
			NegociacaoAtividade atividadeNegociada, int estrelas,
			Calendar dataQuaificacao, String comentarios, String positivo,
			String negativo) {
		super();
//		this.servicoConcluido = servicoConcluido;
//		this.atividadeNegociada = atividadeNegociada;
		this.estrelas = estrelas;
		this.dataQuaificacao = dataQuaificacao;
		this.comentarios = comentarios;
		this.positivo = positivo;
		this.negativo = negativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	public ServicoConcluido getServicoConcluido() {
		return servicoConcluido;
	}

	public void setServicoConcluido(ServicoConcluido servicoConcluido) {
		this.servicoConcluido = servicoConcluido;
	}

	public NegociacaoAtividade getAtividadeNegociada() {
		return atividadeNegociada;
	}

	public void setAtividadeNegociada(NegociacaoAtividade atividadeNegociada) {
		this.atividadeNegociada = atividadeNegociada;
	}
	
	*/
	
	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public Calendar getDataQuaificacao() {
		return dataQuaificacao;
	}

	public void setDataQuaificacao(Calendar dataQuaificacao) {
		this.dataQuaificacao = dataQuaificacao;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getPositivo() {
		return positivo;
	}

	public void setPositivo(String positivo) {
		this.positivo = positivo;
	}

	public String getNegativo() {
		return negativo;
	}

	public void setNegativo(String negativo) {
		this.negativo = negativo;
	}

}
