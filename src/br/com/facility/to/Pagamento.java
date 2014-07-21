package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.StatusPagamento;
import br.com.facility.enums.TipoPagamento;

@Entity
@Table(name="F_PAGAMENTO")
@SequenceGenerator(allocationSize=1,name="sq_pagamento",sequenceName="SQ_F_PAGAMENTO")
public class Pagamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1409232992245083910L;

	@Id
	@GeneratedValue(generator="sq_pagamento", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_pagamento")
	private int id;
	
	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_protocolo", nullable=false)
	private Negociacao negociacao;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="cd_profissional", nullable=false)
	private Profissional profissional;

	@Column(name="cd_tipo", nullable=false)
	private TipoPagamento tipo;
	
	@Column(name="ds_meio_pagamento", nullable=false, length=100)
	private String meioPagamento;
	
	@Column(name="cd_processamento", nullable=false)
	private int codigoProcessamento;
	
	@Column(name="vl_total", nullable=false)
	private double valorTotal;
	
	@Column(name="dt_pagamento", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="cd_status", nullable=false)
	private StatusPagamento status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;

	public Pagamento(int id, Negociacao negociacao, Usuario usuario,
			Profissional profissional, TipoPagamento tipo,
			String meioPagamento, int codigoProcessamento, double valorTotal,
			Calendar data, StatusPagamento status, Calendar dataStatus) {
		super();
		this.id = id;
		this.negociacao = negociacao;
		this.usuario = usuario;
		this.profissional = profissional;
		this.tipo = tipo;
		this.meioPagamento = meioPagamento;
		this.codigoProcessamento = codigoProcessamento;
		this.valorTotal = valorTotal;
		this.data = data;
		this.status = status;
		this.dataStatus = dataStatus;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Pagamento() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}

	public TipoPagamento getTipo() {
		return tipo;
	}

	public void setTipo(TipoPagamento tipo) {
		this.tipo = tipo;
	}

	public String getMeioPagamento() {
		return meioPagamento;
	}

	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}

	public int getCodigoProcessamento() {
		return codigoProcessamento;
	}

	public void setCodigoProcessamento(int codigoProcessamento) {
		this.codigoProcessamento = codigoProcessamento;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public StatusPagamento getStatus() {
		return status;
	}

	public void setStatus(StatusPagamento status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}
	
}
