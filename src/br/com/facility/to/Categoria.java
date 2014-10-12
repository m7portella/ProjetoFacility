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
	private Integer id;
	
	@Column(name="ds_categoria")
	private String nome;

	public Categoria() {
		super();
	}

	public Categoria(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
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
	
	@Override
    public boolean equals(Object obj) {
            if(obj == null)
                    return false;
            if(!(obj instanceof Categoria))
                    return false;
            return ((Categoria)obj).getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

	
}
