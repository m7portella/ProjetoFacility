package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.facility.enums.StatusProfissional;
import br.com.facility.enums.StatusValidacao;
import br.com.facility.enums.TipoPessoa;

@Entity
@Table(name="F_PROFISSIONAL")
@SequenceGenerator(allocationSize=1,name="sq_profissional",sequenceName="SQ_F_PROFISSIONAL")
public class Profissional implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7592017709913800349L;

	@Id
	@GeneratedValue(generator="sq_profissional", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_profissional")
	private int id;
	
	@Column(name="cd_tipo", nullable=false, length=1)
	private TipoPessoa tipo;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_cliente_fisico")
	private ClienteFisico clienteFisico;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_cliente_juridico")
	private ClienteJuridico clienteJuridico;
	
	@Column(name="st_validacao", nullable=false, length=1)
	private StatusValidacao statusValidacao;
	
	@Column(name="cd_validacao", length=10)
	private String codigoValidacao;
	
	@Column(name="dt_cadastro", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="nr_rank", nullable=false, length=6)
	private int rank;
	
	@Column(name="cd_status", nullable=false, length=1)
	private StatusProfissional status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;
	
	@Column(name="st_localizacao", nullable=false)
	private boolean localizavel;
	
	@Column(name="nr_altitude", length=10)
	private int altitude;
	
	@Column(name="nr_longitude", length=10)
	private int longitude;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="F_PROFISSIONAL_LOCAL_ATEND", // TODO verificar ordem das colunas
    		joinColumns={@JoinColumn(name="cd_profissional")},
    		inverseJoinColumns={@JoinColumn(name="cd_local_atendimento")})
	private List<LocalAtendimento> locaisAtendimento;
	
	public Profissional(int id, TipoPessoa tipo, ClienteFisico clienteFisico,
			ClienteJuridico clienteJuridico, StatusValidacao statusValidacao,
			String codigoValidacao, Calendar dataCadastro, int rank,
			StatusProfissional status, Calendar dataStatus,
			boolean localizavel, int altitude, int longitude,
			List<LocalAtendimento> locaisAtendimento) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.clienteFisico = clienteFisico;
		this.clienteJuridico = clienteJuridico;
		this.statusValidacao = statusValidacao;
		this.codigoValidacao = codigoValidacao;
		this.dataCadastro = dataCadastro;
		this.rank = rank;
		this.status = status;
		this.dataStatus = dataStatus;
		this.localizavel = localizavel;
		this.altitude = altitude;
		this.longitude = longitude;
		this.locaisAtendimento = locaisAtendimento;
	}

	public Profissional() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public ClienteFisico getClienteFisico() {
		return clienteFisico;
	}

	public void setClienteFisico(ClienteFisico clienteFisico) {
		this.clienteFisico = clienteFisico;
	}

	public ClienteJuridico getClienteJuridico() {
		return clienteJuridico;
	}

	public void setClienteJuridico(ClienteJuridico clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}

	public StatusValidacao getStatusValidacao() {
		return statusValidacao;
	}

	public void setStatusValidacao(StatusValidacao statusValidacao) {
		this.statusValidacao = statusValidacao;
	}

	public String getCodigoValidacao() {
		return codigoValidacao;
	}

	public void setCodigoValidacao(String codigoValidacao) {
		this.codigoValidacao = codigoValidacao;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public StatusProfissional getStatus() {
		return status;
	}

	public void setStatus(StatusProfissional status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}

	public boolean isLocalizavel() {
		return localizavel;
	}

	public void setLocalizavel(boolean localizavel) {
		this.localizavel = localizavel;
	}

	public int getAltitude() {
		return altitude;
	}

	public void setAltitude(int altitude) {
		this.altitude = altitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public List<LocalAtendimento> getLocaisAtendimento() {
		return locaisAtendimento;
	}

	public void setLocaisAtendimento(List<LocalAtendimento> locaisAtendimento) {
		this.locaisAtendimento = locaisAtendimento;
	}
	
}
