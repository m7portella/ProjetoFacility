package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.facility.enums.TipoAtividadeEspecialidade;

@Entity
@Table(name="F_NEGOCIACAO_ATIVIDADE")
@IdClass(NegociacaoAtividadePK.class)
public class NegociacaoAtividade implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8174351763945752314L;

	@Id
	@Column(name="cd_negociacao_ativ")
	@SequenceGenerator(name="sq_negociacao_ativ", sequenceName="SQ_F_NEGOCIACAO_ATIV", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_negociacao_ativ")
	private long codigo;
	
	@Id
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
	
	@Column(name="vl_item")
	private double valor;

	public NegociacaoAtividade() {
		super();
	}

	public NegociacaoAtividade(long codigo, Negociacao negociacao,
			Atividade atividade, Especialidade especialidade, int item,
			TipoAtividadeEspecialidade tipo, double valor) {
		super();
		this.codigo = codigo;
		this.negociacao = negociacao;
		this.atividade = atividade;
		this.especialidade = especialidade;
		this.item = item;
		this.tipo = tipo;
		this.valor = valor;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
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
