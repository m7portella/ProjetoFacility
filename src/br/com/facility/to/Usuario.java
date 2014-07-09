package br.com.facility.to;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.TipoUsuario;

@Entity
@Table(name="F_USUARIO")
@SequenceGenerator(allocationSize=1,name="sq_usuario",sequenceName="SQ_F_USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(generator="sq_usuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private int id;
	
	@Column(name="ds_username", nullable=false, length=30)
	private String username;
	
	@Column(name="ds_senha", nullable=false, length=20)
	private String senha;
	
	@Column(name="ds_email", nullable=false, length=40)
	private String email;
	
	@Column(name="cd_tipo", nullable=false, length=1)
	private TipoUsuario tipo;
	
	@Column(name="dt_cadastro", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataCadastro;
	
	@Column(name="cd_token_api", length=30)
	private String tokenApi;
	
	@Column(name="cd_status", nullable=false, length=1)
	private StatusUsuario status;
	
	@Column(name="dt_status", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataStatus;

	public Usuario() {
		super();
	}

	public Usuario(int id, String username, String senha, String email,
			TipoUsuario tipo, Calendar dataCadastro, String tokenApi,
			StatusUsuario status, Calendar dataStatus) {
		super();
		this.id = id;
		this.username = username;
		this.senha = senha;
		this.email = email;
		this.tipo = tipo;
		this.dataCadastro = dataCadastro;
		this.tokenApi = tokenApi;
		this.status = status;
		this.dataStatus = dataStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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

	public String getTokenApi() {
		return tokenApi;
	}

	public void setTokenApi(String tokenApi) {
		this.tokenApi = tokenApi;
	}

	public StatusUsuario getStatus() {
		return status;
	}

	public void setStatus(StatusUsuario status) {
		this.status = status;
	}

	public Calendar getDataStatus() {
		return dataStatus;
	}

	public void setDataStatus(Calendar dataStatus) {
		this.dataStatus = dataStatus;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}
	
}
