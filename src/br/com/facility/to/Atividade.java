package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_ATIVIDADE")
@SequenceGenerator(name="seqAtividade", schema="SEQ_ATIVIDADE", allocationSize=1)
public class Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seqAtividade", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_atividade")
	private int id;
	
	@Column(name="ds_atividade")
	private String nome;
	
	@Column(name="ds_categoria")
	private String categoria;
	
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atividade(int id, String nome, String categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
