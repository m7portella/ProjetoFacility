package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="F_ATIVIDADE")
@SequenceGenerator(name="seqAtividade", schema="SQ_F_ATIVIDADE", allocationSize=1)
public class Atividade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seqAtividade", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_atividade")
	private Integer id;
	
	@Column(name="ds_atividade", length=60, nullable=false)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cd_categoria", nullable=false)
	private Categoria categoria;
	
	public Atividade() {
		super();
	}

	public Atividade(int id, String nome, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	@Override
    public boolean equals(Object obj) {
            if(obj == null)
                    return false;
            if(!(obj instanceof Atividade))
                    return false;
            return ((Atividade)obj).getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

	
}
