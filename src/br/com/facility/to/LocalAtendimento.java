package br.com.facility.to;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="F_LOCAL_ATENDIMENTO")
@SequenceGenerator(allocationSize=1,name="sq_local_atendimento",sequenceName="SQ_F_LOCAL_ATENDIMENTO")
public class LocalAtendimento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3497619573265914131L;

	@Id
	@GeneratedValue(generator="sq_local_atendimento", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_local_atendimento", nullable=false, length=1)
	private int id;
	
	@ManyToMany(mappedBy="locaisAtendimento")
	private List<Profissional> profissionais = new ArrayList<Profissional>();
	
	@Column(name="ds_bairro", length=50)
	private String bairro;
	
	@Column(name="ds_cidade", nullable=false, length=40)
	private String cidade;
	
	@Column(name="ds_estado", nullable=false, length=40)
	private String estado;
	
	@Column(name="ds_pais", nullable=false, length=40)
	private String pais;

	public LocalAtendimento() {
		super();
	}

	public LocalAtendimento(int id, List<Profissional> profissionais,
			String bairro, String cidade, String estado, String pais) {
		super();
		this.id = id;
		this.setProfissionais(profissionais);
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
}
