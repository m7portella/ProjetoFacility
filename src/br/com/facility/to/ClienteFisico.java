package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.Sexo;
import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.enums.TipoUsuario;

@Entity
@Table(name = "F_CLIENTE_FISICO")
public class ClienteFisico extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6812724354444054953L;

	@Column(name = "ds_nome", nullable = false, length = 20)
	private String nome;

	@Column(name = "ds_sobrenome", nullable = false, length = 30)
	private String sobrenome;

	@Column(name = "ds_cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "cd_sexo", nullable = false)
	private Sexo sexo;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public ClienteFisico() {
		super();
	}

	public ClienteFisico(int id, String username, String senha, String email,
			TipoUsuario tipo, TipoPessoa tipoPessoa, Calendar dataCadastro,
			String tokenApi, StatusUsuario status, Calendar dataStatus) {
		super(id, username, senha, email, tipo, tipoPessoa, dataCadastro,
				tokenApi, status, dataStatus);
	}

	public ClienteFisico(String nome, String sobrenome, String cpf, Sexo sexo,
			Calendar dataNascimento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public ClienteFisico(int id, String username, String senha, String email,
			TipoUsuario tipo, TipoPessoa tipoPessoa, Calendar dataCadastro,
			String tokenApi, StatusUsuario status, Calendar dataStatus,
			String nome, String sobrenome, String cpf, Sexo sexo,
			Calendar dataNascimento) {
		super(id, username, senha, email, tipo, tipoPessoa, dataCadastro,
				tokenApi, status, dataStatus);
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
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

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
