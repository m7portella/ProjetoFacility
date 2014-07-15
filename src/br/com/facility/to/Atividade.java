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
	
	@Column(name="ds_atividade", length=60, nullable=false)
	private String nome;
	
	@Column(name="ds_categoria", length=2, nullable=false)
	private int categoria;
	
	public Atividade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Atividade(int id, String nome, int categoria) {
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

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
}
