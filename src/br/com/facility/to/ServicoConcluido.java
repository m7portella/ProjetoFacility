package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.StatusConclusao;

@Entity
@Table(name="F_SERVICO_CONCLUIDO")
@IdClass(ServicoConcluidoPK.class)
public class ServicoConcluido implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3487626055866668160L;

	@Id
	@SequenceGenerator(allocationSize=1,name="sq_servico_concluido",sequenceName="SQ_F_SERVICO_CONCLUIDO")
	@GeneratedValue(generator="sq_servico_concluido", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_concluido")
	private long codigo;
	
	@Id
	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_protocolo", nullable=false)
	private Negociacao negociacao;
	
	@Column(name="dt_conclusao", nullable=false)
	@Temporal(TemporalType.DATE)
	private Calendar dataConclusao;
	
	@Column(name="cd_status", nullable=false)
	private StatusConclusao status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;
	
	@Column(name="ds_comentario", length=255)
	private String comentario;

	public ServicoConcluido() {
		super();
	}

	public ServicoConcluido(long codigo, Negociacao negociacao,
			Calendar dataConclusao, StatusConclusao status,
			Calendar dataStatus, String comentario) {
		super();
		this.codigo = codigo;
		this.negociacao = negociacao;
		this.dataConclusao = dataConclusao;
		this.status = status;
		this.dataStatus = dataStatus;
		this.comentario = comentario;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}

	public Calendar getDataConclusao() {
		return dataConclusao;
	}

	public void setDataConclusao(Calendar dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	public StatusConclusao getStatus() {
		return status;
	}

	public void setStatus(StatusConclusao status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
}
