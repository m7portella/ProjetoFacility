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

import br.com.facility.enums.StatusAgenda;
import br.com.facility.enums.TipoAgenda;

@Entity
@Table(name="F_AGENDA")
@IdClass(AgendaPK.class)
public class Agenda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1967790170895226470L;

	@Id
	@SequenceGenerator(allocationSize=1,name="sq_agenda",sequenceName="SQ_F_AGENDA")
	@GeneratedValue(generator="sq_agenda", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_agenda")
	private int codigo;
	
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
	
	@Column(name="cd_tipo", nullable=false)
	private TipoAgenda tipo;
	
	@Column(name="dt_agenda", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="dt_termino")
	@Temporal(TemporalType.DATE)
	private Calendar dataTermino;
	
	@Column(name="nr_horas_previstas")
	private int horasPrevistas;
	
	@Column(name="ds_observacao", length=255)
	private String observacao;
	
	@Column(name="cd_status", nullable=false)
	private StatusAgenda status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;

	public Agenda(int codigo, Negociacao negociacao, Usuario usuario,
			Profissional profissional, TipoAgenda tipo, Calendar data,
			Calendar dataTermino, int horasPrevistas, String observacao,
			StatusAgenda status, Calendar dataStatus) {
		super();
		this.codigo = codigo;
		this.negociacao = negociacao;
		this.usuario = usuario;
		this.profissional = profissional;
		this.tipo = tipo;
		this.data = data;
		this.dataTermino = dataTermino;
		this.horasPrevistas = horasPrevistas;
		this.observacao = observacao;
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

	public Agenda() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}

	public TipoAgenda getTipo() {
		return tipo;
	}

	public void setTipo(TipoAgenda tipo) {
		this.tipo = tipo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public Calendar getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Calendar dataTermino) {
		this.dataTermino = dataTermino;
	}

	public int getHorasPrevistas() {
		return horasPrevistas;
	}

	public void setHorasPrevistas(int horasPrevistas) {
		this.horasPrevistas = horasPrevistas;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public StatusAgenda getStatus() {
		return status;
	}

	public void setStatus(StatusAgenda status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}
	
}
