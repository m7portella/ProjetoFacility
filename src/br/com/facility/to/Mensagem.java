package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="F_MENSAGEM")
@IdClass(MensagemPK.class)
public class Mensagem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3126185605830001355L;

	@Id
	@SequenceGenerator(allocationSize=1,name="sq_mensagem",sequenceName="SQ_F_MENSAGEM")
	@GeneratedValue(generator="sq_mensagem", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_mensagem")
	private long codigo;
	
	@Id
	//@ManyToOne //(cascade=CascadeType.PERSIST)
	//@JoinColumn(name="nr_protocolo", nullable=false)
	@Column(name="nr_protocolo", nullable=false)
	private long protocolo;
	
	@Column(name="cd_remetente", nullable=false)
	private int remetente;
	
	@Column(name="cd_destinatario", nullable=false)
	private int destinatario;

	public Mensagem(long codigo, long protocolo, int remetente,
			int destinatario, String texto, Calendar dataEnvio) {
		super();
		this.codigo = codigo;
		this.protocolo = protocolo;
		this.setRemetente(remetente);
		this.setDestinatario(destinatario);
		this.texto = texto;
		this.dataEnvio = dataEnvio;
	}

	@Column(name="ds_email", nullable=false, length=500)
	private String texto;
	
	@Column(name="dt_envio", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataEnvio;

	public Mensagem() {
		super();
	}

	public long getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(long protocolo) {
		this.protocolo = protocolo;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Calendar getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Calendar dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public int getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(int destinatario) {
		this.destinatario = destinatario;
	}

	public int getRemetente() {
		return remetente;
	}

	public void setRemetente(int remetente) {
		this.remetente = remetente;
	}

}
