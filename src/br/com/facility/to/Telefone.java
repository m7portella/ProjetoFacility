package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

import br.com.facility.enums.TipoTelefone;

@Entity
@Table(name="F_TELEFONE")
@IdClass(TelefonePK.class)
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2494676370352595829L;

	@Id
	@Column(name="cd_telefone")
	@SequenceGenerator(name="sq_telefone", sequenceName="SQ_F_TELEFONE", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_telefone")
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_usuario")
	private Usuario usuario;
	
	@Column(name="cd_tipo", length=1, nullable=false)
	private TipoTelefone tipo;
	
	@Column(name="cd_pais", length=3, nullable=false)
	private int codigoPais;
	
	@Column(name="nr_ddd", length=2, nullable=false)
	private int ddd;
	
	@Column(name="nr_telefone", length=10, nullable=false)
	private int numero;
	
	@Column(name="ds_ramal", length=5)
	private String ramal;
	
	@Column(name="ds_operadora", length=15)
	private String operadora;
	
	public Telefone(){
		
	}

	public Telefone(Usuario usuario, TipoTelefone tipo, int codigoPais,
			int ddd, int numero, String ramal, String operadora) {
		super();
		this.usuario = usuario;
		this.tipo = tipo;
		this.codigoPais = codigoPais;
		this.ddd = ddd;
		this.numero = numero;
		this.ramal = ramal;
		this.operadora = operadora;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public TipoTelefone getTipo() {
		return tipo;
	}

	public void setTipo(TipoTelefone tipo) {
		this.tipo = tipo;
	}

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}
	
	
}
