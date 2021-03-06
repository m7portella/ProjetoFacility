package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.StatusAmigo;
import br.com.facility.enums.TipoAmigo;

@Entity
@Table(name="F_USUARIO_USUARIO")
@IdClass(AmigoPK.class)
public class Amigo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4388084866727932768L;

	@Id
	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	@Id
	@ManyToOne //(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_amigo")
	private Usuario amigo;
	
	@Column(name="cd_tipo", nullable=false)
	private TipoAmigo tipo;
	
	@Column(name="cd_favorito", nullable=false)
	private boolean favorito;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_adicionado", nullable=false)
	private Calendar dataAdicionado;
	
	@Column(name="cd_status", nullable=false)
	private StatusAmigo status;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_status", nullable=false)
	private Calendar dataStatus;

	public Amigo(Usuario usuario, Usuario amigo, TipoAmigo tipo,
			boolean favorito, Calendar dataAdicionado, StatusAmigo status,
			Calendar dataStatus) {
		super();
		this.usuario = usuario;
		this.amigo = amigo;
		this.tipo = tipo;
		this.favorito = favorito;
		this.dataAdicionado = dataAdicionado;
		this.status = status;
		this.dataStatus = dataStatus;
	}

	public Amigo() {
		super();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getAmigo() {
		return amigo;
	}

	public void setAmigo(Usuario amigo) {
		this.amigo = amigo;
	}

	public TipoAmigo getTipo() {
		return tipo;
	}

	public void setTipo(TipoAmigo tipo) {
		this.tipo = tipo;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public Calendar getDataAdicionado() {
		return dataAdicionado;
	}

	public void setDataAdicionado(Calendar dataAdicionado) {
		this.dataAdicionado = dataAdicionado;
	}

	public StatusAmigo getStatus() {
		return status;
	}

	public void setStatus(StatusAmigo status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}
			
}
