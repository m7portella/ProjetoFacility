
package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.HierarquiaResponsavel;
import br.com.facility.enums.StatusResponsavel;


@Entity
@Table(name = "F_RESPONSAVEL")
@IdClass(ResponsavelPK.class)

public class Responsavel implements Serializable{


	private static final long serialVersionUID = -6560711276817153308L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "sq_responsavel", 
	sequenceName = "SQ_F_RESPONSAVEL")
	@GeneratedValue(generator="sq_responsavel", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_responsavel")
	private int id;
	
	@Id
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="cd_cliente_juridico", nullable=false)
	private ClienteJuridico clienteJuridico;
	
	@Column(name="ds_nome", nullable=false, length=20)
	private String nome;
	
	@Column(name="ds_sobrenome", nullable=false, length=30)
	private String sobrenome;
	
	@Column(name="ds_cpf", nullable=false, length=11)
	private String cpf;
	
	@Column(name="ds_email", nullable=false, length=30)
	private String email;
	
	@Column(name="dt_cadastro", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="cd_status", nullable=false, length=1)
	private StatusResponsavel status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;
	
	@Column(name="cd_hierarquia", length=2)
	private HierarquiaResponsavel hierarquia;

	public Responsavel() {
		super();
		
	}

	public Responsavel(ClienteJuridico clienteJuridico, String nome,
			String sobrenome, String cpf, String email, Calendar dataCadastro,
			StatusResponsavel status, Calendar dataStatus,
			HierarquiaResponsavel hierarquia) {
		super();
		this.clienteJuridico = clienteJuridico;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.status = status;
		this.dataStatus = dataStatus;
		this.hierarquia = hierarquia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClienteJuridico getClienteJuridico() {
		return clienteJuridico;
	}

	public void setClienteJuridico(ClienteJuridico clienteJuridico) {
		this.clienteJuridico = clienteJuridico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public StatusResponsavel getStatus() {
		return status;
	}

	public void setStatus(StatusResponsavel status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}

	public HierarquiaResponsavel getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(HierarquiaResponsavel hierarquia) {
		this.hierarquia = hierarquia;
	}
	
}
