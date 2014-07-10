package br.com.facility.to;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.facility.enums.StatusUsuario;
import br.com.facility.enums.TipoPessoa;
import br.com.facility.enums.TipoUsuario;

@Entity
@Table(name = "F_CLIENTE_JURIDICO")
public class ClienteJuridico extends Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4911435223614053417L;

	@Column(name = "ds_razao_social", nullable = false, length = 40)
	private String razaoSocial;

	@Column(name = "ds_nome_fantasia", nullable = false, length = 50)
	private String nomeFantasia;

	@Column(name = "ds_cnpj", nullable = false, length = 20)
	private String cnpj;

	public ClienteJuridico() {
		super();
	}

	public ClienteJuridico(int id, String username, String senha, String email,
			TipoUsuario tipo, TipoPessoa tipoPessoa, Calendar dataCadastro,
			String tokenApi, StatusUsuario status, Calendar dataStatus) {
		super(id, username, senha, email, tipo, tipoPessoa, dataCadastro,
				tokenApi, status, dataStatus);
	}

	public ClienteJuridico(String razaoSocial, String nomeFantasia, String cnpj) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public ClienteJuridico(int id, String username, String senha, String email,
			TipoUsuario tipo, TipoPessoa tipoPessoa, Calendar dataCadastro,
			String tokenApi, StatusUsuario status, Calendar dataStatus,
			String razaoSocial, String nomeFantasia, String cnpj) {
		super(id, username, senha, email, tipo, tipoPessoa, dataCadastro,
				tokenApi, status, dataStatus);
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

}
