package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.StatusNegociacao;

@Entity
@Table(name="F_NEGOCIACAO")
@SequenceGenerator(allocationSize=1,name="sq_negociacao",sequenceName="SQ_F_NEGOCIACAO")
public class Negociacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6496230603364191111L;

	@Id
	@GeneratedValue(generator="sq_negociacao", strategy=GenerationType.SEQUENCE)
	@Column(name="nr_protocolo")
	private long protocolo;
	
	@ManyToOne
	@JoinColumn(name="cd_projeto", nullable=false)
	private Projeto projeto;
	
	@ManyToOne
	@JoinColumn(name="cd_profissional", nullable=false)
	private Profissional profissional;
	
	@ManyToOne
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_solicitacao", nullable=false)
	private Calendar dataSolicitacao;
	
	@Column(name="cd_status", nullable=false)
	private StatusNegociacao status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_status", nullable=false)
	private Calendar dataStatus;

	public Negociacao() {
		super();
	}

	public Negociacao(long protocolo, Projeto projeto,
			Profissional profissional, Usuario usuario,
			Calendar dataSolicitacao, StatusNegociacao status,
			Calendar dataStatus) {
		super();
		this.protocolo = protocolo;
		this.projeto = projeto;
		this.profissional = profissional;
		this.usuario = usuario;
		this.dataSolicitacao = dataSolicitacao;
		this.status = status;
		this.dataStatus = dataStatus;
	}

	public long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Calendar getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Calendar dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public StatusNegociacao getStatus() {
		return status;
	}

	public void setStatus(StatusNegociacao status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}

}
