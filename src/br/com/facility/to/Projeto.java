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

import br.com.facility.enums.StatusProjeto;

@Entity
@Table(name="F_PROJETO")
@SequenceGenerator(allocationSize=1,name="sq_projeto",sequenceName="SQ_F_PROJETO")
public class Projeto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2916462180126193876L;

	@Id
	@GeneratedValue(generator="sq_projeto", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_projeto")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name="nm_titulo", nullable=false, length=80)
	private String titulo;
	
	@Column(name="ds_projeto", length=255)
	private String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_abertura", nullable=false)
	private Calendar dataAbertura;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_limite")
	private Calendar dataLimite;
	
	@Column(name="cd_status", nullable=false)
	private StatusProjeto status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_status", nullable=false)
	private Calendar dataStatus;
	
	public Projeto(long id, Usuario usuario, String titulo, String descricao,
			Calendar dataAbertura, Calendar dataLimite, StatusProjeto status,
			Calendar dataStatus) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataAbertura = dataAbertura;
		this.dataLimite = dataLimite;
		this.status = status;
		this.dataStatus = dataStatus;
	}

	public Projeto() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Calendar dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public Calendar getDataLimite() {
		return dataLimite;
	}

	public void setDataLimite(Calendar dataLimite) {
		this.dataLimite = dataLimite;
	}

	public StatusProjeto getStatus() {
		return status;
	}

	public void setStatus(StatusProjeto status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}
	
}
