package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.facility.enums.Sexo;

@Entity
@Table(name = "F_CLIENTE_FISICO")
public class ClienteFisico implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1616563104437479198L;

	@Id
	@Column(name="cd_cliente")
	private int id;
	
	@OneToOne
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name = "ds_nome", nullable = false, length = 20)
	private String nome;

	@Column(name = "ds_sobrenome", nullable = false, length = 30)
	private String sobrenome;

	@Column(name = "ds_cpf", nullable = false, length = 14)
	private String cpf;

	@Column(name = "cd_sexo", nullable = false)
	private Sexo sexo;

	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;

	public ClienteFisico() {
		super();
	}

	public ClienteFisico(int id, Usuario usuario, String nome,
			String sobrenome, String cpf, Sexo sexo, Calendar dataNascimento) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
