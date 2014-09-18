package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import br.com.facility.enums.StatusOrcamento;
import br.com.facility.enums.TipoPreco;

@Entity
@Table(name="F_ORCAMENTO")
@IdClass(OrcamentoPK.class)
public class Orcamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7397515245191863284L;

	@Id
	@SequenceGenerator(allocationSize=1,name="sq_orcamento",sequenceName="SQ_F_ORCAMENTO")
	@GeneratedValue(generator="sq_orcamento", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_orcamento")
	private long codigo;
	
	@Id
	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="nr_protocolo", nullable=false)
	private Negociacao negociacao;
	
	@ManyToOne (fetch=FetchType.LAZY) //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@ManyToOne (fetch=FetchType.LAZY) //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_profissional", nullable=false)
	private Profissional profissional;
	
	@Column(name="cd_tipo_duracao", nullable=false)
	private TipoPreco tipoDuracao;
	
	@Column(name="nr_duracao", nullable=false)
	private int duracao;
	
	@Column(name="vl_total", nullable=false, columnDefinition = "varchar2(20)")
	private double valorTotal;
	
	@Column(name="ds_observacao")
	private String observacao;
	
	@Column(name="cd_status", nullable=false)
	private StatusOrcamento status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;

	public Orcamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orcamento(long codigo, Negociacao negociacao, Usuario usuario,
			Profissional profissional, TipoPreco tipoDuracao, int duracao,
			double valorTotal, String observacao, StatusOrcamento status,
			Calendar dataStatus) {
		super();
		this.codigo = codigo;
		this.negociacao = negociacao;
		this.usuario = usuario;
		this.profissional = profissional;
		this.tipoDuracao = tipoDuracao;
		this.duracao = duracao;
		this.valorTotal = valorTotal;
		this.observacao = observacao;
		this.status = status;
		this.dataStatus = dataStatus;
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

	public TipoPreco getTipoDuracao() {
		return tipoDuracao;
	}

	public void setTipoDuracao(TipoPreco tipoDuracao) {
		this.tipoDuracao = tipoDuracao;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusOrcamento getStatus() {
		return status;
	}

	public void setStatus(StatusOrcamento status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}
	
}
