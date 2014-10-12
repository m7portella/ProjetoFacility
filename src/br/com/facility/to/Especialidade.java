package br.com.facility.to;

import java.io.Serializable;

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
@Table(name="F_ESPECIALIDADE")
@SequenceGenerator(name="seqEspecialidade", schema="SQ_F_ESPECIALIDADE", allocationSize=1)
public class Especialidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="seqEspecialidade", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_especialidade")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="cd_atividade")
	private Atividade atividade;
	
	@Column(name="nm_especialidade", length=60, nullable=false)
	private String nome;

	public Especialidade() {
		super();
	}

	public Especialidade(int id, Atividade atividade, String nome) {
		super();
		this.id = id;
		this.atividade = atividade;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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
            if(!(obj instanceof Especialidade))
                    return false;
            return ((Especialidade)obj).getId().equals(this.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
