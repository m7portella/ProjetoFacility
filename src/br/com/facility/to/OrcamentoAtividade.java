package br.com.facility.to;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="F_ORCAMENTO_ATIVIDADE")
@IdClass(OrcamentoAtividadePK.class)
public class OrcamentoAtividade implements Serializable {

	@Id
	@ManyToOne	
	private Orcamento orcamento;
	
	@Id
	@ManyToOne
	@JoinColumn(name="cd_negociacao_ativ")
	private NegociacaoAtividade negociacaoAtividade;
	
	@Column(name="nr_item", nullable=false, length=2)
	private int item;
	
	@Column(name="ds_orcamento_atividade", length=200)
	private String descricao;
	
	@Column(name="qt_horas")
	private int qtdeHoras;
	
	@Column(name="vl_orcamento_ativ")
	private int valor;

	public OrcamentoAtividade() {
		super();
	}

	public OrcamentoAtividade(Orcamento orcamento,
			NegociacaoAtividade negociacaoAtividade, int item,
			String descricao, int qtdeHoras) {
		super();
		this.orcamento = orcamento;
		this.negociacaoAtividade = negociacaoAtividade;
		this.item = item;
		this.descricao = descricao;
		this.qtdeHoras = qtdeHoras;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public NegociacaoAtividade getNegociacaoAtividade() {
		return negociacaoAtividade;
	}

	public void setNegociacaoAtividade(NegociacaoAtividade negociacaoAtividade) {
		this.negociacaoAtividade = negociacaoAtividade;
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdeHoras() {
		return qtdeHoras;
	}

	public void setQtdeHoras(int qtdeHoras) {
		this.qtdeHoras = qtdeHoras;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}


	
}
