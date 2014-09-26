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

import br.com.facility.enums.TipoAtividadeEspecialidade;

@Entity
@Table(name="F_NEGOCIACAO_ATIVIDADE")
@SequenceGenerator(name="sq_negociacao_ativ", sequenceName="SQ_F_NEGOCIACAO_ATIV", allocationSize=1)
public class NegociacaoAtividade implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8174351763945752314L;

	@Id
	@Column(name="cd_negociacao_ativ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_negociacao_ativ")
	private long id;
	
	@ManyToOne
	@JoinColumn(name="nr_protocolo")
	private Negociacao negociacao;
	
	@ManyToOne
	@JoinColumn(name="cd_atividade", nullable=false)
	private Atividade atividade;
	
	@ManyToOne
	@JoinColumn(name="cd_especialidade")
	private Especialidade especialidade;
	
	@Column(name="nr_item", nullable=false)
	private int item;
	
	@Column(name="cd_tipo", nullable=false)
	private TipoAtividadeEspecialidade tipo;
	
	@Column(name="vl_item", columnDefinition="float")
	private double valor;

	public NegociacaoAtividade() {
		super();
	}

	public NegociacaoAtividade(long id, Negociacao negociacao,
			Atividade atividade, Especialidade especialidade, int item,
			TipoAtividadeEspecialidade tipo, double valor) {
		super();
		this.id = id;
		this.negociacao = negociacao;
		this.atividade = atividade;
		this.especialidade = especialidade;
		this.item = item;
		this.tipo = tipo;
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Negociacao getNegociacao() {
		return negociacao;
	}

	public void setNegociacao(Negociacao negociacao) {
		this.negociacao = negociacao;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public TipoAtividadeEspecialidade getTipo() {
		return tipo;
	}

	public void setTipo(TipoAtividadeEspecialidade tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	
	
}
