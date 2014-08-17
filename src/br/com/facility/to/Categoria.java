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
@Table(name="F_CATEGORIA")
@SequenceGenerator(name="sqCategoria", schema="SQ_F_CATEGORIA", initialValue=1)
public class Categoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator="sqCategoria", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_categoria")
	private int id;
	
	@Column(name="ds_categoria")
	private String nome;

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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

	
}
